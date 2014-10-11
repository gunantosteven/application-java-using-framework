/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.dao;

import com.nar.model.DetailPenjualan;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DetailPenjualanDao extends BaseDaoHibernate<DetailPenjualan>
{
    @SuppressWarnings("unchecked")
    public List<DetailPenjualan> getAll(int noNota) {
        return sessionFactory.getCurrentSession().createQuery("select d from DetailPenjualan d where d.penjualan.noNota = :noNota")
                .setParameter("noNota", noNota).list();
    }

    public List sum(int noNota)
    {
        return sessionFactory.getCurrentSession().createQuery("select sum(d.subTotal) from DetailPenjualan d  where d.penjualan.noNota = :noNota")
                .setParameter("noNota", noNota).list();
    }
}
