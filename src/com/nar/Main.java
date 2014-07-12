/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar;

import com.nar.model.Barang;
import com.nar.service.BarangService;
import com.nar.service.CustomerService;
import com.nar.service.DetailPenjualanService;
import com.nar.service.EmployeeService;
import com.nar.service.NotaService;
import com.nar.service.PenjualanService;
import com.nar.service.ReportService;
import com.nar.ui.FormLoading;
import javax.swing.UIManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main 
{
    private static BarangService barangService;
    private static CustomerService customerService;
    private static EmployeeService employeeService;
    private static DetailPenjualanService detailPenjualanService;
    private static PenjualanService penjualanService;
    private static NotaService notaService;
    private static ReportService reportService;
    private static FormLoading formLoading;

    public static BarangService getBarangService() {
        return barangService;
    }

    public static CustomerService getCustomerService() {
        return customerService;
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

    public static NotaService getNotaService() {
        return notaService;
    }

    public static ReportService getReportService() {
        return reportService;
    }
    
    public static FormLoading getFormLoading() {
        return formLoading;
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
                customerService = (CustomerService)
                        appContext.getBean("customerService");
                notaService = (NotaService)
                        appContext.getBean("notaService");
                detailPenjualanService = (DetailPenjualanService)
                        appContext.getBean("detailPenjualanService");
                penjualanService = (PenjualanService)
                        appContext.getBean("penjualanService");
                reportService = (ReportService)
                        appContext.getBean("reportService");

                formLoading = new FormLoading();
                formLoading.setVisible(true);
          }
        });
    }
}
