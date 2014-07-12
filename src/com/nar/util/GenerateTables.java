/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.util;


import com.nar.model.Admin;
import com.nar.model.Barang;
import com.nar.model.Customer;
import com.nar.model.DetailPenjualan;
import com.nar.model.Employee;
import com.nar.model.Jabatan;
import com.nar.model.JenisKelamin;
import com.nar.model.Marketing;
import com.nar.model.Nota;
import com.nar.model.Operator;
import com.nar.model.Penjualan;
import com.nar.model.Supervisor;
import com.nar.service.BarangService;
import com.nar.service.CustomerService;
import com.nar.service.DetailPenjualanService;
import com.nar.service.EmployeeService;
import com.nar.service.NotaService;
import com.nar.service.PenjualanService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.sql.DataSource;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class GenerateTables
{
    public static void main(String[] args) throws SQLException
    {
        AbstractApplicationContext appContext =
          new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        
        DataSource dataSource = (DataSource) appContext.getBean("dataSource");
        
        Configuration cfg = 
          new AnnotationConfiguration().configure("hibernate.cfg.xml");
        Connection conn = dataSource.getConnection();
          new SchemaExport(cfg, conn).create(true, true);
          
        BarangService barangService = 
          (BarangService) appContext.getBean("barangService");
        EmployeeService employeeService =
          (EmployeeService) appContext.getBean("employeeService");
        CustomerService customerService =
         (CustomerService) appContext.getBean("customerService");
        DetailPenjualanService detailPenjualanService = 
          (DetailPenjualanService) appContext.getBean("detailPenjualanService");
        PenjualanService penjualanService = 
           (PenjualanService) appContext.getBean("penjualanService");
        NotaService notaService = 
          (NotaService) appContext.getBean("notaService");
        
//        Barang b = new Barang();
//        b.setBarang("brng0001");
//        b.setNamaBarang("Baygon");
//        b.setDeskripsi("Pembasmi nyamuk");
//        b.setHargaJual(10000);
//        b.setSatuan("pcs");
//        b.setStock(100);
//        
//        Barang b2 = new Barang();
//        b2.setBarang("brng0002");
//        b2.setNamaBarang("Minyak Kayu Putih");
//        b2.setDeskripsi("Minyak");
//        b2.setHargaJual(5000);
//        b2.setSatuan("pcs");
//        b2.setStock(100);
//        
////        
            Employee e = new Employee();
            e.setNik("spv0001");
            e.setNama("Steven Gunanto");
            e.setBirthDate(new Date());
            e.setAlamat("Kalijudan");
            e.setJenisKelamin(JenisKelamin.PRIA);
            e.setTempatLahir("Surabaya");
            e.setUserName("steven");
            e.setPassword("gunanto");
            e.setJabatan(Jabatan.SUPERVISOR);
            
            employeeService.save(e);
//        
//        Customer c = new Customer();
//        c.setNip("cst0001");
//        c.setNama("Johan Prasetio");
//        c.setAlamat("Tambak Bayan");
//        c.setNoTelp("12345678910");
//        
//        Marketing m = new Marketing();
//        m.setNik("mkt0001");
//        m.setNama("Lola");
//        m.setBirthDate(new Date());
//        m.setAlamat("Mulyosari");
//        m.setJenisKelamin(JenisKelamin.PRIA);
//        m.setTempatLahir("Surabaya");
//        m.setUserName("lola");
//        m.setPassword("loli");
//        m.setJabatan(Jabatan.MARKETING);
//        ArrayList<Customer> customers = new ArrayList<Customer>();
//        
//        Operator operator = new Operator();
//        operator.setNik("opt0001");
//        operator.setNama("Jimmy");
//        operator.setAlamat("Pandean");
//        operator.setJenisKelamin(JenisKelamin.PRIA);
//        operator.setBirthDate(new Date());
//        operator.setTempatLahir("Surabaya");
//        operator.setJabatan(Jabatan.OPERATOR);
//        operator.setUserName("jimmy");
//        operator.setPassword("jimmy");
//        
//        DetailPenjualan dp = new DetailPenjualan();
//        dp.setHargaSatuan(b.getHargaJual());
//        dp.setJumlahBarang(10);
//        dp.setNoNota(0001);
//        dp.setSubTotal(100000);
//        dp.setBarang(b);
//        ArrayList<DetailPenjualan> listDetailPenjualan = new ArrayList<DetailPenjualan>();
//        listDetailPenjualan.add(dp);
//        
//        Penjualan penjualan = new Penjualan();
//        penjualan.setNoNota(0001);
//        penjualan.setBayar(10000);
//        penjualan.setKembali(5000);
//        penjualan.setCustomer(c);
//        penjualan.setEmployee(operator);
//        penjualan.setListDetailPenjualan(listDetailPenjualan);
//        penjualan.setTanggalPenjualan(new Date());
//        penjualan.setTotalBayar(20000);
//        penjualanService.save(penjualan);
//
//        // Customer dengan Marketing
//        customers.add(c); // tambahkan customer di marketing
//        m.setCustomer(customers); // Marketing set customer
//        customerService.save(c); // tambahkan customer ke database
//        c.setEmployee(m); // customer set marketing
//        employeeService.save(m); // employee simpan marketing
//        // Detail Penjualan dengan operator       
//
//        employeeService.save(operator); // tambahkan operator sebagai employee
//        dp.setPenjualan(penjualan);
//        detailPenjualanService.save(dp);
//        
//        barangService.save(b); // simpan barang
//        barangService.save(b2);
//        
//        Admin admin = new Admin();
//        admin.setNik("adm0001");
//        admin.setNama("Gabriel");
//        admin.setAlamat("Gedung doro");
//        admin.setBirthDate(new Date());
//        admin.setJabatan(Jabatan.ADMIN);
//        admin.setJenisKelamin(JenisKelamin.PRIA);
//        admin.setTempatLahir("Surabaya");
//        admin.setUserName("gabriel");
//        admin.setPassword("gabriel");
//        
////        Nota nota = new Nota();
////        nota.setNoNota(1);
////        nota.setAdmin(admin);
////        ArrayList<Nota> listNota = new ArrayList<Nota>();
////        listNota.add(nota);
////        admin.setNota(listNota);
////        employeeService.save(admin);
////        notaService.save(nota);
//        
//        Supervisor supervisor = new Supervisor();
//        supervisor.setNik("spv0001");
//        supervisor.setNama("Budi");
//        supervisor.setAlamat("Kenjeran");
//        supervisor.setJenisKelamin(JenisKelamin.PRIA);
//        supervisor.setTempatLahir("Surabaya");
//        supervisor.setJabatan(Jabatan.SUPERVISOR);
//        supervisor.setUserName("budi");
//        supervisor.setPassword("budi");
//        supervisor.setBirthDate(new Date());
//        employeeService.save(supervisor);
//        
        System.exit(0);
    }
}
