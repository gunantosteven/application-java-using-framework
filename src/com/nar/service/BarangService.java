/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.service;

import com.nar.model.Barang;
import com.nar.model.DetailPembelian;
import com.nar.model.DetailPenjualan;
import java.util.List;


public interface BarangService 
{
    public Barang save(Barang barang);
    public void update(String id,Barang barang);
    public Barang delete(Barang barang);
    public Barang getBarang(String id);
    public List<Barang> getBarangs();
    public void kurangStock(List<DetailPenjualan> listDetailPenjualan);
    public void tambahStock(List<DetailPembelian> listDetailPembelian);
}
