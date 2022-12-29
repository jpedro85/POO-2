/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *  representa uma empresa que vai constuir a instalacao.
 */
public class Empreiteira {
    
    private String nome;
    private double preco;
    
    /**
     * 
     * @param nome nome da enpresa;
     * @param preco custo da instalacão;
     */
    public Empreiteira(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Empreiteira:" + "nome: " + nome + ", preco: " + preco + '}';
    }
}
