/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public class GeneSexo extends GeneCaraterisca {

    private Sexo sexo;

    public GeneSexo(Sexo sexo, String nome) {
        super(nome);
        this.sexo = sexo;
    }

    public GeneSexo(FormatedString fstr) {
        super(fstr);
    }

    public Sexo getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return "GeneSexo{ Id:" + this.getId() + "; Nome:" + this.getNome() + "; Geração" + this.getGeracao() + "; sexo=" + sexo + "}";
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
