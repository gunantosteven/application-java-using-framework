/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.model;

import java.io.Serializable;
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

@Entity
@Table(name="T_PENJUALAN")
public class Penjualan implements Serializable
{
    @Id
    private String noFaktur;
    
    @ManyToOne
    @JoinColumn(name="CUSTOMER_PENJUALAN")
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name="EMPLOYEE_PENJUALAN")
    private Employee employee;
    
    @OneToMany(mappedBy="penjualan",cascade=CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<DetailPenjualan> listDetailPenjualan;
    
    @Column(name="TOTAL_BAYAR")
    private int totalBayar;
    
    @Temporal(TemporalType.DATE)
    @Column(name="TANGGAL_PENJUALAN", nullable=false)
    private Date tanggalPenjualan;

    public Customer getCustomer() {
        return customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public List<DetailPenjualan> getListDetailPenjualan() {
        return listDetailPenjualan;
    }

    public Date getTanggalPenjualan() {
        return tanggalPenjualan;
    }

    public String getNoFaktur() {
        return noFaktur;
    }

    public int getTotalBayar() {
        return totalBayar;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public void setListDetailPenjualan(List<DetailPenjualan> listDetailPenjualan) {
        this.listDetailPenjualan = listDetailPenjualan;
    }

    public void setTanggalPenjualan(Date tanggalPenjualan) {
        this.tanggalPenjualan = tanggalPenjualan;
    }

    public void setTotalBayar(int totalBayar) {
        this.totalBayar = totalBayar;
    }

    public void setNoFaktur(String noFaktur) {
        this.noFaktur = noFaktur;
    }
}
