/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.ArrayList;

/**
 *  Um Gene que representa uma caracteristica do animal.
 */
public class GeneEspecifico extends Gene implements Registo<GeneEspecifico> {

    private static ArrayList<GeneEspecifico> allInstancesCreated = new ArrayList<>(200);    
    private String valor;
    private String tipo; 

    
    public GeneEspecifico(String valor, String nome , CararcteristicasEspecificas tipo){   
        super(nome);
        this.valor = valor;
        this.tipo = tipo.toString();
    }
     
    public GeneEspecifico(FormatedString fstr) throws RepresentacaoInvalidaDoTipo {
        
        super(fstr , "GeneEspecifico");
        this.valor = fstr.getAtributo("Valor","GeneEspecifico");
        this.tipo = fstr.getAtributo("Tipo","GeneEspecifico");
        if(!CararcteristicasEspecificas.estaRepresentado(this.tipo))
            throw new RepresentacaoInvalidaDoTipo("O valor do campo Tipo não representa nenhum do tipo CararcteristicasEspecificas.");
    }
    
    public String getValor(){
        return this.valor;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public static ArrayList<GeneEspecifico> getAllInstances(){
        return allInstancesCreated; 
    }
    
    public static void addInstanceToResgisto( GeneEspecifico instance ){  
        allInstancesCreated.add(instance);
    }
   
    public static void removeInstanceToRegisto( GeneEspecifico instance ){
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
    
    @Override
    public FormatedString toFormatedString(){
        
        FormatedString fsrt = new FormatedString(this.getClass().getSimpleName(),5);
        fsrt.addAtributo("Id",  this.getId() );
        fsrt.addAtributo("Nome", this.getNome());
        fsrt.addAtributo("Valor",  this.getValor());
        fsrt.addAtributo("Tipo",  this.getTipo());
        return fsrt;
        
    }
    
    @Override
    public String toString(){

        return "GeneEspecifico(Id:" + this.getId() + ";Nome:" + this.getNome() + ";Valor:"+ this.valor + ";Tipo:"+ this.tipo + ")" ;
    }
    
    @Override
    public boolean equals(Object obj) {
                
        if (this == obj) return true;
        if (obj == null) return false;
        if ( getClass() != obj.getClass() ) return false;
        
        final GeneEspecifico gene = (GeneEspecifico)obj;      
        return (this.getNome().equals(gene.getNome() )) && (gene.getTipo().equals(gene.getTipo())) && (this.getValor().equals(gene.getValor())) ;
    }
    
    @Override
    public GeneEspecifico clone() {
        
        CararcteristicasEspecificas temp = CararcteristicasEspecificas.OLHOS;
      
        for(CararcteristicasEspecificas amb: CararcteristicasEspecificas.values() ){
            
            if( amb.toString().equals(this.getTipo())){
                temp = amb; 
            }
               
        }
   
        return new GeneEspecifico(this.getValor(),this.getNome(),temp);
    }
}
