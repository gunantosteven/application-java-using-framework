/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Steven Gunanto
 */
@Entity
@Table(name="T_JURNALUMUM")
public class JurnalUmum implements Serializable {
    
    @Id  @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @Temporal(TemporalType.DATE)
    @Column(name="TANGGAL", nullable=false)
    private Date tanggal;
    
    @ManyToOne
    @JoinColumn(name="JURNALUMUM_MASTERAKUN")
    private MasterAkun masterAkun;
    
    @Column(name="FAKTUR")
    private String faktur;
    
    @Column(name="DK")
    private String dk;
    
    @Column(name="SALDO")
    private long saldo;
    
    @ManyToOne
    @JoinColumn(name="EMPLOYEE_PENJUALAN")
    private Employee employee;

    public String getDk() {
        return dk;
    }

    public void setDk(String dk) {
        this.dk = dk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MasterAkun getMasterAkun() {
        return masterAkun;
    }

    public void setMasterAkun(MasterAkun masterAkun) {
        this.masterAkun = masterAkun;
    }

    public String getFaktur() {
        return faktur;
    }

    public void setFaktur(String faktur) {
        this.faktur = faktur;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
