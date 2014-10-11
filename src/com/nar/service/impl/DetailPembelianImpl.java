/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.service.impl;

import com.nar.dao.DetailPembelianDao;
import com.nar.model.DetailPembelian;
import com.nar.service.DetailPembelianService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Steven Gunanto
 */
@Service("detailPembelianService")
@Transactional(readOnly=true)
public class DetailPembelianImpl implements DetailPembelianService {

    @Autowired private DetailPembelianDao detailPembelianDao;
    
    @Override
    @Transactional(readOnly=false)
    public DetailPembelian save(DetailPembelian detailPembelian) {
        return detailPembelianDao.save(detailPembelian);
    }

    @Override
    @Transactional(readOnly=false)
    public DetailPembelian delete(DetailPembelian detailPembelian) {
        return detailPembelianDao.delete(detailPembelian);
    }

    @Override
    public DetailPembelian getDetailPembelian(int id) {
        return detailPembelianDao.getById(id);
    }

    @Override
    public List<DetailPembelian> getDetailsPembelian() {
        return detailPembelianDao.getAll();
    }

    @Override
    public List<DetailPembelian> getDetailsPembelian(String noFaktur) {
        return detailPembelianDao.getAll(noFaktur);
    }

    @Override
    public List sum(String noFaktur) {
        return detailPembelianDao.sum(noFaktur);
    }
    
}
