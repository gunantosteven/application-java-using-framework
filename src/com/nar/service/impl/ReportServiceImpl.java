/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.service.impl;


import com.nar.Main;
import com.nar.model.DetailPenjualan;
import com.nar.report.AkunNeracaSaldo;
import com.nar.report.BarangReport;
import com.nar.report.BiayaReport;
import com.nar.report.CustomerReport;
import com.nar.report.DailyPembelianReport;
import com.nar.report.DailyPenjualanReport;
import com.nar.report.EmployeeReport;
import com.nar.report.LabaRugiReport;
import com.nar.report.NeracaSaldoReport;
import com.nar.report.NotaReport;
import com.nar.report.PendapatanReport;
import com.nar.report.SupplierReport;
import com.nar.service.ReportService;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.log4j.Logger;
import org.hibernate.PropertyAccessException;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ifnu
 */
@Service("reportService")
@Transactional(readOnly=true)
public class ReportServiceImpl implements ReportService{

    private static final Logger log = Logger.getLogger(ReportServiceImpl.class);
    @Autowired private SessionFactory sessionFactory;

    public JasperPrint getDailyPenjualanReport(Date date) {
        try{
            List<DailyPenjualanReport> dailyPenjualanReports =
                sessionFactory.getCurrentSession()
                    .createQuery("select d.barang.kodeBarang as kodeBarang, d.jumlahBarang as jumlahBarang, d.hargaSatuan as hargaSatuan, d.subTotal as subTotal from DetailPenjualan d  where day(d.penjualan.tanggalPenjualan) = day(:date)")
                    .setParameter("date", date)
                    .setResultTransformer(
                        Transformers.aliasToBean(DailyPenjualanReport.class))
                    .list();

            InputStream is = ReportServiceImpl.class
                    .getResourceAsStream("/reports/DailyPenjualanReport.jasper");

            Map<String,Object> parameters = new HashMap<String, Object>();
            parameters.put("date", date);

            return JasperFillManager.fillReport(is, parameters, 
                    new JRBeanCollectionDataSource(dailyPenjualanReports));
        }catch(JRException ex){
            log.error("error generate DailyPenjualanReport", ex);
        }
        return null;
    }

    @Override
    public JasperPrint getCustomerReport() {
        try
        {
            List<CustomerReport> customerReports = 
                    sessionFactory.getCurrentSession()
                    .createQuery("select c.nip as nip,c.nama as nama,c.alamat as alamat,c.noTelp as noTelp from Customer c")
                    .setResultTransformer(
                        Transformers.aliasToBean(CustomerReport.class))
                    .list();
            
            InputStream is = ReportServiceImpl.class
                    .getResourceAsStream("/reports/CustomerReport.jasper");
            
            return JasperFillManager.fillReport(is, null,
                    new JRBeanCollectionDataSource(customerReports));
        }
        catch(JRException ex) {
            log.error("error generate CustomerReport", ex);
        }
        return null;
    }

    @Override
    public JasperPrint getEmployeeReport() {
        try
        {
            List<EmployeeReport> employeeReports = 
                    sessionFactory.getCurrentSession()
                    .createQuery("select e.nik as nik,e.nama as nama,e.jabatan as jabatan  from Employee e")
                    .setResultTransformer(
                        Transformers.aliasToBean(EmployeeReport.class))
                    .list();
            
            InputStream is = ReportServiceImpl.class
                    .getResourceAsStream("/reports/EmployeeReport.jasper");
            
            return JasperFillManager.fillReport(is, null,
                    new JRBeanCollectionDataSource(employeeReports));
        }
        catch(JRException ex) {
            log.error("error generate EmployeeReport", ex);
        }
        return null;
    }

