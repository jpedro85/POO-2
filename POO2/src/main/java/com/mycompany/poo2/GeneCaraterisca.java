/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public abstract class GeneCaraterisca extends Gene {

    public GeneCaraterisca(FormatedString fstr) {
        super(fstr);
    }

    public GeneCaraterisca(String nome) {
        super(nome);
    }

    public abstract void mutar();
}
