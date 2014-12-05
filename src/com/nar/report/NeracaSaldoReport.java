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
public class NeracaSaldoReport {
    private long debit;
    private long kredit;

    public NeracaSaldoReport() {
    }

    public NeracaSaldoReport(long debit, long kredit) {
        this.debit = debit;
        this.kredit = kredit;
    }
    
    public long getDebit() {
        return debit;
    }

    public void setDebit(long debit) {
        this.debit = debit;
    }

    public long getKredit() {
        return kredit;
    }

    public void setKredit(long kredit) {
        this.kredit = kredit;
    }
}
