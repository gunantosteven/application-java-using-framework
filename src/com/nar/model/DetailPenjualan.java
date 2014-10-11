/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="T_DETAIL_PENJUALAN")
public class DetailPenjualan 
{
    @Id  @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name="PENJUALAN_DETAILPENJUALAN")
    private Penjualan penjualan;
    
    @ManyToOne
    @JoinColumn(name="BARANG_ID")
    private Barang barang;
    
    @Column(name="jumlah_barang")
    private long jumlahBarang;
    
    @Column(name="harga_satuan")
    private int hargaSatuan;
    
    @Column(name="total")
    private long subTotal;

    public int getId() {
        return id;
    }

    public Barang getBarang() {
        return barang;
    }
    
    public Penjualan getPenjualan() {
        return penjualan;
    }
    
    public int getHargaSatuan() {
        return hargaSatuan;
    }
    
    public long getJumlahBarang() {
        return jumlahBarang;
    }

    public long getSubTotal() {
        return subTotal;
    }

    public void setPenjualan(Penjualan penjualan) {
        this.penjualan = penjualan;
    }

    public void setHargaSatuan(int hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public void setJumlahBarang(long jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public void setSubTotal(long subTotal) {
        this.subTotal = subTotal;
    }

    public void setId(int id) {
        this.id = id;
    }
}
