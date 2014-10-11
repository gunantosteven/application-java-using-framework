/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.service;

import com.nar.model.JurnalUmum;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Steven Gunanto
 */
public interface JurnalUmumService {
    public JurnalUmum save(JurnalUmum jurnalUmum);
    public JurnalUmum delete(JurnalUmum jurnalUmum);
    public JurnalUmum getJurnalUmum(int no);
    public List<JurnalUmum> getListJurnalUmum();
    public List<JurnalUmum> getJurnalUmumBetween(Date mulai, Date sampai);
    public List<JurnalUmum> getJurnalUmumBetween(String kodeAkun,Date mulai, Date sampai);
    public Date getOldestDate();
    public void delete(String faktur);
}
