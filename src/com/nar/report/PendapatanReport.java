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
public class PendapatanReport {
    private long pendapatan;

    public PendapatanReport() {
    }

    public PendapatanReport(long pendapatan) {
        this.pendapatan = pendapatan;
    }

    public long getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(long pendapatan) {
        this.pendapatan = pendapatan;
    }
}
