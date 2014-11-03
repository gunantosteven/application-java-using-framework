/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.dao;

import com.nar.model.JurnalUmum;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Steven Gunanto
 */
@Component
public class JurnalUmumDao extends BaseDaoHibernate<JurnalUmum>
{
    public List<JurnalUmum> getJurnalUmumBetween(Date mulai, Date sampai)
    {
        return sessionFactory.getCurrentSession()
            .createQuery("from JurnalUmum j where j.tanggal between :mulai AND :sampai")
            .setParameter("mulai", mulai)
            .setParameter("sampai", sampai).list();
    }
    
    public List<JurnalUmum> getJurnalUmumBetween(String kodeAkun,Date mulai, Date sampai)
    {
        return sessionFactory.getCurrentSession()
            .createQuery("from JurnalUmum j where j.tanggal between :mulai AND :sampai AND j.masterAkun.kodeAkun like :kodeAkun")
            .setParameter("mulai", mulai)
            .setParameter("sampai", sampai)
            .setParameter("kodeAkun", kodeAkun).list();
    }
    
    public Date getOldestDate()
    {
        List<JurnalUmum> listJurnalUmum = sessionFactory.getCurrentSession()
                .createQuery("from JurnalUmum j order by j.tanggal asc").list();
        return listJurnalUmum.size() > 0 ? listJurnalUmum.get(0).getTanggal() : new Date();
    }
    
    public void delete(String faktur)
    {
        sessionFactory.getCurrentSession()
            .createQuery("delete from JurnalUmum j where j.faktur like :faktur")
            .setParameter("faktur", faktur).executeUpdate();
    }
}
