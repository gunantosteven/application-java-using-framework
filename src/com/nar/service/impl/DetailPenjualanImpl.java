/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.service.impl;

import com.nar.dao.DetailPenjualanDao;
import com.nar.model.DetailPenjualan;
import com.nar.service.DetailPenjualanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("detailPenjualanService")
@Transactional(readOnly=true)
public class DetailPenjualanImpl implements DetailPenjualanService
{
    @Autowired private DetailPenjualanDao detailPenjualanDao;
    
    @Transactional(readOnly=false)
    public DetailPenjualan save(DetailPenjualan barang)
    {
        return detailPenjualanDao.save(barang);
    }
//    @Transactional(readOnly=false)
//    public void update(String id, DetailPenjualan barang)
//    {
//        detailPenjualanDao.update(id, barang);
//    }
    @Transactional(readOnly=false)
    public DetailPenjualan delete(DetailPenjualan barang)
    {
        return detailPenjualanDao.delete(barang);
    }
    public DetailPenjualan getDetailPenjualan(int id)
    {
        return detailPenjualanDao.getById(id);
    }
    
    public List<DetailPenjualan> getDetailPenjualans(int start, int num)
    {
        return detailPenjualanDao.getAll(start, num);
    }

    @Override
    public List<DetailPenjualan> getDetailsPenjualan() {
        return detailPenjualanDao.getAll();
    }

    @Override
    public List<DetailPenjualan> getDetailsPenjualan(int noNota) {
        return detailPenjualanDao.getAll(noNota);
    }

    @Override
    public List sum(int noNota) {
        return detailPenjualanDao.sum(noNota);
    }
}
