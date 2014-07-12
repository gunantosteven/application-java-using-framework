/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.dao;

import com.nar.model.Barang;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class BarangDao extends BaseDaoHibernate<Barang>
{    
    public Barang update(String kode, Barang barang)
    {
        sessionFactory.getCurrentSession()
            .createQuery("update Barang b set b.kodeBarang = ?, b.namaBarang = ?,"
         + " b.deskripsi = ?, b.satuan = ?, b.hargaJual = ?, b.stock = ? where b.barang = ?")
            .setParameter(0, barang.getKodeBarang())
            .setParameter(1, barang.getNamaBarang())
            .setParameter(2, barang.getDeskripsi())
            .setParameter(3, barang.getSatuan())
            .setParameter(4, barang.getHargaJual())
            .setParameter(5, barang.getStock())
            .setParameter(6,kode).executeUpdate();
        return barang;
    }
}
