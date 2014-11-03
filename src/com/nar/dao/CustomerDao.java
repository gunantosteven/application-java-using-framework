/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.dao;

import com.nar.model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class CustomerDao extends BaseDaoHibernate<Customer>
{
    public Customer update(String kode, Customer customer)
    {
        sessionFactory.getCurrentSession()
            .createQuery("update Customer c set c.nip = ?, c.nama = ?, c.alamat = ?, c.noTelp = ? where c.nip = ?")
            .setParameter(0, customer.getNip())
            .setParameter(1, customer.getNama())
            .setParameter(2, customer.getAlamat())
            .setParameter(3, customer.getNoTelp())
            .setParameter(4, kode).executeUpdate();
        
        return customer;
    }
}
