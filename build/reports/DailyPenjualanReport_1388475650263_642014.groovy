/*
 * Generated by JasperReports - 12/31/13 2:40 PM
 */
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.fill.*;

import java.util.*;
import java.math.*;
import java.text.*;
import java.io.*;
import java.net.*;



/**
 *
 */
class DailyPenjualanReport_1388475650263_642014 extends JREvaluator
{


    /**
     *
     */
    private JRFillParameter parameter_REPORT_LOCALE = null;
    private JRFillParameter parameter_JASPER_REPORT = null;
    private JRFillParameter parameter_REPORT_VIRTUALIZER = null;
    private JRFillParameter parameter_REPORT_TIME_ZONE = null;
    private JRFillParameter parameter_SORT_FIELDS = null;
    private JRFillParameter parameter_REPORT_FILE_RESOLVER = null;
    private JRFillParameter parameter_REPORT_SCRIPTLET = null;
    private JRFillParameter parameter_REPORT_PARAMETERS_MAP = null;
    private JRFillParameter parameter_REPORT_CONNECTION = null;
    private JRFillParameter parameter_date = null;
    private JRFillParameter parameter_REPORT_CLASS_LOADER = null;
    private JRFillParameter parameter_REPORT_DATA_SOURCE = null;
    private JRFillParameter parameter_REPORT_URL_HANDLER_FACTORY = null;
    private JRFillParameter parameter_IS_IGNORE_PAGINATION = null;
    private JRFillParameter parameter_REPORT_FORMAT_FACTORY = null;
    private JRFillParameter parameter_REPORT_MAX_COUNT = null;
    private JRFillParameter parameter_REPORT_TEMPLATES = null;
    private JRFillParameter parameter_REPORT_RESOURCE_BUNDLE = null;
    private JRFillField field_subTotal = null;
    private JRFillField field_kodeBarang = null;
    private JRFillField field_jumlahBarang = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;
    private JRFillVariable variable_SUM_JUMLAHBARANG = null;
    private JRFillVariable variable_SUM_SUBTOTAL = null;


    /**
     *
     */
    void customizedInit(
        Map pm,
        Map fm,
        Map vm
        )
    {
        initParams(pm);
        initFields(fm);
        initVars(vm);
    }


    /**
     *
     */
    void initParams(Map pm)
    {
        parameter_REPORT_LOCALE = (JRFillParameter)pm.get("REPORT_LOCALE");
        parameter_JASPER_REPORT = (JRFillParameter)pm.get("JASPER_REPORT");
        parameter_REPORT_VIRTUALIZER = (JRFillParameter)pm.get("REPORT_VIRTUALIZER");
        parameter_REPORT_TIME_ZONE = (JRFillParameter)pm.get("REPORT_TIME_ZONE");
        parameter_SORT_FIELDS = (JRFillParameter)pm.get("SORT_FIELDS");
        parameter_REPORT_FILE_RESOLVER = (JRFillParameter)pm.get("REPORT_FILE_RESOLVER");
        parameter_REPORT_SCRIPTLET = (JRFillParameter)pm.get("REPORT_SCRIPTLET");
        parameter_REPORT_PARAMETERS_MAP = (JRFillParameter)pm.get("REPORT_PARAMETERS_MAP");
        parameter_REPORT_CONNECTION = (JRFillParameter)pm.get("REPORT_CONNECTION");
        parameter_date = (JRFillParameter)pm.get("date");
        parameter_REPORT_CLASS_LOADER = (JRFillParameter)pm.get("REPORT_CLASS_LOADER");
        parameter_REPORT_DATA_SOURCE = (JRFillParameter)pm.get("REPORT_DATA_SOURCE");
        parameter_REPORT_URL_HANDLER_FACTORY = (JRFillParameter)pm.get("REPORT_URL_HANDLER_FACTORY");
        parameter_IS_IGNORE_PAGINATION = (JRFillParameter)pm.get("IS_IGNORE_PAGINATION");
        parameter_REPORT_FORMAT_FACTORY = (JRFillParameter)pm.get("REPORT_FORMAT_FACTORY");
        parameter_REPORT_MAX_COUNT = (JRFillParameter)pm.get("REPORT_MAX_COUNT");
        parameter_REPORT_TEMPLATES = (JRFillParameter)pm.get("REPORT_TEMPLATES");
        parameter_REPORT_RESOURCE_BUNDLE = (JRFillParameter)pm.get("REPORT_RESOURCE_BUNDLE");
    }


