/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar;

import com.nar.model.Barang;
import com.nar.model.DetailPembelian;
import com.nar.model.JurnalUmum;
import com.nar.model.MasterAkun;
import com.nar.model.Supplier;
import com.nar.service.BarangService;
import com.nar.service.CustomerService;
import com.nar.service.DetailPembelianService;
import com.nar.service.DetailPenjualanService;
import com.nar.service.EmployeeService;
import com.nar.service.JurnalUmumService;
import com.nar.service.MasterAkunService;
import com.nar.service.PembelianService;
import com.nar.service.PenjualanService;
import com.nar.service.ReportService;
import com.nar.service.SupplierService;
import com.nar.ui.FormLoading;
import java.util.Scanner;
import javax.swing.UIManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main 
{
    private static BarangService barangService;
    private static CustomerService customerService;
    private static SupplierService supplierService;
    private static EmployeeService employeeService;
    private static DetailPenjualanService detailPenjualanService;
    private static PenjualanService penjualanService;
    private static PembelianService pembelianService;
    private static DetailPembelianService detailPembelianService;
    private static ReportService reportService;
    private static FormLoading formLoading;
    private static MasterAkunService masterAkunService;
    private static JurnalUmumService jurnalUmumService;

    public static BarangService getBarangService() {
        return barangService;
    }

    public static CustomerService getCustomerService() {
        return customerService;
    }

    public static SupplierService getSupplierService() {
        return supplierService;
    }
    
    public static EmployeeService getEmployeeService() {
        return employeeService;
    }

    public static DetailPenjualanService getDetailPenjualanService() {
        return detailPenjualanService;
    }
    
    public static PenjualanService getPenjualanService() {
        return penjualanService;
    }

    public static DetailPembelianService getDetailPembelianService() {
        return detailPembelianService;
    }

    public static PembelianService getPembelianService() {
        return pembelianService;
    }

    public static ReportService getReportService() {
        return reportService;
    }
    
    public static FormLoading getFormLoading() {
        return formLoading;
    }

    public static JurnalUmumService getJurnalUmumService() {
        return jurnalUmumService;
    }

    public static MasterAkunService getMasterAkunService() {
        return masterAkunService;
    }

    public static void main(String[] args)
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                	com.jtattoo.plaf.mcwin.McWinLookAndFeel.setTheme("Large-Font", "Java Swing", "");
    	            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() 
          {
                ApplicationContext appContext = 
                    new ClassPathXmlApplicationContext("applicationContext.xml"); 
                barangService = (BarangService)
                        appContext.getBean("barangService");
                employeeService = (EmployeeService)
                        appContext.getBean("employeeService");
                supplierService = (SupplierService)
                        appContext.getBean("supplierService");
                customerService = (CustomerService)
                        appContext.getBean("customerService");
                detailPenjualanService = (DetailPenjualanService)
                        appContext.getBean("detailPenjualanService");
                penjualanService = (PenjualanService)
                        appContext.getBean("penjualanService");
                detailPembelianService = (DetailPembelianService)
                        appContext.getBean("detailPembelianService");
                pembelianService = (PembelianService)
                        appContext.getBean("pembelianService");
                reportService = (ReportService)
                        appContext.getBean("reportService");
                masterAkunService = (MasterAkunService)
                        appContext.getBean("masterAkunService");
                jurnalUmumService = (JurnalUmumService)
                        appContext.getBean("jurnalUmumService");

                formLoading = new FormLoading();
                formLoading.setVisible(true);
          }
        });
    }
}
