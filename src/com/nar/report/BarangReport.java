/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.report;

/**
 *
 * @author gunanto
 */
public class BarangReport {
    private String kodeBarang;
    private String namaBarang;
    private String deskripsi;
    private String satuan;
    private Long stock;

    public BarangReport() {
    }

    public BarangReport(String kodeBarang, String namaBarang, String deskripsi, String satuan, Long stock) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.deskripsi = deskripsi;
        this.satuan = satuan;
        this.stock = stock;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}
