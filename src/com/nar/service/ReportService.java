/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.service;

import java.util.Date;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author ifnu
 */
public interface ReportService {

    JasperPrint getDailyPenjualanReport(Date date);
    JasperPrint getCustomerReport();
    JasperPrint getEmployeeReport();
    JasperPrint getLabaRugi(Date dari, Date sampai);
    JasperPrint getNeracaSaldo(Date dari, Date sampai);
}
