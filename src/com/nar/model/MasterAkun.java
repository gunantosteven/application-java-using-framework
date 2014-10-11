/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Steven Gunanto
 */
@Entity
@Table(name="T_MASTERAKUN")
public class MasterAkun {
    
    @Id 
    @Column(name="KODE_AKUN")
    private String kodeAkun;
    
    @Column(name="NAMA_AKUN")
    private String namaAkun;

    public String getKodeAkun() {
        return kodeAkun;
    }

    public void setKodeAkun(String kodeAkun) {
        this.kodeAkun = kodeAkun;
    }

    public String getNamaAkun() {
        return namaAkun;
    }

    public void setNamaAkun(String namaAkun) {
        this.namaAkun = namaAkun;
    }
}
