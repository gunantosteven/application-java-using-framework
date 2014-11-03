/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nar.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_EMPLOYEE")
public class Employee implements Serializable
{
    @Id
    private String nik;
    
    @Column(name="NAMA")
    private String nama;
    
    @Column(name="ALAMAT")
    private String alamat;
    
    @Enumerated(EnumType.STRING)
    @Column(name="JENIS_KELAMIN",length=10)
    private JenisKelamin jenisKelamin;
    
    @Column(name="TEMPAT_LAHIR")
    private String tempatLahir;
    
    @Temporal(TemporalType.DATE)
    @Column(name="TANGGAL_LAHIR")
    private Date birthDate;
    
    @Enumerated(EnumType.STRING)
    @Column(name="JABATAN")
    private Jabatan jabatan;
    
    @Column(name="USERNAME")
    private String userName;
    
    @Column(name="password")
    private String password;

    public String getAlamat() {
        return alamat;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Jabatan getJabatan() {
        return jabatan;
    }

    public JenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public String getNama() {
        return nama;
    }

    public String getNik() {
        return nik;
    }

    public String getPassword() {
        return password;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public String getUserName() {
        return userName;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }
    
    public void setJenisKelamin(JenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
