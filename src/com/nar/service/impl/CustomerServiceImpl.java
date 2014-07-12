/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.service.impl;

import com.nar.dao.CustomerDao;
import com.nar.model.Customer;
import com.nar.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customerService")
@Transactional(readOnly=true)
public class CustomerServiceImpl implements CustomerService
{
    @Autowired private CustomerDao customerDao;
    
     @Transactional(readOnly=false)
    public Customer save(Customer customer)
    {
        return customerDao.save(customer);
    }
    @Transactional(readOnly=false)
    public Customer delete(Customer customer)
    {
        return customerDao.delete(customer);
    }
    @Transactional(readOnly=false)
    public void update(String id, Customer customer)
    {
        customerDao.update(id, customer);
    }
    public Customer getCustomer(String id)
    {
        return customerDao.getById(id);
    }
    public List<Customer> getCustomers()
    {
        return customerDao.getAll();
    }
    public List<Customer> getCustomers(int start, int num)
    {
        return customerDao.getAll(start, num);
    }
}
