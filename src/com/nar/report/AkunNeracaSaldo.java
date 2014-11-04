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
public class AkunNeracaSaldo {
    private String kodeAkun;
    private String namaAkun;
    private long debit;
    private long kredit;
    private char defaultAwal;

    public AkunNeracaSaldo() {
    }

    public AkunNeracaSaldo(String kodeAkun, String namaAkun, long debit, long kredit, char defaultAwal) {
        this.kodeAkun = kodeAkun;
        this.namaAkun = namaAkun;
        this.debit = debit;
        this.kredit = kredit;
        this.defaultAwal = defaultAwal;
    }

    public char getDefaultAwal() {
        return defaultAwal;
    }

    public void setDefaultAwal(char defaultAwal) {
        this.defaultAwal = defaultAwal;
    }

    public long getDebit() {
        return debit;
    }

    public void setDebit(long debit) {
        this.debit = debit;
    }

    public String getKodeAkun() {
        return kodeAkun;
    }

    public void setKodeAkun(String kodeAkun) {
        this.kodeAkun = kodeAkun;
    }

    public long getKredit() {
        return kredit;
    }

    public void setKredit(long kredit) {
        this.kredit = kredit;
    }

    public String getNamaAkun() {
        return namaAkun;
    }

    public void setNamaAkun(String namaAkun) {
        this.namaAkun = namaAkun;
    }
}
