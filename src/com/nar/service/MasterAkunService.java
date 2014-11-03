/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.service;

import com.nar.model.MasterAkun;
import java.util.List;

/**
 *
 * @author Steven Gunanto
 */
public interface MasterAkunService 
{
    public MasterAkun save(MasterAkun masterAkun);
    public MasterAkun delete(MasterAkun masterAkun);
    public MasterAkun getMasterAkun(String nomerAkun);
    public List<MasterAkun> getListMasterAkun();
    public List<MasterAkun> getAkuns(String kodeAkun);
}
