/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public abstract class Pessoa {

    private static int numeroPessoas;
    private String nome;
    private int nif;
    private int idade;

    public Pessoa(String nome, int nif, int idade) {
        this.nome = nome;
        this.nif = nif;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getNif() {
        return nif;
    }

    public static int getQuantidade() {
        return numeroPessoas;
    }

    public static Pessoa eleminar(Pessoa ppl) {
        numeroPessoas -= 1;
        return null;
    }

    @Override
    public String toString() {
        String text = "";
        text += "Nome: " + nome + " NIF: " + nif;
        return text;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Pessoa p = (Pessoa) obj;

        return (nome.equals(p.getNome())) && (nif == p.getNif());
    }
}