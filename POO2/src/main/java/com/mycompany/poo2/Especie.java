/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  representa uma especia atravez do nome e um conjunto de genes de Especie
 */
public class Especie implements Gravavel,Registo<Especie> {

    private static ArrayList<Especie> allInstancesCreated = new ArrayList<>(200);
    private String nome;
    private ArrayList<GeneEspecie> genes;

    public Especie(String nome) {
        this.nome = nome;
        this.genes = new ArrayList<>();
    }

    public Especie(String nome, GeneEspecie... genes) {
        this.nome = nome;
        this.genes = new ArrayList<>(genes.length);
        this.genes.addAll(Arrays.asList(genes));
    }

    public Especie(String nome, ArrayList<GeneEspecie> genes) {
        this.nome = nome;
        this.genes = genes;
    }
    
    public Especie(FormatedString fstr) throws RepresentacaoInvalidaDoTipo {
        
        System.out.println(fstr);
        
        if ( !fstr.getTipo().equals("Especie") ) 
            throw new RepresentacaoInvalidaDoTipo("A FormatedString : " + fstr + " não representa uma Especie.");
        
        this.nome = fstr.getAtributo("Nome","Especie");
        this.genes = FormatedString.converterFormatedArray(GeneEspecie.class, fstr.getAtributo("Genes", "Especie"));

    }
    
    public static ArrayList<Especie> getAllInstances(){
        return allInstancesCreated; 
    }
    
    public static void addInstanceToResgisto( Especie instance ){  
        allInstancesCreated.add(instance);
    }
   
    public static void removeInstanceToRegisto( Especie instance ){
        allInstancesCreated.remove(instance);   
    }
    
    @Override
    public void addInstanceAoResgisto(){  
        allInstancesCreated.add(this);
    }
   
    @Override
    public void removeInstanceDoResgisto(){
        allInstancesCreated.remove(this);   
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
        info = "Especie(" + "nome:" + nome ;
        
        if(this.genes.isEmpty()) 
            return info + ")";
        else
            info += ", genes:\n";
        
        for (GeneEspecie e : genes) {
            info += "\t" + e.toString() + "\n";
        }
        return info + "\t)";
    }
    
    public boolean equals(Object obj){
        
        if (this == obj) return true;
        if (this == null) return false;
        if (this.getClass() != obj.getClass() ) return false;
        
        final Especie esp = (Especie)obj;
        return (this.nome.equals(esp.getNome())) && (this.genes.equals(esp.getGenes() ));
    
    }
}
