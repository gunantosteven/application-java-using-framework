/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.service.impl;

import com.nar.dao.JurnalUmumDao;
import com.nar.model.JurnalUmum;
import com.nar.service.JurnalUmumService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Steven Gunanto
 */
@Service("jurnalUmumService")
@Transactional(readOnly=true)
public class JurnalUmumServiceImpl implements JurnalUmumService {
    
    @Autowired private JurnalUmumDao jurnalUmumDao;

    @Override
    @Transactional(readOnly=false)
    public JurnalUmum save(JurnalUmum jurnalUmum) {
        return jurnalUmumDao.save(jurnalUmum);
    }

    @Override
    @Transactional(readOnly=false)
    public JurnalUmum delete(JurnalUmum jurnalUmum) {
        return jurnalUmumDao.delete(jurnalUmum);
    }

    @Override
    public JurnalUmum getJurnalUmum(int no) {
        return jurnalUmumDao.getById(no);
    }

    @Override
    public List<JurnalUmum> getListJurnalUmum() {
        return jurnalUmumDao.getAll();
    }

    @Override
    public List<JurnalUmum> getJurnalUmumBetween(Date mulai, Date sampai) {
        return jurnalUmumDao.getJurnalUmumBetween(mulai, sampai);
    }

    @Override
    public Date getOldestDate() {
        return jurnalUmumDao.getOldestDate();
    }

    @Override
    public List<JurnalUmum> getJurnalUmumBetween(String kodeAkun, Date mulai, Date sampai) {
        return jurnalUmumDao.getJurnalUmumBetween(kodeAkun, mulai, sampai);
    }

    @Transactional(readOnly=false)
    @Override
    public void delete(String faktur) {
        jurnalUmumDao.delete(faktur);
    }
}
