/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.service.impl;

import com.nar.dao.NotaDao;
import com.nar.model.Nota;
import com.nar.service.NotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("notaService")
@Transactional(readOnly=true)
public class NotaServiceImpl implements NotaService
{
    @Autowired private NotaDao notaDao;
    
    @Transactional(readOnly=false)
    public Nota save(Nota nota)
    {
        return notaDao.save(nota);
    }
    @Transactional(readOnly=false)
    public Nota delete(Nota nota)
    {
        return notaDao.delete(nota);
    }
    public Nota getNota(int id)
    {
        return notaDao.getById(id);
    }
    public List<Nota> getListNota()
    {
        return notaDao.getAll();
    }
    public List<Nota> getEmployees(int start, int num)
    {
        return notaDao.getAll(start, num);
    }
}
