/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author B40
 */
public class InputString {

    public String readEmail() {
        String a = "";

        try {
            FileInputStream fin = new FileInputStream(
                    "./Email.txt");
            BufferedInputStream bin = new BufferedInputStream(fin);
            int i = 0;
            while ((i = bin.read()) != -1) {
                a += ((char) i);
            }
            bin.close();
            fin.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return a;
    }

    public String readPassword() {
        String a = "";

        try {
            FileInputStream fin = new FileInputStream(
                    "./Password.txt");
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
        return a;
    }
}