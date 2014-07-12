/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.service;

import com.nar.model.Nota;
import java.util.List;


public interface NotaService
{
    public Nota save(Nota nota);
    public Nota delete(Nota nota);
    public Nota getNota(int id);
    public List<Nota> getListNota();
}
