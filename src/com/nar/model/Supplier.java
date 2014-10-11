/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Steven Gunanto
 */
@Entity
@Table(name="T_SUPPLIER")
public class Supplier implements Serializable
{
    @Id
    @Column(name="KODE_SUPPLIER")
    private String kodeSupplier;
    @Column(name="NAMA_SUPPLIER")
    private String namaSupplier;
    @Column(name="ALAMAT")
    private String alamat;
    @Column(name="NO_TELEPON")
    private String noTelepon;

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKodeSupplier() {
        return kodeSupplier;
    }

    public void setKodeSupplier(String kodeSupplier) {
        this.kodeSupplier = kodeSupplier;
    }

    public String getNamaSupplier() {
        return namaSupplier;
    }

    public void setNamaSupplier(String namaSupplier) {
        this.namaSupplier = namaSupplier;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }
}
