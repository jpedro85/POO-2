/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public abstract class Pessoa implements Gravavel {

    private static int numeroPessoas = 0;
    private String nome;
    private int nif;
    private int idade;

    public Pessoa(String nome, int nif, int idade) {
        this.nome = nome;
        this.nif = nif;
        this.idade = idade;
        this.numeroPessoas++;
    }

    public Pessoa(FormatedString fstr, String className) throws RepresentacaoInvalidaDoTipo {

        if (!fstr.getTipo().equals(className)) {
            throw new RepresentacaoInvalidaDoTipo("FormatedString fsrt não representa um :" + className);
        }

        this.nome = fstr.getAtributo("Nome",className);
        this.nif = Integer.parseInt(fstr.getAtributo("Nif",className));
        this.idade = Integer.parseInt(fstr.getAtributo("Idade",className));

        numeroPessoas++;
    }

    public String getNome() {
        return nome;
    }

    public int getNif() {
        return nif;
    }

    public int getIdade() {
        return idade;
    }

    public static int getQuantidade() {
        return numeroPessoas;
    }

    public void eleminar() {
        numeroPessoas--;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " NIF: " + nif + " Idade:"+this.idade;
    }

    @Override
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
