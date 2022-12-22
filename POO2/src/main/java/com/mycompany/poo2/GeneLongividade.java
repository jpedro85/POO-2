/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public class GeneLongividade extends GeneCaraterisca {

    private int anos;

    public GeneLongividade(FormatedString fstr) {
        super(fstr);
    }

    public GeneLongividade(int anos, String nome) {
        super(nome);
        this.anos = anos;
    }

    public int getAnos() {
        return anos;
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
