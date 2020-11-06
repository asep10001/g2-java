import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class ClientApp {

    public static void main(String[] args) {
        Properties prop = new Properties();
        Scanner input = new Scanner(System.in);

        // login Client
        CheckEmail c = new CheckEmail();
        CheckPassword d = new CheckPassword();
        String userEmail = "";
        String userPassword = "";
        String ulang = "Y";

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
            System.out.println(" ");
            // membuat interface menu pada console
            System.out.println("********** SELAMAT " + userEmail.toUpperCase() + " ANDA BERHASIL LOGIN ***********");
            System.out.println(" ");
            program: while (ulang.equals("Y")) {

                System.out.println("             MENU UTAMA             ");
                System.out.println("1. Open Socket");
                System.out.println("2. Input Data to Server");
                System.out.println("3. Close Socket");
                System.out.println("4. Exit");
                System.out.println("=====================================");
                // pilihan menu pada konsol
                System.out.print("Pilihan [1/2/3/4] = ");
                // mengambil input user
                // try {
                // try {

                int pilih = Integer.parseInt((input.nextLine()));
                System.out.println("=====================================");

                // load port and server

                String server = prop.getProperty("server");
                Integer port = Integer.parseInt(prop.getProperty("port"));

                // connect socket
                Socket s = new Socket(server, port);
                // dataOutputStream
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                // read responds
                DataInputStream doin = new DataInputStream(s.getInputStream());
                switch (pilih) {

                    case 1:

                        // notify the connection
                        System.out.println("connected!");
                        break;
                    // } catch (Exception e) {
                    // System.out.println(e.getMessage());
                    // break;

                    // }
                    case 2:
                        try {

                            System.out.println("Silahkan masukan nama file dengan extension .txt");
                            String fileName = input.nextLine();
                            // send the data

                            dout.writeUTF(fileName);

                            String serverRespond = doin.readUTF();
                            System.out.println(serverRespond);
                            dout.flush();
                            break;

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            break;
                        }

                    case 3:
                        try {

                            dout.writeUTF("EXIT");
                            // // closin dataoutput
                            dout.close();
                            // closing socket
                            s.close();

                            System.out.println("Successfully closed! Bye!");
                            break;

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            break;
                        }

                    case 4:
                        break program;
                    default:
                        break program;
                }
                // } catch (Exception e) {
                // System.out.println(e.getMessage());
                // }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        } else {
        System.out.println("Maaf format email atau password anda kurang tepat");
        }

    }
}