    @Override
    public JasperPrint getLabaRugi(Date dari, Date sampai) {
        try
        {
            List<LabaRugiReport> labaRugiReports = 
                    sessionFactory.getCurrentSession()
                    .createQuery("select sum( dp.jumlahBarang * (dp.hargaSatuan - b.hargaBeli)) as pendapatan, "
                            + "(select SUM(j.debit) from JurnalUmum j join j.masterAkun m where m.kodeAkun like '6%' and j.tanggal between :dari and :sampai) as biaya "
                            + "from DetailPenjualan dp join dp.barang b join dp.penjualan p where p.tanggalPenjualan between :dari and :sampai")
                    .setParameter("dari", dari)
                    .setParameter("sampai", sampai)
                    .setResultTransformer(
                    Transformers.aliasToBean(LabaRugiReport.class))
                    .list();
            
            InputStream is = ReportServiceImpl.class
                    .getResourceAsStream("/reports/laporanlabarugi.jasper");
            
            Map<String,Object> parameters = new HashMap<String, Object>();
            
            
            List<PendapatanReport> pendapatanReports = 
                    sessionFactory.getCurrentSession()
                    .createQuery("select sum( dp.jumlahBarang * (dp.hargaSatuan - b.hargaBeli)) as pendapatan from DetailPenjualan dp join dp.barang b join dp.penjualan p where p.tanggalPenjualan between :dari and :sampai")
                    .setParameter("dari", dari)
                    .setParameter("sampai", sampai)
                    .setResultTransformer(
                    Transformers.aliasToBean(PendapatanReport.class))
                    .list();
                   
            List<BiayaReport> biayaReports = 
                    sessionFactory.getCurrentSession()
                    .createQuery("select m.namaAkun as namaAkun, sum(j.debit) as saldo from JurnalUmum j join j.masterAkun m where m.kodeAkun like '6%' and j.tanggal between :dari and :sampai group by m.kodeAkun")
                    .setParameter("dari", dari)
                    .setParameter("sampai", sampai)
                    .setResultTransformer(
                    Transformers.aliasToBean(BiayaReport.class))
                    .list();
            
            parameters.put("subreport_pendapatan", new JRBeanCollectionDataSource(pendapatanReports));
            parameters.put("subreport_biaya", new JRBeanCollectionDataSource(biayaReports));
            parameters.put("dari", dari);
            parameters.put("sampai", sampai);
            parameters.put("SUBREPORT_pendapatan_DIR", ReportServiceImpl.class
                    .getResourceAsStream("/reports/laporanlabarugi_pendapatan.jasper"));
            parameters.put("SUBREPORT_biaya_DIR", ReportServiceImpl.class
                    .getResourceAsStream("/reports/laporanlabarugi_biaya.jasper"));
            
            return JasperFillManager.fillReport(is, parameters,
                    new JRBeanCollectionDataSource(labaRugiReports));
        }
        catch(PropertyAccessException ex)
        {
            log.error("error generate EmployeeReport", ex);
            JOptionPane.showMessageDialog(null, "Tidak ada data yang ditampilkan, periksa tanggal cetak atau \n Beban Biaya tidak ditemukan");
        }
        catch(JRException ex) {
            log.error("error generate EmployeeReport", ex);
        }
        return null;
    }

