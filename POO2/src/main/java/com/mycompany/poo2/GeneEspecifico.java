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
public class GeneEspecifico extends Gene implements Registo<GeneEspecifico> {
    
    private String valor;
    private String tipo; 
    private static ArrayList<GeneEspecifico> allInstancesCreated = new ArrayList<>(200);
    
    public GeneEspecifico(String valor, String nome , CararcteristicasEspecificas tipo) {
        super(nome);
        this.valor = valor;
        this.tipo = tipo.toString();
    }
     
    public GeneEspecifico(FormatedString fstr) throws RepresentacaoInvalidaDoTipo {
        
        super(fstr , "GeneEspecifico");
        this.valor = fstr.getAtributo("Valor","GeneEspecifico");
        this.tipo = fstr.getAtributo("Tipo","GeneEspecifico");
    }
    
    @Override
    public ArrayList<GeneEspecifico> getAllInstances(){
        return allInstancesCreated; 
    }
    
    @Override
    public void addInstance( GeneEspecifico instance ){  
        allInstancesCreated.add(instance);
    }
   
    @Override
    public void removeInstance( GeneEspecifico instance ){
        allInstancesCreated.remove(instance);   
    }
    
    public String getValor(){
        return this.valor;
    }
    
    public String getTipo(){
        return this.tipo;
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
    public GeneEspecifico clone(){
        
        CararcteristicasEspecificas temp = CararcteristicasEspecificas.OLHOS;
      
        for(CararcteristicasEspecificas amb: CararcteristicasEspecificas.values() ){
            
            if( amb.toString().equals(this.getTipo())){
                temp = amb; 
            }
               
        }
   
        return new GeneEspecifico(this.getValor(),this.getNome(),temp);
    }
}
