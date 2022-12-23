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
public class GeneAmbiente extends GeneMutavel implements Registo<GeneAmbiente>{

    private String ambiente;
    private static ArrayList<GeneAmbiente> allInstancesCreated = new ArrayList<>(200);

    public GeneAmbiente(FormatedString fstr) throws RepresentacaoInvalidaDoTipo {
        super(fstr,"GeneAmbiente");
        this.ambiente = fstr.getAtributo("Ambiente","GeneAmbiente");
    }

    public GeneAmbiente(Ambiente ambiente, String nome , int geracao) {
        super(nome,geracao);
        this.ambiente = ambiente.toString() ;
    }
    
    public GeneAmbiente(Ambiente ambiente, String nome ) {
        super(nome);
        this.ambiente = ambiente.toString() ;
    }

    public String getAmbiente() {
        return ambiente;
    }
    
    @Override
    public ArrayList<GeneAmbiente> getAllInstances(){
        return allInstancesCreated; 
    }
    
    @Override
    public void addInstance( GeneAmbiente instance ){  
        allInstancesCreated.add(instance);
    }
   
    @Override
    public void removeInstance( GeneAmbiente instance ){
        allInstancesCreated.remove(instance);   
    }
    
    @Override
    public void mutar() {
                
        if( Gerador.gerarProbabilidate() == 1){
            
            int ordinal = Gerador.gerarOrdinal(Ambiente.values().length );
            
            if ( !this.ambiente.equals( Ambiente.values()[ordinal].toString() ) ){
                super.mutar();
                this.ambiente =  Ambiente.values()[ordinal].toString() ;
            }    
            
        }
    }
   
    @Override
    public FormatedString toFormatedString(){
        
        FormatedString fsrt = new FormatedString(this.getClass().getSimpleName(),4);
        fsrt.addAtributo("Id",  this.getId() );
        fsrt.addAtributo("Nome", this.getNome());
        fsrt.addAtributo("Geracao",  this.getGeracao() );
        fsrt.addAtributo("Ambiente",  this.getAmbiente());
        return fsrt;
        
    }
    
    @Override
    public String toString(){

        return "GeneAmbiente(Id:" + this.getId() + ";Nome:" + this.getNome() + ";Geracao:" + this.getGeracao() + ",Ambiente:"+ this.getAmbiente() +")" ;
    }
    
    @Override
    public boolean equals(Object obj) {
                
        if (this == obj) return true;
        if (obj == null) return false;
        if ( getClass() != obj.getClass() ) return false;
        
        GeneAmbiente gene = (GeneAmbiente)obj;      
        return (this.getNome().equals(gene.getNome() )) && (this.getGeracao() == gene.getGeracao()) && (this.isMutado() == gene.isMutado()) && (this.getAmbiente().equals(gene.getAmbiente() )) ;
    }
    
    @Override
    public GeneAmbiente clone(){
        
        Ambiente temp = Ambiente.ROCHOSO ;
        
        for(Ambiente amb: Ambiente.values() ){
            
            if( amb.toString().equals(this.getAmbiente())){
                temp = amb; 
            }
               
        }
        
        return new GeneAmbiente(temp,this.getNome(),this.getGeracao());
    }
}
