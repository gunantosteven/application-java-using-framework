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
public class ArusKasReport {
    private Date tanggal;
    private String faktur;
    private Long debit;
    private Long kredit;
    private String operator;

    public ArusKasReport() {
    }

    public ArusKasReport(Date tanggal, String faktur, Long debit, Long kredit, String operator) {
        this.tanggal = tanggal;
        this.faktur = faktur;
        this.debit = debit;
        this.kredit = kredit;
        this.operator = operator;
    }

    public Long getDebit() {
        return debit;
    }

    public void setDebit(Long debit) {
        this.debit = debit;
    }

    public String getFaktur() {
        return faktur;
    }

    public void setFaktur(String faktur) {
        this.faktur = faktur;
    }

    public Long getKredit() {
        return kredit;
    }

    public void setKredit(Long kredit) {
        this.kredit = kredit;
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