    /**
     *
     */
    void initFields(Map fm)
    {
        field_subTotal = (JRFillField)fm.get("subTotal");
        field_kodeBarang = (JRFillField)fm.get("kodeBarang");
        field_jumlahBarang = (JRFillField)fm.get("jumlahBarang");
    }


    /**
     *
     */
    void initVars(Map vm)
    {
        variable_PAGE_NUMBER = (JRFillVariable)vm.get("PAGE_NUMBER");
        variable_COLUMN_NUMBER = (JRFillVariable)vm.get("COLUMN_NUMBER");
        variable_REPORT_COUNT = (JRFillVariable)vm.get("REPORT_COUNT");
        variable_PAGE_COUNT = (JRFillVariable)vm.get("PAGE_COUNT");
        variable_COLUMN_COUNT = (JRFillVariable)vm.get("COLUMN_COUNT");
        variable_SUM_JUMLAHBARANG = (JRFillVariable)vm.get("SUM_JUMLAHBARANG");
        variable_SUM_SUBTOTAL = (JRFillVariable)vm.get("SUM_SUBTOTAL");
    }


    /**
     *
     */
    Object evaluate(int id)
    {
        Object value = null;

        if (id == 0)
        {
            value = (java.lang.Integer)(new java.lang.Integer(1));
        }
        else if (id == 1)
        {
            value = (java.lang.Integer)(new java.lang.Integer(1));
        }
        else if (id == 2)
        {
            value = (java.lang.Integer)(new java.lang.Integer(1));
        }
        else if (id == 3)
        {
            value = (java.lang.Integer)(new java.lang.Integer(0));
        }
        else if (id == 4)
        {
            value = (java.lang.Integer)(new java.lang.Integer(1));
        }
        else if (id == 5)
        {
            value = (java.lang.Integer)(new java.lang.Integer(0));
        }
        else if (id == 6)
        {
            value = (java.lang.Integer)(new java.lang.Integer(1));
        }
        else if (id == 7)
        {
            value = (java.lang.Integer)(new java.lang.Integer(0));
        }
        else if (id == 8)
        {
            value = (java.lang.Integer)(((java.lang.Integer)field_jumlahBarang.getValue()));
        }
        else if (id == 9)
        {
            value = (java.lang.Integer)(((java.lang.Integer)field_subTotal.getValue()));
        }
        else if (id == 10)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_PAGE_NUMBER.getValue()));
        }
        else if (id == 11)
        {
            value = (java.lang.String)(((java.util.Date)parameter_date.getValue()));
        }
        else if (id == 12)
        {
            value = (java.lang.String)(((java.lang.String)field_kodeBarang.getValue()));
        }
        else if (id == 13)
        {
            value = (java.lang.String)(((java.lang.Integer)field_jumlahBarang.getValue()));
        }
        else if (id == 14)
        {
            value = (java.lang.String)(((java.lang.Integer)field_subTotal.getValue()));
        }
        else if (id == 15)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_SUM_JUMLAHBARANG.getValue()));
        }
        else if (id == 16)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_SUM_SUBTOTAL.getValue()));
        }

        return value;
    }


    /**
     *
     */
    Object evaluateOld(int id)
    {
        Object value = null;

        if (id == 0)
        {
            value = (java.lang.Integer)(new java.lang.Integer(1));
        }
        else if (id == 1)
        {
            value = (java.lang.Integer)(new java.lang.Integer(1));
        }
        else if (id == 2)
        {
            value = (java.lang.Integer)(new java.lang.Integer(1));
        }
        else if (id == 3)
        {
            value = (java.lang.Integer)(new java.lang.Integer(0));
        }
        else if (id == 4)
        {
            value = (java.lang.Integer)(new java.lang.Integer(1));
        }
        else if (id == 5)
        {
            value = (java.lang.Integer)(new java.lang.Integer(0));
        }
        else if (id == 6)
        {
            value = (java.lang.Integer)(new java.lang.Integer(1));
        }
        else if (id == 7)
        {
            value = (java.lang.Integer)(new java.lang.Integer(0));
        }
        else if (id == 8)
        {
            value = (java.lang.Integer)(((java.lang.Integer)field_jumlahBarang.getOldValue()));
        }
        else if (id == 9)
        {
            value = (java.lang.Integer)(((java.lang.Integer)field_subTotal.getOldValue()));
        }
        else if (id == 10)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_PAGE_NUMBER.getOldValue()));
        }
        else if (id == 11)
        {
            value = (java.lang.String)(((java.util.Date)parameter_date.getValue()));
        }
        else if (id == 12)
        {
            value = (java.lang.String)(((java.lang.String)field_kodeBarang.getOldValue()));
        }
        else if (id == 13)
        {
            value = (java.lang.String)(((java.lang.Integer)field_jumlahBarang.getOldValue()));
        }
        else if (id == 14)
        {
            value = (java.lang.String)(((java.lang.Integer)field_subTotal.getOldValue()));
        }
        else if (id == 15)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_SUM_JUMLAHBARANG.getOldValue()));
        }
        else if (id == 16)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_SUM_SUBTOTAL.getOldValue()));
        }

        return value;
    }


    /**
     *
     */
    Object evaluateEstimated(int id)
    {
        Object value = null;

        if (id == 0)
        {
            value = (java.lang.Integer)(new java.lang.Integer(1));
        }
        else if (id == 1)
        {
            value = (java.lang.Integer)(new java.lang.Integer(1));
        }
        else if (id == 2)
        {
            value = (java.lang.Integer)(new java.lang.Integer(1));
        }
        else if (id == 3)
        {
            value = (java.lang.Integer)(new java.lang.Integer(0));
        }
        else if (id == 4)
        {
            value = (java.lang.Integer)(new java.lang.Integer(1));
        }
        else if (id == 5)
        {
            value = (java.lang.Integer)(new java.lang.Integer(0));
        }
        else if (id == 6)
        {
            value = (java.lang.Integer)(new java.lang.Integer(1));
        }
        else if (id == 7)
        {
            value = (java.lang.Integer)(new java.lang.Integer(0));
        }
        else if (id == 8)
        {
            value = (java.lang.Integer)(((java.lang.Integer)field_jumlahBarang.getValue()));
        }
        else if (id == 9)
        {
            value = (java.lang.Integer)(((java.lang.Integer)field_subTotal.getValue()));
        }
        else if (id == 10)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_PAGE_NUMBER.getEstimatedValue()));
        }
        else if (id == 11)
        {
            value = (java.lang.String)(((java.util.Date)parameter_date.getValue()));
        }
        else if (id == 12)
        {
            value = (java.lang.String)(((java.lang.String)field_kodeBarang.getValue()));
        }
        else if (id == 13)
        {
            value = (java.lang.String)(((java.lang.Integer)field_jumlahBarang.getValue()));
        }
        else if (id == 14)
        {
            value = (java.lang.String)(((java.lang.Integer)field_subTotal.getValue()));
        }
        else if (id == 15)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_SUM_JUMLAHBARANG.getEstimatedValue()));
        }
        else if (id == 16)
        {
            value = (java.lang.String)(((java.lang.Integer)variable_SUM_SUBTOTAL.getEstimatedValue()));
        }

        return value;
    }


}