    @Override
    public JasperPrint getNeracaSaldo(Date dari, Date sampai) {
        try
        {
            List<NeracaSaldoReport> neracaSaldoReports = 
                    sessionFactory.getCurrentSession()
                    .createQuery("select (sum(j.debit) - sum(j.kredit)) as debit, (select (sum(ju.kredit) - sum(ju.debit))  from JurnalUmum ju join ju.masterAkun ma where ma.defaultAwal = 'K' and ju.tanggal between :dari and :sampai  ) as kredit from JurnalUmum j join j.masterAkun m where m.defaultAwal = 'D' and j.tanggal between :dari and :sampai")
                    .setParameter("dari", dari)
                    .setParameter("sampai", sampai)
                    .setResultTransformer(
                     Transformers.aliasToBean(NeracaSaldoReport.class))
                    .list();

            InputStream is = ReportServiceImpl.class
                    .getResourceAsStream("/reports/neracasaldo.jasper");
            
            Map<String,Object> parameters = new HashMap<String, Object>();
            
            List<AkunNeracaSaldo> akunNeracaSaldoReports = 
                    sessionFactory.getCurrentSession()
                    .createQuery("select  m.kodeAkun as kodeAkun, m.namaAkun as namaAkun, (SUM(j.debit) - SUM(j.kredit)) as debit, (SUM(j.kredit) - SUM(j.debit)) as kredit, m.defaultAwal as defaultAwal from JurnalUmum j join j.masterAkun m where j.tanggal between :dari and :sampai group by m.kodeAkun")
                    .setParameter("dari", dari)
                    .setParameter("sampai", sampai)
                    .setResultTransformer(
                     Transformers.aliasToBean(AkunNeracaSaldo.class))
                    .list();
            
            parameters.put("SUBREPORT_AKUN", new JRBeanCollectionDataSource(akunNeracaSaldoReports));
            parameters.put("dari", dari);
            parameters.put("sampai", sampai);
            parameters.put("SUBREPORT_akun_DIR", ReportServiceImpl.class
                    .getResourceAsStream("/reports/neracasaldo_akun.jasper"));
            
            return JasperFillManager.fillReport(is, parameters,
                    new JRBeanCollectionDataSource(neracaSaldoReports));
        }
        catch(PropertyAccessException ex)
        {
            log.error("error generate NeracaSaldo", ex);
            JOptionPane.showMessageDialog(null, "Tidak ada data yang ditampilkan, periksa tanggal cetak atau \n Beban Biaya tidak ditemukan");
        }
        catch(JRException ex) {
            log.error("error generate NeracaSaldo", ex);
        }
        return null;
    }

    @Override
    public JasperPrint getBarangReport() {
        try
        {
            List<BarangReport> barangReports = 
                    sessionFactory.getCurrentSession()
                    .createQuery("select b.kodeBarang as kodeBarang, b.namaBarang as namaBarang, b.deskripsi as deskripsi, b.satuan as satuan, b.stock as stock from Barang b")
                    .setResultTransformer(
                        Transformers.aliasToBean(BarangReport.class))
                    .list();
            
            InputStream is = ReportServiceImpl.class
                    .getResourceAsStream("/reports/BarangReport.jasper");
            
            return JasperFillManager.fillReport(is, null,
                    new JRBeanCollectionDataSource(barangReports));
        }
        catch(JRException ex) {
            log.error("error generate EmployeeReport", ex);
        }
        return null;
    }

    @Override
    public JasperPrint getSupplierReport() {
        try
        {
            List<SupplierReport> supplierReports = 
                    sessionFactory.getCurrentSession()
                    .createQuery("select s.kodeSupplier as kodeSupplier, s.namaSupplier as namaSupplier, s.alamat as alamat, s.noTelepon as noTelepon from Supplier s")
                    .setResultTransformer(
                        Transformers.aliasToBean(SupplierReport.class))
                    .list();
            
            InputStream is = ReportServiceImpl.class
                    .getResourceAsStream("/reports/SupplierReport.jasper");
            
            return JasperFillManager.fillReport(is, null,
                    new JRBeanCollectionDataSource(supplierReports));
        }
        catch(JRException ex) {
            log.error("error generate EmployeeReport", ex);
        }
        return null;
    }

    @Override
    public JasperPrint getDailyPembelianReport(Date date) {
        try{
            List<DailyPembelianReport> dailyPembelianReports =
                sessionFactory.getCurrentSession()
                    .createQuery("select d.barang.kodeBarang as kodeBarang, d.jumlahBarang as jumlahBarang, d.hargaSatuan as hargaSatuan, d.subTotal as subTotal from DetailPembelian d  where day(d.pembelian.tanggalPembelian) = day(:date)")
                    .setParameter("date", date)
                    .setResultTransformer(
                        Transformers.aliasToBean(DailyPembelianReport.class))
                    .list();

            InputStream is = ReportServiceImpl.class
                    .getResourceAsStream("/reports/DailyPembelianReport.jasper");

            Map<String,Object> parameters = new HashMap<String, Object>();
            parameters.put("date", date);

            return JasperFillManager.fillReport(is, parameters, 
                    new JRBeanCollectionDataSource(dailyPembelianReports));
        }catch(JRException ex){
            log.error("error generate DailyPembelianReports", ex);
        }
        return null;
    }
}
