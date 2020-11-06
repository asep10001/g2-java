import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class ServerApp {

    public static void main(String[] args) {
        Properties prop = new Properties();
        Scanner input = new Scanner(System.in);

        // login Client
        CheckEmail c = new CheckEmail();
        CheckPassword d = new CheckPassword();
        String userEmail = "";
        String userPassword = "";

        ArrayList<Mahasiswa> allMahasiswa = new ArrayList<>();
        // pesan selamat datang di awal
        System.out.println("Selamat datang !!!");
        System.out.println("Silahkan lakukan login dgn email dan password");
        try {
            System.out.print("Email : ");
            userEmail = input.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.print("Password : ");
            userPassword = input.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (c.checkEmail(userEmail) && d.checkPassword(userPassword)) {

            try {
                FileInputStream fin = new FileInputStream(args[0]);

                prop.load(fin);

                // load port and server

                String server = prop.getProperty("server");
                Integer port = Integer.parseInt(prop.getProperty("port"));

                // connect socket
                ServerSocket ss = new ServerSocket(port);

                // koneksi socket
                Socket s = ss.accept();

                // deklarasi object data output
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                // deklarasi object data input
                DataInputStream doin = new DataInputStream(s.getInputStream());

                boolean isExit = false;

                while (isExit == false) {

                    try {
                        // waiting for client
                        System.out.println("waiting for the data");
                        // receive the data put it into a variable
                        String dataFile = (String) doin.readUTF();

                        // inisialisasi objek ReadData
                        ReadData read = new ReadData();
                        // membaca data dari client dan memasukannya ke dalam sebuah variable
                        String dataClient = read.readData(dataFile);
                        // membuat ArrayList<Mahasiswa>
                        Mahasiswa student = new Mahasiswa();
                        // createMahasiswa
                        student.makeDataMahasiswa(allMahasiswa, dataClient);
                        // print the data
                        student.printData(allMahasiswa);
                        // notified the client that the process is done

                        dout.writeUTF("The process is done sucessfully!!");

                        dout.flush();

                        if (dataFile.equals("EXIT")) {
                            isExit = true;
                            dout.close();

                            s.close();
                            ss.close();
                        } else {
                            isExit = false;
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
                dout.close();
                s.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else {
            System.out.println("Maaf format email atau password anda kurang tepat");
        }

    }
}
