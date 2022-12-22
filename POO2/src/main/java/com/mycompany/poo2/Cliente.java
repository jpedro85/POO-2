/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public class Cliente extends Pessoa {

    private static int numeroClientes;
    private int numeroVisitas;
    private double saldo;
    private int generosidade;
    private int interece;

    public Cliente(String nome, int nif, int idade, double saldo, int generosidade, int interece) {
        super(nome, nif, idade);
        this.saldo = saldo;
        this.generosidade = generosidade;
        this.interece = interece;
    }

    public static int getQuantidade() {
        return numeroClientes;
    }

    public void eleminar() {
        super.eleminar();
        numeroClientes --;
    }

    public int getNumeroVisitas() {
        return numeroVisitas;
    }

    public double pagar(double preco) {
        return saldo - preco;
    }
    //oferecerDinheiro por fazer 

    @Override
    public String toString() {
        String text;
        text = "O Cliente tem: ";
        text += super.toString() + "\n";
        text += "com saldo: " + saldo + " generosidade: " + generosidade + "e interece: " + interece;
        return text;
    }
}
