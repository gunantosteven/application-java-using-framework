/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.report;

/**
 *
 * @author Steven Gunanto
 */
public class NotaReport {
    private int noNota;
    private String nik;
    private String nama;

    public String getNik() {
        return nik;
    }
    
    public String getNama() {
        return nama;
    }

    public int getNoNota() {
        return noNota;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoNota(int noNota) {
        this.noNota = noNota;
    }
}
