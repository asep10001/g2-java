import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadData {

    public String readData(String file) {
        String a = "";

        try {
            FileInputStream fin = new FileInputStream("./" + file);
            BufferedInputStream bin = new BufferedInputStream(fin);
            int i = 0;
            while ((i = bin.read()) != -1) {
                a += ((char) i);
            }
            bin.close();
            fin.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        // System.out.println(a);
        return a;
    }

}
