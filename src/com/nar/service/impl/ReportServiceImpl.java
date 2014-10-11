/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.service.impl;


import com.nar.Main;
import com.nar.model.DetailPenjualan;
import com.nar.report.CustomerReport;
import com.nar.report.DailyPenjualanReport;
import com.nar.report.EmployeeReport;
import com.nar.report.NotaReport;
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
}
