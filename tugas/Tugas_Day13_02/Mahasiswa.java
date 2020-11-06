import java.util.ArrayList;

public class Mahasiswa {
    String name;
    Integer nilaiA;
    Integer nilaiB;
    Integer nilaiC;

    public void createMahasiswa(String name, Integer nilaiA, Integer nilaiB, Integer nilaiC) {
        this.name = name;
        this.nilaiA = nilaiA;
        this.nilaiB = nilaiB;
        this.nilaiC = nilaiC;
    }

    // membuat sebuah method yang mengembalikan nilai arraylist seluruh mahasiswa
    // yang
    // sudah di update dari file data.txt
    // argumen data s merupakan object data yang akan di gunakan di dalam method
    // inisialisasi di lakukan di file main agar alamat object berbeda beda sesuai
    // dengan banyak nya array dari file
    public ArrayList<Mahasiswa> makeDataMahasiswa(ArrayList<Mahasiswa> allMahasiswa, String args) {

        // System.out.println(
        // args
        // );
        // String str = readData(args);
        String[] arrOfStr = args.split("[\r\n]+");

        for (int i = 0; i < arrOfStr.length; i++) {
            Mahasiswa s = new Mahasiswa();

            String[] arrDataMahasiswa = arrOfStr[i].split("[,]+");
            for (int j = 0; j < arrDataMahasiswa.length; j++) {
                s.createMahasiswa(arrDataMahasiswa[0], Integer.parseInt(arrDataMahasiswa[1]),
                        Integer.parseInt(arrDataMahasiswa[2]), Integer.parseInt(arrDataMahasiswa[3]));
            }
            // s.setTotalGaji(hitungTotalGaji());

            allMahasiswa.add(s);
        }

        return allMahasiswa;
    }

    public void printData(ArrayList<Mahasiswa> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.println("===================================");
            System.out.println("Nama : " + a.get(i).name);
            System.out.println("Nilai Fisika : " + a.get(i).nilaiA);
            System.out.println("Nilai Biologi: " + a.get(i).nilaiB);
            System.out.println("Nilai Kimia : " + a.get(i).nilaiC);
            System.out.println("===================================");
            System.out.println("");


        }
    }

}
