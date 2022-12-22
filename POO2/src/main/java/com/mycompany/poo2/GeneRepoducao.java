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
public class GeneRepoducao extends GeneCaraterisca implements Registo<GeneRepoducao>{

    private int apetite;
    private static ArrayList<GeneRepoducao> allInstancesCreated = new ArrayList<>(200);

    public GeneRepoducao(FormatedString fstr) throws RepresentacaoInvalidaDoTipo{
        super(fstr , "GeneRepoducao");
        this.apetite = Integer.parseInt(fstr.getAtributo("Apetite") );
    }

    public GeneRepoducao(int apetite, String nome) {
        super(nome);
        this.apetite = apetite;
    }

    public int getApetite() {
        return apetite;
    }
    
    @Override
    public ArrayList<GeneRepoducao> getAllInstances(){
        return allInstancesCreated; 
    }
    
    @Override
    public void addInstance( GeneRepoducao instance ){  
        allInstancesCreated.add(instance);
    }
   
    @Override
    public void removeInstance( GeneRepoducao instance ){
        allInstancesCreated.remove(instance);   
    }

    @Override
    public void mutar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public FormatedString toFormatedString(){
        
        FormatedString fsrt = new FormatedString("GeneEspecie",4);
        fsrt.addAtributo("Nome", this.getNome() );
        fsrt.addAtributo("Id",  this.getId() );
        fsrt.addAtributo("Geracao",  this.getGeracao() );
        fsrt.addAtributo("Apetite",  this.getApetite());
        return fsrt;
        
    }
    
    @Override
    public String toString(){

        return "GeneEspecie(Id:" + this.getId() + ";Nome:" + this.getNome() + ";Geracao:" + this.getGeracao() + ",Apetite:"+ this.getApetite() +")" ;
    }

}
