//import beberapa utility Array, object, scanner dan regex
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    //membuat instance scanner
    static Scanner input = new Scanner(System.in);
    //membuat arraylist object mahasiswa
    static ArrayList<Mahasiswa> allMahasiswa = new ArrayList<>();

    //method static checkemail dengan regex
    static boolean checkEmail(String data) {

        //pola email harus ....@.'.'...
        boolean email = Pattern.matches("\\w+@\\w+[.]\\D+", data);
        // boolean email = Pattern.matches("^(?=.+[0-9])(?=.+[a-z])(?=.+[A-Z])(?=.+[_.])@(?=.+[0-9])(?=.+[a-z])(?=.+[A-Z])[.](?=.+[a-z])(?=.+[A-Z])$", data);
        //\\w+@ semua huruf dan angka muncul sekali atau lebih di depan @
        //\\w+[.] semua huruf dan angka muncul sekali atau lebih di depan '.'
        //\\D+ semua huruf kecuali angka muncul sekali atau lebih
        return email;
    }

    static boolean checkPassword(String data) {
        //pattern regex untuk check password dari stackoverflow
        boolean password = Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", data);
        //^ merupakan awalan string
        //(?=.*[0-9]) minimal satu angka
        //(?=.*[a-z]) minimal satu huruf kecil
        //(?=.*[A-Z]) minimal satu huruf kapital
        //(?=.*[@#$%^&+=]) minimal satu karakter special
        //(?=\\S+$) tidak boleh ada whitespace
        // .{8,} paling sedikit 8 karakter atau lebih
        // $ merupakan ahiran string
        
        
        
        return password;
    }

    public static void main(String[] args) {
        String ulang = "Y";
        Integer id;
        String name;
        Double nilai1;
        Double nilai2;
        Double nilai3;
        System.out.println(" ");
        // membuat interface menu pada console
        System.out.println("********** SELAMAT DATANG ADMIN ***********");
        System.out.println(" ");
        System.out.println("Silahkan lakukan login terlebih dahulu");
        System.out.println("=====================================");
        // pilihan masukan email masukan a2h2hemingway@gmail.com
        System.out.print("Email = ");
        // mengambil input user 
        String email = input.nextLine();
        // pilihan masukan password masukan A5ep@gus
        System.out.print("Password = ");
        // mengambil input user
        String password = input.nextLine();
        System.out.println("=====================================");
        //check regex
        // jika memenuhi ambil string dari text
        if (checkEmail(email) && checkPassword(password)) {
            InputString fin = new InputString();

            //masukan string kedalam variable textemail dan textpassword
            String textEmail = fin.readEmail();
            String textPassword = fin.readPassword();

//            check email dan password apakah sesuai dengan yang ada di text
            if (email.equals(textEmail) && password.equals(textPassword)) {
                System.out.println(" ");
                // membuat interface menu pada console
                System.out.println("********** SELAMAT " + textEmail.toUpperCase() + " ANDA BERHASIL LOGIN ***********");
                System.out.println(" ");
                program:
                while (ulang.equals("Y")) {

                    System.out.println("             MENU UTAMA             ");
                    System.out.println("1. Input Mahasiswa");
                    System.out.println("2. Edit Data Mahasiswa");
                    System.out.println("3. Laporan Data Mahasiswa");
                    System.out.println("99. Exit");
                    System.out.println("=====================================");
                    // pilihan menu pada konsol
                    System.out.print("Pilihan [1/2/3/99] = ");
                    // mengambil input user
                    int pilih = Integer.parseInt((input.nextLine()));
                    System.out.println("=====================================");

                    switch (pilih) {
                        case 1:
                            String repeat;
                            do {
                                Mahasiswa a = new Mahasiswa();
                                System.out.println("Silahkan masukan id mahasiswa dengan angka : ");
                                id = Integer.parseInt(input.nextLine());
                                if (!a.checkAva(id, allMahasiswa)) {
                                    System.out.println("Maaf id sudah digunakan silahkan masukan id yang lain!!!");
                                    break;
                                } else {
                                    System.out.println("Silahkan masukan nama mahasiswa: ");
                                    name = input.nextLine();
                                    System.out.println("Silahkan masukan nilai mahasiswa dari 0.0 s/d 100.0! ");
                                    System.out.println("B. Inggris");
                                    nilai1 = Double.parseDouble(input.nextLine());
                                    System.out.println("Fisika");
                                    nilai2 = Double.parseDouble(input.nextLine());
                                    System.out.println("Algoritma");
                                    nilai3 = Double.parseDouble(input.nextLine());
                                    ArrayList<Double> nilaiMahasiswa = new ArrayList<>();
                                    nilaiMahasiswa.add(nilai1);
                                    nilaiMahasiswa.add(nilai2);
                                    nilaiMahasiswa.add(nilai3);
                                    a.createMahasiswa(id, name, nilaiMahasiswa);
                                    allMahasiswa.add(a);
                                }

                                // menanyakan apakah ingin menambahkan lagi?
                                System.out.println("Apakah anda ingin memasukan data lagi : (Y/N)?");
                                repeat = (input.nextLine()).toUpperCase();
                                // System.out.println(choose.equals("Y"));
                            } while (repeat.equals("Y"));
                            // jika tidak maka tampilkan data dan tawarkan untuk memilih menu lain
                            System.out.println("Apakah anda ingin memilih menu lain : (Y/N)?");
                            ulang = (input.nextLine()).toUpperCase();
                            break;
                        case 2:
                            Mahasiswa a = new Mahasiswa();
                            System.out.println("Silahkan masukan id mahasiswa dengan angka : ");
                            id = Integer.parseInt(input.nextLine());
                            if (!allMahasiswa.isEmpty()) {
                                Integer[] integerarr = a.sortingArray(allMahasiswa);
                                Integer[] intb = a.bubleSorting(integerarr, allMahasiswa);
                                Mahasiswa ini = a.loopingForIndex(id, intb, allMahasiswa);
                                if (Objects.equals(ini.getID(), id)) {
                                    System.out.println("Edit/ Hapus (1/2) : ");
                                    Integer chosen = Integer.parseInt(input.nextLine());

                                    switch (chosen) {
                                        case 1:
                                            System.out.println("Data dibawah ini akan di edit : ");
                                            System.out.println("Nama: " + ini.getNama() + ", ID: " + ini.getID());
                                            System.out.println("Silahkan masukan nama baru mahasiswa: ");
                                            name = input.nextLine();
                                            System.out.println("Silahkan masukan nilai mahasiswa dari 0.0 s/d 100.0! ");
                                            System.out.println("B. Inggris");
                                            nilai1 = Double.parseDouble(input.nextLine());
                                            System.out.println("Fisika");
                                            nilai2 = Double.parseDouble(input.nextLine());
                                            System.out.println("Algoritma");
                                            nilai3 = Double.parseDouble(input.nextLine());
                                            ArrayList<Double> nilaiMahasiswa = new ArrayList<>();
                                            nilaiMahasiswa.add(nilai1);
                                            nilaiMahasiswa.add(nilai2);
                                            nilaiMahasiswa.add(nilai3);

                                            ini.setID(id);
                                            ini.setNama(name);
                                            ini.setNilai(nilaiMahasiswa);
                                            break;
                                        case 2:
                                            System.out.println("Data dibawah ini berhasil di hapus : ");
                                            System.out.println("Nama: " + ini.getNama() + ", ID: " + ini.getID());

                                            allMahasiswa.remove(ini);
                                            break;
                                        default:
                                            break;
                                    }

                                } else {
                                    System.out.println("Siswa tidak ditemukan!");
                                }
                            } else {
                                System.out.println("Tidak ada data mahasiswa");
                                System.out.println("Silahkan masukan data terlebih dahulu dari menu");

                            }

                            break;
                        case 3:
                            Mahasiswa now = new Mahasiswa();
                            if (allMahasiswa.isEmpty()) {
                                System.out.println("Tidak ada data mahasiswa untuk di tampilkan.");
                                System.out.println("Silahkan masukan data terlebih dahulu dari menu");
                            } else {
                                now.listData(allMahasiswa);
                            }
                            break;
                        case 99:
                            break program;
                        default:
                            break program;
                    }
                }
            } else {
                //jika regex terpenuhi tapi passowrd dan email tidak cocok dari file
                System.out.println("Maaf Password atau Email yang anda  masukan tidak cocok!");
            }

        } else {
            //jika regex tidak terpenuhi
            System.out.println("Maaf Format Password atau Email yang anda masukan salah!!!");
            
            
        }

        System.out.println("Sampai jumpa lagi.");

    }
}