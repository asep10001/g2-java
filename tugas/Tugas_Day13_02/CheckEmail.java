import java.util.regex.Pattern;

public class CheckEmail {
    // method static checkemail dengan regex
    public boolean checkEmail(String data) {

        // pola email harus ....@.'.'...
        boolean email = Pattern.matches("\\w+@\\w+[.]\\D+", data);
        // boolean email =
        // Pattern.matches("^(?=.+[0-9])(?=.+[a-z])(?=.+[A-Z])(?=.+[_.])@(?=.+[0-9])(?=.+[a-z])(?=.+[A-Z])[.](?=.+[a-z])(?=.+[A-Z])$",
        // data);
        // \\w+@ semua huruf dan angka muncul sekali atau lebih di depan @
        // \\w+[.] semua huruf dan angka muncul sekali atau lebih di depan '.'
        // \\D+ semua huruf kecuali angka muncul sekali atau lebih
        return email;
    }
}
