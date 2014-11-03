/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.service;

import com.nar.model.Penjualan;
import java.util.List;


public interface PenjualanService
{
    public Penjualan save(Penjualan penjualan);
    public Penjualan delete(Penjualan penjualan);
    public Penjualan getPenjualan(int id);
    public List<Penjualan> getListPenjualan();
}
