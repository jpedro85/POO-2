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
public class GeneDieta extends Gene implements Registo<GeneDieta>{
    
    private String dieta;
    private static ArrayList<GeneDieta> allInstancesCreated = new ArrayList<>(200);

    public GeneDieta(FormatedString fstr) throws RepresentacaoInvalidaDoTipo{
        super(fstr , "GeneDieta");
        this.dieta = fstr.getAtributo("Dieta","GeneDieta") ;
    }

    public GeneDieta(Dieta diteta, String nome) {
        super(nome);
        this.dieta = diteta.toString();
    }

    public String getDiteta() {
        return dieta;
    }
    
    @Override
    public ArrayList<GeneDieta> getAllInstances(){
        return allInstancesCreated; 
    }
    
    @Override
    public void addInstance( GeneDieta instance ){  
        allInstancesCreated.add(instance);
    }
   
    @Override
    public void removeInstance( GeneDieta instance ){
        allInstancesCreated.remove(instance);   
    }

    @Override
    public FormatedString toFormatedString(){
        
        FormatedString fsrt = new FormatedString(this.getClass().getSimpleName(),4);
        fsrt.addAtributo("Id",  this.getId() );
        fsrt.addAtributo("Nome", this.getNome() );
        fsrt.addAtributo("Dieta",  this.getDiteta());
        return fsrt;
        
    }
    
    @Override
    public String toString(){

        return "GeneDieta(Id:" + this.getId() + ";Nome:" + this.getNome() + ";Dieta:"+ this.getDiteta() + ")" ;
    }
    
    @Override
    public boolean equals(Object obj) {
                
        if (this == obj) return true;
        if (obj == null) return false;
        if ( getClass() != obj.getClass() ) return false;
        
        final GeneDieta gene = (GeneDieta)obj;      
        return (this.getNome().equals(gene.getNome() )) && (this.dieta.equals(gene.getDiteta())) ;
    }
    
    @Override
    public GeneDieta clone(){
        
        Dieta temp = Dieta.CARNIVORO ;
        
        for(Dieta amb: Dieta.values() ){
            
            if( amb.toString().equals(this.getDiteta())){
                temp = amb; 
            }
               
        }
        
        return new GeneDieta(temp,this.getNome());
    }
}