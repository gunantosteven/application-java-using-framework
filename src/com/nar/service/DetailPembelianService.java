/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.service;

import com.nar.model.DetailPembelian;
import java.util.List;

/**
 *
 * @author Steven Gunanto
 */
public interface DetailPembelianService {
    public DetailPembelian save(DetailPembelian detailPembelian);
    //public void update(DetailPenjualan detailPenjualan);
    public DetailPembelian delete(DetailPembelian detailPembelian);
    public DetailPembelian getDetailPembelian(int id);
    public List<DetailPembelian> getDetailsPembelian();
    public List<DetailPembelian> getDetailsPembelian(String noFaktur);
    public List sum(String noFaktur);
}
