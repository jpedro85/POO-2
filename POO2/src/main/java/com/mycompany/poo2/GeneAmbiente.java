/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.ArrayList;

/**
 *  Um Gene que representa o Ambiente preferido do animal.
 */
public class GeneAmbiente extends GeneMutavel implements Registo<GeneAmbiente>{

    private static ArrayList<GeneAmbiente> allInstancesCreated = new ArrayList<>(200);
    private String ambiente;

    public GeneAmbiente(FormatedString fstr) throws RepresentacaoInvalidaDoTipo {
        super(fstr,"GeneAmbiente");
        this.ambiente = fstr.getAtributo("Ambiente","GeneAmbiente");
        if(!Ambiente.estaRepresentado(this.ambiente))
            throw new RepresentacaoInvalidaDoTipo("O valor do campo Ambiente não representa nenhum do tipo Ambiente.");
    }
    
    public GeneAmbiente(Ambiente ambiente, String nome , int geracao) {
        super(nome,geracao);
        this.ambiente = ambiente.toString() ;
    }
    
    public GeneAmbiente(Ambiente ambiente, String nome ) {
        super(nome);
        this.ambiente = ambiente.toString() ;
    }
    
    public static ArrayList<GeneAmbiente> getAllInstances(){
        return allInstancesCreated; 
    }
    
    public static void addInstanceToResgisto( GeneAmbiente instance ){  
        allInstancesCreated.add(instance);
    }
   
    public static void removeInstanceToRegisto( GeneAmbiente instance ){
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
    
    public String getAmbiente() {
        return ambiente;
    }
       
    @Override
    public void mutar() {
                
        if( Gerador.gerarProbabilidade() <= 10){
            
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
        fsrt.addAtributo("Mutado",  this.estaMutado());
        fsrt.addAtributo("Ambiente",  this.getAmbiente());
        return fsrt;
        
    }
    
    @Override
    public String toString(){

        return "GeneAmbiente(Id:" + this.getId() + ";Nome:" + this.getNome() + ";Geracao:" + this.getGeracao() + ";Ambiente:"+ this.getAmbiente() +")" ;
    }
    
    @Override
    public boolean equals(Object obj) {
                
        if (this == obj) return true;
        if (obj == null) return false;
        if ( getClass() != obj.getClass() ) return false;
        
        final GeneAmbiente gene = (GeneAmbiente)obj;      
        return (this.getNome().equals(gene.getNome() )) && (this.getGeracao() == gene.getGeracao()) && (this.estaMutado() == gene.estaMutado()) && (this.getAmbiente().equals(gene.getAmbiente() )) ;
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
