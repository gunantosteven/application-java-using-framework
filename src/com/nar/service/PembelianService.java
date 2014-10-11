/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.service;

import com.nar.model.Pembelian;
import java.util.List;

/**
 *
 * @author Steven Gunanto
 */
public interface PembelianService {
    public Pembelian save(Pembelian pembelian);
    public Pembelian delete(Pembelian pembelian);
    public Pembelian getPembelian(int id);
    public List<Pembelian> getListPembelian();
}
