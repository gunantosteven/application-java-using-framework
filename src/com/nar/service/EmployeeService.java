/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.service;

import com.nar.model.Employee;
import java.util.List;


public interface EmployeeService 
{
    public Employee save(Employee employee);
    public void update(String id,Employee barang);
    public Employee delete(Employee employee);
    public Employee getEmployee(String id);
    public List<Employee> getEmployees();
    public List<Employee> getByUsername(String user, String pass);
}
