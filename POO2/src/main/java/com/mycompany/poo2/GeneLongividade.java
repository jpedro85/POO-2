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
public class GeneLongividade extends GeneCaraterisca implements Registo<GeneLongividade>{

    private int anos;
    private static ArrayList<GeneLongividade> allInstancesCreated = new ArrayList<>(200);

    public GeneLongividade(FormatedString fstr) throws RepresentacaoInvalidaDoTipo {
        super(fstr,"GeneLongividade");
        this.anos = Integer.parseInt( fstr.getAtributo("Anos"));
        addInstance(this);
    }

    public GeneLongividade(int anos, String nome) {
        super(nome);
        this.anos = anos;
        addInstance(this);
    }

    public int getAnos() {
        return anos;
    }
    
    @Override
    public ArrayList<GeneLongividade> getAllInstances(){
        return allInstancesCreated; 
    }
    
    @Override
    public void addInstance( GeneLongividade instance ){  
        allInstancesCreated.add(instance);
    }
   
    @Override
    public void removeInstance( GeneLongividade instance ){
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
        fsrt.addAtributo("Anos",  this.getAnos() );
        return fsrt;
        
    }
    
    @Override
    public String toString(){

        return "GeneLongividade(Id:" + this.getId() + ";Nome:" + this.getNome() + ";Geracao:" + this.getGeracao() + ",Anos:"+ this.getAnos()+")" ;
    }

}
