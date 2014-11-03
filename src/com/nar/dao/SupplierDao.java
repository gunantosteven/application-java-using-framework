/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.dao;

import com.nar.model.Supplier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Steven Gunanto
 */
@Component
public class SupplierDao extends BaseDaoHibernate<Supplier> {
    
    public Supplier update(String kode, Supplier supplier)
    {
        sessionFactory.getCurrentSession()
            .createQuery("update Supplier s set s.kodeSupplier = ?, s.namaSupplier = ?,"
         + " s.alamat = ?, s.noTelepon = ? where s.kodeSupplier = ?")
            .setParameter(0, supplier.getKodeSupplier())
            .setParameter(1, supplier.getNamaSupplier())
            .setParameter(2, supplier.getAlamat())
            .setParameter(3, supplier.getNoTelepon())
            .setParameter(4, kode).executeUpdate();
        return supplier;
    }
}
