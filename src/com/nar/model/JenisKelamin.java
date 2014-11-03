package com.nar.model;

import java.io.Serializable;


public enum JenisKelamin implements Serializable
{
    PRIA("P"),WANITA("W");

    private JenisKelamin(String text) {
        this.text = text;
    }

    private String text;

    @Override
    public String toString() {
        return text;
    }
}
