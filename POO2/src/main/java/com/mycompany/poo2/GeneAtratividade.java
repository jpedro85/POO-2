/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public class GeneAtratividade extends GeneCaraterisca {

    private int atratividade;

    public GeneAtratividade(int atratividade, String nome) {
        super(nome);
        this.atratividade = atratividade;
    }

    public GeneAtratividade(FormatedString fstr) {
        super(fstr);
    }

    public int getAtratividade() {
        return atratividade;
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
