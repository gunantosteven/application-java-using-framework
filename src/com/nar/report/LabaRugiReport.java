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
public class LabaRugiReport {
    private long pendapatan;
    private long biaya;

    public LabaRugiReport() {
    }

    public LabaRugiReport(long pendapatan, long biaya) {
        this.pendapatan = pendapatan;
        this.biaya = biaya;
    }

    public long getBiaya() {
        return biaya;
    }

    public void setBiaya(long biaya) {
        this.biaya = biaya;
    }

    public long getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(long pendapatan) {
        this.pendapatan = pendapatan;
    }
}
