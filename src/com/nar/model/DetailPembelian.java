/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Steven Gunanto
 */
@Entity
@Table(name="T_DETAIL_PEMBELIAN")
public class DetailPembelian implements Serializable {
    @Id  @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name="PEMBELIAN_DETAILPEMBELIAN")
    private Pembelian pembelian;
    
    @ManyToOne
    @JoinColumn(name="BARANG_ID")
    private Barang barang;
    
    @Column(name="jumlah_barang")
    private long jumlahBarang;
    
    @Column(name="harga_satuan")
    private int hargaSatuan;
    
    @Column(name="total")
    private long subTotal;

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public int getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(int hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(long jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public Pembelian getPembelian() {
        return pembelian;
    }

    public void setPembelian(Pembelian pembelian) {
        this.pembelian = pembelian;
    }

    public long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(long subTotal) {
        this.subTotal = subTotal;
    }
}

