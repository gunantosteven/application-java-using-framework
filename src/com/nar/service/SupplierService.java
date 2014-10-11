/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.service;

import com.nar.model.Supplier;
import java.util.List;

/**
 *
 * @author Steven Gunanto
 */
public interface SupplierService 
{
    public Supplier save(Supplier supplier);
    public void update(String id,Supplier supplier);
    public Supplier delete(Supplier supplier);
    public Supplier getSupplier(String id);
    public List<Supplier> getSuppliers();
}
