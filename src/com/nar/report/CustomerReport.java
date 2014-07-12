/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.report;

/**
 *
 * @author Steven Gunanto
 */
public class CustomerReport {
    private String nip;
    private String nama;
    private String alamat;
    private String noTelp;

    public String getAlamat() {
        return alamat;
    }

    public String getNama() {
        return nama;
    }

    public String getNip() {
        return nip;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
}
