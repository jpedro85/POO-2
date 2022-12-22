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
public class GeneAmbiente extends GeneCaraterisca implements Registo<GeneAmbiente>{

    private String ambiente;
    private static ArrayList<GeneAmbiente> allInstancesCreated = new ArrayList<>(200);

    public GeneAmbiente(FormatedString fstr) throws RepresentacaoInvalidaDoTipo {
        super(fstr,"GeneAmbiente");
        this.ambiente = fstr.getAtributo("Ambiente");
    }

    public GeneAmbiente(Ambiente ambiente, String nome) {
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
        throw new UnsupportedOperationException("Not supported yet."); 
    }
   
    @Override
    public FormatedString toFormatedString(){
        
        FormatedString fsrt = new FormatedString("GeneEspecie",4);
        fsrt.addAtributo("Nome", this.getNome());
        fsrt.addAtributo("Id",  this.getId() );
        fsrt.addAtributo("Geracao",  this.getGeracao() );
        fsrt.addAtributo("Ambiente",  this.getAmbiente());
        return fsrt;
        
    }
    
    @Override
    public String toString(){

        return "GeneEspecie(Id:" + this.getId() + ";Nome:" + this.getNome() + ";Geracao:" + this.getGeracao() + ",Ambiente:"+ this.getAmbiente() +")" ;
    }

}
