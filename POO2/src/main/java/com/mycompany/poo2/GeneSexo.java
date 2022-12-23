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
public class GeneSexo extends Gene implements Registo<GeneSexo>{

    private String sexo;
    private static ArrayList<GeneSexo> allInstancesCreated = new ArrayList<>(200);

    public GeneSexo(Sexo sexo, String nome ) {
        super(nome);
        this.sexo = sexo.toString();
    }

    public GeneSexo(FormatedString fstr) throws RepresentacaoInvalidaDoTipo{
        super(fstr , "GeneSexo");
        this.sexo = fstr.getAtributo("Sexo","GeneSexo");
    }

    public String getSexo() {
        return sexo;
    }
    
    @Override
    public ArrayList<GeneSexo> getAllInstances(){
        return allInstancesCreated; 
    }
    
    @Override
    public void addInstance( GeneSexo instance ){  
        allInstancesCreated.add(instance);
    }
   
    @Override
    public void removeInstance( GeneSexo instance ){
        allInstancesCreated.remove(instance);   
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
