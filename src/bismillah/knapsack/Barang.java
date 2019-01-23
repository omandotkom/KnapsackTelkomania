/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bismillah.knapsack;

/**
 *
 * @author omandotkom
 */
public class Barang {
    private String namaBarang;
    private double profit;
    private double weight;
    private double X=0;
    
    public Barang(String namaBarang, int profit, int weight) {
        this.namaBarang = namaBarang;
        this.profit = profit;
        this.weight = weight;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public double getProfit() {
        return profit;
    }

    public double getWeight() {
        return weight;
    }

    public double getX() {
        return X;
    }

    public void setX(double z) {
        this.X = z;
    }
    
    @Override
    public String toString() {
    return namaBarang + "\n P: Rp." + profit + " W: " + weight + " Kg X: " + X + " P/W : " + this.getProfitWeightRatio();
    }

    public double getProfitWeightRatio() {
        return this.profit / this.weight;
    }
    
    
    
}
