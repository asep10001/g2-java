/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author B40
 */
import java.util.ArrayList;
import java.util.Objects;

public class Mahasiswa {

    Integer ID;
    String Nama;
    ArrayList<Double> Nilai;

    public Mahasiswa() {
        this.Nilai = new ArrayList<>();
    }

    public void createMahasiswa(Integer id, String nama, ArrayList<Double> Nilai) {
        this.ID = id;
        this.Nama = nama;
        this.Nilai = Nilai;
    }

    public boolean checkAva(Integer id, ArrayList<Mahasiswa> a) {
        boolean isAvailable = true;
        for (int i = 0; i < a.size(); i++) {
            ArrayList<Integer> tempList = new ArrayList<>();
            tempList.add(a.get(i).getID());
            Integer[] temp = tempList.toArray(new Integer[0]);
            for (Integer temp1 : temp) {
                isAvailable = !Objects.equals(temp[0], id);
            }

        }
        return isAvailable;
    }

    public Integer[] sortingArray(ArrayList<Mahasiswa> a) {
        ArrayList<Integer> indexAllMahasiswa;
        indexAllMahasiswa = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            indexAllMahasiswa.add(a.get(i).getID());

        }
        Integer[] indexToArray = new Integer[indexAllMahasiswa.size()];
        indexToArray = indexAllMahasiswa.toArray(indexToArray);
//        for (Integer el : indexToArray) {
////            System.out.println(el);
//
//        }
        return indexToArray;
    }

    public Integer[] bubleSorting(Integer[] indexToArray, ArrayList<Mahasiswa> a) {
        // bubleSorting
        for (int i = 0; i < indexToArray.length - 1; i++) {
            for (int j = 0; j < indexToArray.length - 1 - i; j++) {
//                System.out.println("indexToArray[j + 1] = " + indexToArray[j + 1]);
//                System.out.println("indexToArray[j] = " + indexToArray[j]);
                if (indexToArray[j + 1] < indexToArray[j]) {
                    Mahasiswa temp = a.get(j);
                    int tempInd = indexToArray[j];
                    a.set(j, a.get(j + 1));
                    indexToArray[j] = indexToArray[j + 1];
                    a.set(j + 1, temp);
                    indexToArray[j + 1] = tempInd;
                }
            }
        }
        return indexToArray;
    }

    public Mahasiswa loopingForIndex(Integer ind, Integer[] a, ArrayList<Mahasiswa> arr) {
        Integer index = 0;

        // binary search
        int target = ind; // the element to be searched
        int left = 0;
        int middle;
        int right = a.length - 1;

        while (left <= right) {
            middle = (left + right) / 2;
            if (a[middle] == target) {
//                System.out.println(a[middle] == target);
//                System.out.println("Element found at index " + middle);
                index = middle;
                break;
            } else if (a[middle] < target) {
                left = middle + 1;
            } else if (a[middle] > target) {
                right = middle - 1;
            }
        }

        return arr.get(index);

    }

    public void listData(ArrayList<Mahasiswa> a) {
        Integer[] inta = sortingArray(a);
        bubleSorting(inta, a);

        System.out.println("+-------+--------------------------+--------------+--------------+---------------+");
        System.out.println("|  ID   | Nama                     | B.Inggris    | Fisika       | Algoritma     |");
        System.out.println("+-------+--------------------------+--------------+--------------+---------------+");
        for (int i = 0; i < a.size(); i++) {
            System.out.format("|%5d", a.get(i).getID());
            System.out.format("%4s", "| ");
            System.out.format("%-24s", a.get(i).getNama());
            System.out.format("%3s", "| ");
            System.out.format("%-12s", a.get(i).getNilai().get(0));
            System.out.format("%3s", "| ");
            System.out.format("%-12s", a.get(i).getNilai().get(1));
            System.out.format("%3s", "| ");
            System.out.format("%-12s", a.get(i).getNilai().get(2));
            System.out.format("%3s\n", "|");
        }
        System.out.println("+-------+--------------------------+--------------+--------------+---------------+");

    }

    public Integer getID() {
        return ID;
    }

    public String getNama() {
        return Nama;
    }

    public ArrayList<Double> getNilai() {
        return Nilai;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public void setNilai(ArrayList<Double> Nilai) {
        this.Nilai = Nilai;
    }

}