import java.io.*;
import java.net.*;
import java.util.Properties;
import java.util.Scanner;

public class MyServer {
    public static void main(String[] args) {
        Properties prop = new Properties();
        try {
            FileInputStream bacaConfig = new FileInputStream(args[0]);

            // load a property file
            prop.load(bacaConfig);
            // dapatkan port value dan maskan kedalam socket
            // rubah getProperty String menjadi int
            int port = Integer.parseInt(prop.getProperty("port"));
            ServerSocket ss = new ServerSocket(port);
            Socket s = ss.accept();// establishes connection
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            System.out.println("Selamat datang di aplikasi chattingan ssaya");
            boolean isExit = false;
            Scanner input = new Scanner(System.in);

            while (isExit == false) {

                try {
                    String chatServer = (String) dis.readUTF();
                    System.out.println("pesan dari client: " + chatServer);

                    System.out.println("silahkan isi pesan anda");
                    String pesan = input.nextLine();
                    dout.writeUTF(pesan);

                    dout.flush();
                    if (pesan.toUpperCase().equals("EXIT")) {
                        dout.writeUTF("teman chatting anda sudah meninggalkan server");
                        System.out.println("anda telah meninggalkan server");
                        isExit = true;
                        dout.close();
                        s.close();
                    } else {
                        isExit = false;
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
