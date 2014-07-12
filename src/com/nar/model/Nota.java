/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_NOTA")
public class Nota
{
    @Id
    @Column(name="NO_NOTA")
    private int noNota;
    
    @ManyToOne
    @JoinColumn(name="EMPLOYEE_ID")
    private Employee employee;


    public int getNoNota() {
        return noNota;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setNoNota(int noNota) {
        this.noNota = noNota;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
