import java.io.*;
import java.net.*;
import java.util.Properties;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        Properties prop = new Properties();

        try {
            FileInputStream bacaConfig = new FileInputStream(args[0]);

            // load a property
            prop.load(bacaConfig);
            // mendapatkan property value ip dan port
            String ip = prop.getProperty("server");
            int port = Integer.parseInt(prop.getProperty("port"));

            Socket s = new Socket(ip, port);

            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream doin = new DataInputStream(s.getInputStream());

            System.out.println("Selamat datang di aplikasi chattingan ssaya");
            boolean isExit = false;
            while (isExit == false) {

                try {
                    Scanner input = new Scanner(System.in);

                    System.out.println("silahkan isi pesan anda");
                    String pesan = input.nextLine();
                    dout.writeUTF(pesan);
                    String chatServer = (String) doin.readUTF();
                    System.out.println("pesan dari server:  " + chatServer);
                    dout.flush();
                    if (chatServer.toUpperCase().equals("EXIT")) {
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
