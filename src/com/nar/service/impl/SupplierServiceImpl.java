/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.service.impl;

import com.nar.dao.SupplierDao;
import com.nar.model.Supplier;
import com.nar.service.SupplierService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Steven Gunanto
 */
@Service("supplierService")
@Transactional(readOnly=true)
public class SupplierServiceImpl implements SupplierService
{
    @Autowired private SupplierDao supplierDao;
    
    @Override
    @Transactional(readOnly=false)
    public Supplier save(Supplier supplier) {
        return supplierDao.save(supplier);
    }

    @Override
    @Transactional(readOnly=false)
    public void update(String id, Supplier supplier) {
        supplierDao.update(id, supplier);
    }

    @Override
    @Transactional(readOnly=false)
    public Supplier delete(Supplier supplier) {
        return supplierDao.delete(supplier);
    }

    @Override
    public Supplier getSupplier(String id) {
        return supplierDao.getById(id);
    }

    @Override
    public List<Supplier> getSuppliers() {
        return supplierDao.getAll();
    }
    
}
