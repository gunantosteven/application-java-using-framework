/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_CUSTOMER")
public class Customer implements Serializable
{
    @Id
    private String nip;
    
    @Column(name="NAMA")
    private String nama;
    
    @Column(name="ALAMAT")
    private String alamat;
    
    @Column(name="NO_TELP")
    private String noTelp;
    
    @ManyToOne
    @JoinColumn(name="EMPLOYEE_ID")
    private Employee employee;

    public String getAlamat() {
        return alamat;
    }

    public String getNama() {
        return nama;
    }

    public String getNip() {
        return nip;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
