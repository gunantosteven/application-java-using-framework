/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.dao;

import com.nar.model.Barang;
import com.nar.model.DetailPembelian;
import com.nar.model.DetailPenjualan;
import java.util.Iterator;
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
         + " b.deskripsi = ?, b.satuan = ?, b.hargaBeli = ?, b.hargaJual = ?, b.stock = ? where b.kodeBarang = ?")
            .setParameter(0, barang.getKodeBarang())
            .setParameter(1, barang.getNamaBarang())
            .setParameter(2, barang.getDeskripsi())
            .setParameter(3, barang.getSatuan())
            .setParameter(4, barang.getHargaBeli())
            .setParameter(5, barang.getHargaJual())
            .setParameter(6, barang.getStock())
            .setParameter(7,kode).executeUpdate();
        return barang;
    }
    
    public void kurangStock(List<DetailPenjualan> listDetailPenjualan)
    {
        Iterator<DetailPenjualan> iterator = listDetailPenjualan.iterator();
        while(iterator.hasNext())
        {
            DetailPenjualan detailPenjualan = iterator.next();
            sessionFactory.getCurrentSession()
                    .createQuery("update Barang b set b.stock = b.stock - :jumlahBarang where b.kodeBarang = :kodeBarang")
                    .setParameter("jumlahBarang", detailPenjualan.getJumlahBarang())
                    .setParameter("kodeBarang", detailPenjualan.getBarang().getKodeBarang())
                    .executeUpdate();
        }
    }
    
    public void tambahStock(List<DetailPembelian> listDetailPembelian)
    {
        Iterator<DetailPembelian> iterator = listDetailPembelian.iterator();
        while(iterator.hasNext())
        {
            DetailPembelian detailPembelian = iterator.next();
            sessionFactory.getCurrentSession()
                    .createQuery("update Barang b set b.stock = b.stock + :jumlahBarang where b.kodeBarang = :kodeBarang")
                    .setParameter("jumlahBarang", detailPembelian.getJumlahBarang())
                    .setParameter("kodeBarang", detailPembelian.getBarang().getKodeBarang())
                    .executeUpdate();
        }
    }
}
