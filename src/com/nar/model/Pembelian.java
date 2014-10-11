/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Steven Gunanto
 */
@Entity
@Table(name="T_PEMBELIAN")
public class Pembelian 
{
    @Id
    private String noFaktur;
    
    @ManyToOne
    @JoinColumn(name="SUPPLIER_PEMBELIAN")
    private Supplier supplier;
    
    @ManyToOne
    @JoinColumn(name="EMPLOYEE_PEMBELIAN")
    private Employee employee;
    
    @OneToMany(mappedBy="pembelian", cascade= CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<DetailPembelian> listDetailPembelian;
    
    @Column(name="TOTAL_BAYAR")
    private int totalBayar;
    
    @Temporal(TemporalType.DATE)
    @Column(name="TANGGAL_PEMBELIAN", nullable=false)
    private Date tanggalPembelian;

    public String getNoFaktur() {
        return noFaktur;
    }

    public void setNoFaktur(String noFaktur) {
        this.noFaktur = noFaktur;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getTanggalPembelian() {
        return tanggalPembelian;
    }

    public void setTanggalPembelian(Date tanggalPembelian) {
        this.tanggalPembelian = tanggalPembelian;
    }

    public int getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(int totalBayar) {
        this.totalBayar = totalBayar;
    }

    public List<DetailPembelian> getListDetailPembelian() {
        return listDetailPembelian;
    }

    public void setListDetailPembelian(List<DetailPembelian> listDetailPembelian) {
        this.listDetailPembelian = listDetailPembelian;
    }
}
