/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.service.impl;

import com.nar.dao.BarangDao;
import com.nar.model.Barang;
import com.nar.service.BarangService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("barangService")
@Transactional(readOnly=true)
public class BarangServiceImpl implements BarangService
{
    @Autowired private BarangDao barangDao;
    
    @Transactional(readOnly=false)
    public Barang save(Barang barang)
    {
        return barangDao.save(barang);
    }@Transactional(readOnly=false)
    public void update(String id, Barang barang)
    {
        barangDao.update(id, barang);
    }
    @Transactional(readOnly=false)
    public Barang delete(Barang barang)
    {
        return barangDao.delete(barang);
    }
    public Barang getBarang(String id)
    {
        return barangDao.getById(id);
    }
    @Override
    public List<Barang> getBarangs() 
    {
        return barangDao.getAll();
    }
    
    public List<Barang> getBarangs(int start, int num)
    {
        return barangDao.getAll(start, num);
    }
}
