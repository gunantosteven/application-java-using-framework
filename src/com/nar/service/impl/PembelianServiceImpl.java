/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.service.impl;

import com.nar.dao.PembelianDao;
import com.nar.model.Pembelian;
import com.nar.service.PembelianService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Steven Gunanto
 */
@Service("pembelianService")
@Transactional(readOnly=true)
public class PembelianServiceImpl implements PembelianService 
{
    @Autowired private PembelianDao pembelianDao;
    
    @Override
    @Transactional(readOnly=false)
    public Pembelian save(Pembelian pembelian) {
        return pembelianDao.save(pembelian);
    }

    @Override
    @Transactional(readOnly=false)
    public Pembelian delete(Pembelian pembelian) {
        return pembelianDao.delete(pembelian);
    }

    @Override
    public Pembelian getPembelian(int id) {
        return pembelianDao.getById(id);
    }

    @Override
    public List<Pembelian> getListPembelian() {
        return pembelianDao.getAll();
    }
    
}
