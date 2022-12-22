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
public class GeneDieta extends GeneCaraterisca implements Registo<GeneDieta>{
    
    private String dieta;
    private static ArrayList<GeneDieta> allInstancesCreated = new ArrayList<>(200);

    public GeneDieta(FormatedString fstr) throws RepresentacaoInvalidaDoTipo{
        super(fstr , "GeneDieta");
        this.dieta = fstr.getAtributo("Dieta") ;
        addInstance(this);
    }

    public GeneDieta(Dieta diteta, String nome) {
        super(nome);
        this.dieta = diteta.toString();
        addInstance(this);
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
    public void mutar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public FormatedString toFormatedString(){
        
        FormatedString fsrt = new FormatedString(this.getClass().getSimpleName(),4);
        fsrt.addAtributo("Id",  this.getId() );
        fsrt.addAtributo("Nome", this.getNome() );
        fsrt.addAtributo("Geracao",  this.getGeracao() );
        fsrt.addAtributo("Dieta",  this.getDiteta());
        return fsrt;
        
    }
    
    @Override
    public String toString(){

        return "GeneDieta(Id:" + this.getId() + ";Nome:" + this.getNome() + ";Geracao:" + this.getGeracao() + ",Dieta:"+ this.getDiteta()+")" ;
    }
}
