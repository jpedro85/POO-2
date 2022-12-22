/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public class GeneAmbiente extends GeneCaraterisca {

    private String ambiente;

    public GeneAmbiente(FormatedString fstr) {
        super(fstr);
    }

    public GeneAmbiente(String ambiente, String nome) {
        super(nome);
        this.ambiente = ambiente;
    }

    public String getAmbiente() {
        return ambiente;
    }

    @Override
    public void mutar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public FormatedString toFormatedString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
