/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.service.impl;

import com.nar.dao.EmployeeDao;
import com.nar.model.Employee;
import com.nar.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("employeeService")
@Transactional(readOnly=true)
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired private EmployeeDao employeeDao;
    
    @Transactional(readOnly=false)
    public Employee save(Employee employee)
    {
        return employeeDao.save(employee);
    }
    @Transactional(readOnly=false)
    public Employee delete(Employee employee)
    {
        return employeeDao.delete(employee);
    }
    @Transactional(readOnly=false)
    public void update(String id, Employee employee)
    {
        employeeDao.update(id, employee);
    }
    public Employee getEmployee(String id)
    {
        return employeeDao.getById(id);
    }
    public List<Employee> getEmployees()
    {
        return employeeDao.getAll();
    }
    public List<Employee> getEmployees(int start, int num)
    {
        return employeeDao.getAll(start, num);
    }

    @Override
    public List<Employee> getByUsername(String user, String pass) 
    {
        return  employeeDao.getByUsername(user, pass);
    }
}
