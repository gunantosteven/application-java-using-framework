/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.service.impl;

import com.nar.dao.MasterAkunDao;
import com.nar.model.MasterAkun;
import com.nar.service.MasterAkunService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Steven Gunanto
 */
@Service("masterAkunService")
@Transactional(readOnly=true)
public class MasterAkunServiceImpl implements MasterAkunService {

    @Autowired private MasterAkunDao masterAkunDao;
    
    @Transactional(readOnly=false)
    @Override
    public MasterAkun save(MasterAkun masterAkun) {
        return masterAkunDao.save(masterAkun);
    }

    @Transactional(readOnly=false)
    @Override
    public MasterAkun delete(MasterAkun masterAkun) {
        return masterAkunDao.delete(masterAkun);
    }

    @Override
    public MasterAkun getMasterAkun(String nomerAkun) {
        return masterAkunDao.getById(nomerAkun);
    }

    @Override
    public List<MasterAkun> getListMasterAkun() {
        return masterAkunDao.getAll();
    }

    @Override
    public List<MasterAkun> getAkuns(String kodeAkun) {
        return masterAkunDao.getAkuns(kodeAkun);
    }
    
}
