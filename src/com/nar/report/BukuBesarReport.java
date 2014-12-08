/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.report;

import java.util.Date;

/**
 *
 * @author gunanto
 */
public class BukuBesarReport {
    private long kredit;
    private long debit;
    private String faktur;
    private Date tanggal;
    private String operator;
    private String namaakun;

    public BukuBesarReport() {
    }

    public BukuBesarReport(long kredit, long debit, String faktur, Date tanggal, String operator, String namaakun) {
        this.kredit = kredit;
        this.debit = debit;
        this.faktur = faktur;
        this.tanggal = tanggal;
        this.operator = operator;
        this.namaakun = namaakun;
    }
    
    

    public long getDebit() {
        return debit;
    }

    public void setDebit(long debit) {
        this.debit = debit;
    }

    public String getFaktur() {
        return faktur;
    }

    public void setFaktur(String faktur) {
        this.faktur = faktur;
    }

    public long getKredit() {
        return kredit;
    }

    public void setKredit(long kredit) {
        this.kredit = kredit;
    }

    public String getNamaakun() {
        return namaakun;
    }

    public void setNamaakun(String namaakun) {
        this.namaakun = namaakun;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
}
