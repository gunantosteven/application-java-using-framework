/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nar.model;

/**
 *
 * @author gunanto
 */
public enum Jabatan 
{
    SUPERVISOR("Supervisor"),ADMIN("Admin"),MARKETING("Marketing"),OPERATOR("Operator");

    private Jabatan(String text) {
        this.text = text;
    }
    
    private String text;
    
    @Override
    public String toString()
    {
        return text;
    }
}
