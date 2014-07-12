/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.service;

import com.nar.model.DetailPenjualan;
import java.util.List;


public interface DetailPenjualanService 
{
    public DetailPenjualan save(DetailPenjualan detailPenjualan);
    //public void update(DetailPenjualan detailPenjualan);
    public DetailPenjualan delete(DetailPenjualan detailPenjualan);
    public DetailPenjualan getDetailPenjualan(int id);
    public List<DetailPenjualan> getDetailsPenjualan();
    public List<DetailPenjualan> getDetailsPenjualan(int noNota);
    public List sum(int noNota);
}
