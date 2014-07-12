/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.report;

import com.nar.model.Jabatan;

/**
 *
 * @author Steven Gunanto
 */
public class EmployeeReport {
    private String nik;
    private String nama;
    private Jabatan jabatan;

    public Jabatan getJabatan() {
        return jabatan;
    }

    public String getNama() {
        return nama;
    }

    public String getNik() {
        return nik;
    }

    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }
}
