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
public class BiayaReport {
    private String namaAkun;
    private long saldo;

    public BiayaReport() {
    }

    public BiayaReport(String namaAkun, long saldo) {
        this.namaAkun = namaAkun;
        this.saldo = saldo;
    }

    public String getNamaAkun() {
        return namaAkun;
    }

    public void setNamaAkun(String namaAkun) {
        this.namaAkun = namaAkun;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }   
}
