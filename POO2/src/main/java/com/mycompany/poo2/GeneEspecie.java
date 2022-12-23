/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.ArrayList;

/**
 *
 * @author Francisco MSI
 */

public class GeneEspecie extends Gene implements Registo<GeneEspecie> {
    
    private String valor;
    private static ArrayList<GeneEspecie> allInstancesCreated = new ArrayList<>(200);
    
    public GeneEspecie(String valor, String nome) {
        super(nome);
        this.valor = valor;
    }
     
    public GeneEspecie(FormatedString fstr) throws RepresentacaoInvalidaDoTipo {
        super( fstr , "GeneEspecie" );
        this.valor = fstr.getAtributo("Valor","GeneEspecie");     
    }
    
    @Override
    public ArrayList<GeneEspecie> getAllInstances(){
        return allInstancesCreated; 
    }
    
    @Override
    public void addInstance( GeneEspecie instance ){  
        allInstancesCreated.add(instance);
    }
   
    @Override
    public void removeInstance( GeneEspecie instance ){
        allInstancesCreated.remove(instance);   
    }
    
    public String getValor(){
        return this.valor;
    }
    
    @Override
    public FormatedString toFormatedString(){
        
        FormatedString fsrt = new FormatedString(this.getClass().getSimpleName(),4);
        fsrt.addAtributo("Id",  this.getId() );
        fsrt.addAtributo("Nome", this.getNome());
        fsrt.addAtributo("Valor",  this.getValor());
        return fsrt;
        
    }
    
    @Override
    public String toString(){

        return "GeneEspecie(Id:" + this.getId() + ";Nome:" + this.getNome() + ";Valor:"+ this.valor +")" ;
    }
    
    @Override
    public boolean equals(Object obj) {
                
        if (this == obj) return true;
        if (obj == null) return false;
        if ( getClass() != obj.getClass() ) return false;
        
        final GeneEspecie gene = (GeneEspecie)obj;      
        return (this.getNome().equals(gene.getNome() )) && (this.getValor().equals(gene.getValor()));
    }
    
    @Override
    public GeneEspecie clone(){
        
        return new GeneEspecie(this.getValor(),this.getNome());
    }
}