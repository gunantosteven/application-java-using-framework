/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.report;


/**
 *
 * @author ifnu
 */
public class DailyPenjualanReport {

    private String kodeBarang;

    private long jumlahBarang;

    private long subTotal;
    
    private long hargaSatuan;

    public long getHargaSatuan() {
        return hargaSatuan;
    }

    public long getJumlahBarang() {
        return jumlahBarang;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public long getSubTotal() {
        return subTotal;
    }

    public void setHargaSatuan(long hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }
    
    public void setJumlahBarang(long jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public void setSubTotal(long subTotal) {
        this.subTotal = subTotal;
    }
}
