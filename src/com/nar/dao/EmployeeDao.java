/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.dao;

import com.nar.model.Employee;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class EmployeeDao extends BaseDaoHibernate<Employee>
{
    public Employee update(String kode, Employee employee)
    {
        sessionFactory.getCurrentSession()
            .createQuery("update Employee e set e.nik = ?, e.nama = ?, e.alamat = ?, e.birthDate = ?, e.tempatLahir = ?, e.jenisKelamin = ?, e.jabatan = ?, e.userName = ?, e.password = ? where e.nik = ?")
                .setParameter(0, employee.getNik())
                .setParameter(1, employee.getNama())
                .setParameter(2, employee.getAlamat())
                .setParameter(3, employee.getBirthDate())
                .setParameter(4, employee.getTempatLahir())
                .setParameter(5, employee.getJenisKelamin())
                .setParameter(6, employee.getJabatan())
                .setParameter(7, employee.getUserName())
                .setParameter(8, employee.getPassword())
                .setParameter(9, kode).executeUpdate();
        return employee;
    }
    
    public List<Employee> getByUsername(String user, String pass)
    {
        return  sessionFactory.getCurrentSession()
            .createQuery("select e.nik from Employee e where e.userName = ? AND e.password = ? ")
                .setParameter(0, user)
                .setParameter(1, pass).list();
    }
}
