/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class Especie implements Gravavel {

    private String nome;
    private ArrayList<GeneEspecie> genes;

    public Especie(String nome) {
        this.nome = nome;
        this.genes = new ArrayList<>();
    }

    public Especie(String nome, Gene... genes) {
        this.nome = nome;
        this.genes = new ArrayList<>();
    }

    public Especie(String nome, ArrayList<GeneEspecie> genes) {
        this.nome = nome;
        this.genes = genes;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<GeneEspecie> getGenes() {
        return genes;
    }

    public void addGenes(GeneEspecie gene) {
        genes.add(gene);
    }

    public void change(int index, GeneEspecie gene) {
        genes.set(index, gene);
    }

    @Override
    public FormatedString toFormatedString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        String info = "";
        info = "Especie{" + "nome:" + nome + ", genes:\n";
        for (GeneEspecie e : genes) {
            info += "\t" + e.toString() + "\n";
        }
        return info;
    }

}
