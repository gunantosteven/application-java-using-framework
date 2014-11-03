/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.service.impl;

import com.nar.dao.PenjualanDao;
import com.nar.model.Penjualan;
import com.nar.service.PenjualanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("penjualanService")
@Transactional(readOnly=true)
public class PenjualanServiceImpl implements PenjualanService
{
    @Autowired private PenjualanDao penjualanDao;
    
    @Override
    @Transactional(readOnly=false)
    public Penjualan save(Penjualan penjualan) {
        return penjualanDao.save(penjualan);
    }

    @Override
    @Transactional(readOnly=false)
    public Penjualan delete(Penjualan penjualan) {
        return penjualanDao.delete(penjualan);
    }

    @Override
    public Penjualan getPenjualan(int id) {
        return  penjualanDao.getById(id);
    }

    @Override
    public List<Penjualan> getListPenjualan() {
        return penjualanDao.getAll();
    }
}
