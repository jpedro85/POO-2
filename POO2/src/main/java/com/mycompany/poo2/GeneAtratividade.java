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
public class GeneAtratividade extends GeneCaraterisca implements Registo<GeneAtratividade>{

    private int atratividade;
    private static ArrayList<GeneAtratividade> allInstancesCreated = new ArrayList<>(200);

    public GeneAtratividade(int atratividade, String nome) {
        super(nome);
        this.atratividade = atratividade;
        addInstance(this);
    }

    public GeneAtratividade(FormatedString fstr) throws RepresentacaoInvalidaDoTipo{
        super(fstr,"GeneAtratividade");
        this.atratividade = Integer.parseInt ( fstr.getAtributo("Atratividade") );
        addInstance(this);
    }

    public int getAtratividade() {
        return atratividade;
    }
    
    @Override
    public ArrayList<GeneAtratividade> getAllInstances(){
        return allInstancesCreated; 
    }
    
    @Override
    public void addInstance( GeneAtratividade instance ){  
        allInstancesCreated.add(instance);
    }
   
    @Override
    public void removeInstance( GeneAtratividade instance ){
        allInstancesCreated.remove(instance);   
    }
    
    @Override
    public void mutar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public FormatedString toFormatedString(){
        
        FormatedString fsrt = new FormatedString(this.getClass().getSimpleName(),4);
        fsrt.addAtributo("Nome", this.getNome());
        fsrt.addAtributo("Id",  this.getId() );
        fsrt.addAtributo("Geracao",  this.getGeracao() );
        fsrt.addAtributo("Atratividade",  this.getAtratividade());
        return fsrt;
        
    }
    
    @Override
    public String toString(){

        return "GeneEspecie(Id:" + this.getId() + ";Nome:" + this.getNome() + ";Geracao:" + this.getGeracao() + ",Atratividade:"+ this.getAtratividade() +")" ;
    }

}
