import java.util.regex.Pattern;

public class CheckPassword {
    public boolean checkPassword(String data) {
        // pattern regex untuk check password dari stackoverflow
        boolean password = Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", data);
        // ^ merupakan awalan string
        // (?=.*[0-9]) minimal satu angka
        // (?=.*[a-z]) minimal satu huruf kecil
        // (?=.*[A-Z]) minimal satu huruf kapital
        // (?=.*[@#$%^&+=]) minimal satu karakter special
        // (?=\\S+$) tidak boleh ada whitespace
        // .{8,} paling sedikit 8 karakter atau lebih
        // $ merupakan ahiran string

        return password;
    }
}
