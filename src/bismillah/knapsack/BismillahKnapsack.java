/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bismillah.knapsack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author 16102126 Khalid Abdurrahman
 */
public class BismillahKnapsack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Bismillah semoga lancar yaa Allah

        //M adalah kapasitas knapsacknya
        double M = 5;
        final double M_2 = M;
        //tampilkan pesan
        System.out.println("Kapasitas Knapsack : " + M + " Kilogram");

        System.out.println("Percobaan dengan knapsack");
        List<Barang> listBarang = new ArrayList();
        List<Barang> Z = new ArrayList();
        listBarang.add(new Barang("Gula", 50000, 4));
        listBarang.add(new Barang("Tepung Sagu Super", 24000, 1));
        listBarang.add(new Barang("Garam Revina", 26000, 2));

        System.out.println("Daftar barang : ");
        display(listBarang);
        //melakukan sorting barang berdasarkan rasio profit / weight
        listBarang.sort(new Comparator<Barang>() {
            @Override
            public int compare(Barang t, Barang t1) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if (t.getProfitWeightRatio() == t1.getProfitWeightRatio()) {
                    return 0;
                }
                if (t.getProfitWeightRatio() > t1.getProfitWeightRatio()) {
                    return -1;
                }
                return 1;

            }

        });

        System.out.println("=====================================================");
        System.out.println("Daftar barang setelah di sorting berdasarkan rasio : ");
        display(listBarang);

        System.out.println("=====================================================");
        System.out.println("Proses pemuatan barang : ");
        double totalBobot = 0;
        double totalKeuntungan = 0;
        //Tahap menentukan barang mana yang dimasukan ke tas.
        for (int i = 0; i < listBarang.size(); i++) {
            if (M >= listBarang.get(i).getWeight()) {
                System.out.println("Menambahkan " + listBarang.get(i).getNamaBarang() + " ke pengiriman");
                System.out.println("Kapasitas : " + M + " - " + "Beban " + listBarang.get(i).getWeight());
                listBarang.get(i).setX(1);
                M = M - listBarang.get(i).getWeight();
                //totalBobot = totalBobot + listBarang.get(i).getWeight();
                //totalKeuntungan = totalKeuntungan + listBarang.get(i).getProfit();
                System.out.println("Kapasitas sekarang : " + M);

            } else {
                System.out.println("Menambahkan " + listBarang.get(i).getNamaBarang() + " ke pengiriman");
                double x = M / listBarang.get(i).getWeight();
                System.out.println("Kapasitas : " + M + " - " + "Beban " + (x * listBarang.get(i).getWeight()) + " dari " + listBarang.get(i).getWeight());

                listBarang.get(i).setX(x);
                M = M - (x * listBarang.get(i).getWeight());
                System.out.println("Kapasitas sekarang : " + M);
                break;
            }
        }

        System.out.println("=====================================================");
        System.out.println("Setelah dipilih mana yang dimasukan :");
        //Setelah filtering
        display(listBarang);

        System.out.println("=====================================================");
        System.out.println("Perhitungan fungsi pembatas : ");
        double pembatas = 0;
        double tujuan = 0;
        for (Barang barang : listBarang) {
            pembatas = pembatas + (barang.getWeight() * barang.getX());
            tujuan = tujuan + (barang.getProfit() * barang.getX());
        }
        System.out.println("Nilai pembatas : " + pembatas);
        System.out.println("Nilai tujuan : " + tujuan);
        //System.out.println("Total bobot : " + totalBobot);
        //System.out.println("Total keuntungan : " + totalKeuntungan);
    }

    private static void display(List<Barang> listBarang) {
        for (Barang b : listBarang) {
            System.out.println(b.toString());
        }
    }

}
