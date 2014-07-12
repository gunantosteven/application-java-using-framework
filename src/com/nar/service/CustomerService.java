/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.service;

import com.nar.model.Barang;
import com.nar.model.Customer;
import com.nar.model.Employee;
import java.util.List;


public interface CustomerService 
{
    public Customer save(Customer customer);
    public void update(String id, Customer customer);
    public Customer delete(Customer customer);
    public Customer getCustomer(String id);
    public List<Customer> getCustomers();
}
