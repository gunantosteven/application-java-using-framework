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
@Table(name="T_ADMIN")
@PrimaryKeyJoinColumn(name="ADMIN_ID")
public class Admin extends Employee implements Serializable
{
    
}