/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.dao;

import com.nar.model.DetailPembelian;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Steven Gunanto
 */
@Component
public class DetailPembelianDao extends BaseDaoHibernate<DetailPembelian>
{    
    @SuppressWarnings("unchecked")
    public List<DetailPembelian> getAll(String noFaktur) {
        return sessionFactory.getCurrentSession().createQuery("select d from DetailPembelian d where d.pembelian.noFaktur = :noFaktur")
                .setParameter("noFaktur", noFaktur).list();
    }

    public List sum(String noFaktur)
    {
        return sessionFactory.getCurrentSession().createQuery("select sum(d.subTotal) from DetailPembelian d  where d.pembelian.noFaktur = :noFaktur")
                .setParameter("noFaktur", noFaktur).list();
    }
}
