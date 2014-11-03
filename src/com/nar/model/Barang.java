package com.nar.model;


import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Index;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
@Entity
@Table(name="T_BARANG")
public class Barang implements Serializable
{
    @Id 
    @Column(name="KODE_BARANG")
    private String kodeBarang;
    @Column(name="NAMA_BARANG",length=100)
    private String namaBarang;
    @Column(name="DESKRIPSI")
    private String deskripsi;
    @Column(name="SATUAN")
    private String satuan;
    @Column(name="HARGA_BELI")
    private int hargaBeli;
    @Column(name="HARGA_JUAL")
    private int hargaJual;
    @Column(name="STOCK")
    private long stock;

    public String getDeskripsi() {
        return deskripsi;
    }

    public int getHargaJual() {
        return hargaJual;
    }

    public int getHargaBeli() {
        return hargaBeli;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public String getSatuan() {
        return satuan;
    }

    public long getStock() {
        return stock;
    }
    
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setHargaJual(int hargaJual) {
        this.hargaJual = hargaJual;
    }

    public void setHargaBeli(int hargaBeli) {
        this.hargaBeli = hargaBeli;
    }
    
    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }
    
    public String toString()
    {
        return "Kode Barang : " + getKodeBarang() +
               "\nNama Barang : " + getNamaBarang() +
               "\nDeskripsi : " + getDeskripsi();
    }
}
