/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.dao;

import com.nar.model.MasterAkun;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Steven Gunanto
 */
@Component
public class MasterAkunDao extends BaseDaoHibernate<MasterAkun>
{
    public List<MasterAkun> getAkuns(String kodeAkun)
    {
        return sessionFactory.getCurrentSession()
            .createQuery("from MasterAkun where kodeAkun like :kodeAkun")
            .setParameter("kodeAkun", kodeAkun)
            .list();
    }
}
