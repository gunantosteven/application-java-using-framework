/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="T_SUPERVISOR")
@PrimaryKeyJoinColumn(name="SUPERVISOR_ID")
public class Supervisor extends Employee implements Serializable
{
    @OneToMany(mappedBy="employee",cascade= CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<Customer> customer;

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
}
