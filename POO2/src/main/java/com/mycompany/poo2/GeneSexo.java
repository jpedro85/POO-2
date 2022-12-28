/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.ArrayList;

/**
 *  Um Gene que representa se o animal é macho ou femia.
 */
public class GeneSexo extends Gene implements Registo<GeneSexo>{

    private static ArrayList<GeneSexo> allInstancesCreated = new ArrayList<>(200);
    private String sexo;

    public GeneSexo(Sexo sexo, String nome ) {
        super(nome);
        this.sexo = sexo.toString();
    }

    public GeneSexo(FormatedString fstr) throws RepresentacaoInvalidaDoTipo{
        super(fstr , "GeneSexo");
        this.sexo = fstr.getAtributo("Sexo","GeneSexo");
        if(!Sexo.estaRepresentado(this.sexo))
            throw new RepresentacaoInvalidaDoTipo("O valor do campo Sexo não representa nenhum do tipo Sexo.");
    }
    
    public static ArrayList<GeneSexo> getAllInstances(){
        return allInstancesCreated; 
    }
    
    public static void addInstanceToResgisto( GeneSexo instance ){  
        allInstancesCreated.add(instance);
    }
   
    public static void removeInstanceToRegisto( GeneSexo instance ){
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
    
    public String getSexo() {
        return sexo;
    }
    
    @Override
    public FormatedString toFormatedString(){
        
        FormatedString fsrt = new FormatedString(this.getClass().getSimpleName(),4);
        fsrt.addAtributo("Id",  this.getId() );
        fsrt.addAtributo("Nome", this.getNome() );
        fsrt.addAtributo("Sexo",  this.getSexo() );
        return fsrt;
        
    }
    
    @Override
    public String toString(){

        return "GeneSexo(Id:" + this.getId() + ";Nome:" + this.getNome() + ";Sexo:"+ this.getSexo()+")" ;
    }
    
    @Override
    public boolean equals(Object obj) {
                
        if (this == obj) return true;
        if (obj == null) return false;
        if ( getClass() != obj.getClass() ) return false;
        
        final GeneSexo gene = (GeneSexo)obj;      
        return (this.getNome().equals(gene.getNome() )) && (this.getSexo().equals(gene.getSexo())) ;
    }
    
    public GeneSexo clone(){
        
        Sexo temp = Sexo.FEMEA ;
        
        for(Sexo amb: Sexo.values() ){
            
            if( amb.toString().equals(this.getSexo())){
                temp = amb; 
            }
               
        }
        
        return new GeneSexo(temp,this.getNome());
    }

}
