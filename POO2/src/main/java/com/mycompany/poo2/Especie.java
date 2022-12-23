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
    
    public Especie(FormatedString fstr) throws RepresentacaoInvalidaDoTipo {
        
        if ( !fstr.getTipo().equals("Especie") ) 
            throw new RepresentacaoInvalidaDoTipo("A FormatedString : " + fstr + " não representa uma Especie.");
        
        this.nome = fstr.getAtributo("Nome","Especie");
        this.genes = FormatedString.converterFormatedArray(GeneEspecie.class, fstr.getAtributo("Genes", "Especie"));

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
        
        FormatedString fstr = new FormatedString("Especie",2);
        fstr.addAtributo("Nome", this.nome);
        fstr.addAtributo("Genes", FormatedString.formatArray(this.genes));
        
        return fstr;
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
    
    public boolean equals(Object obj){
        
        if (this == obj) return true;
        if (this == null) return false;
        if (this.getClass() != obj.getClass() ) return false;
        
        final Especie esp = (Especie)obj;
        return (this.nome.equals(esp.getNome())) && (this.genes.equals(esp.getGenes() ));
    
    }
}
