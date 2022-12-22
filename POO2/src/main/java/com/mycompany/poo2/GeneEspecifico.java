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
        addInstance(this);
    }
     
    public GeneEspecifico(FormatedString fstr) throws RepresentacaoInvalidaDoTipo {
        
        super(fstr , "GeneEspecifico");
        this.valor = fstr.getAtributo("Valor");
        this.tipo = fstr.getAtributo("Tipo");
        addInstance(this);
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
        fsrt.addAtributo("Geracao",  this.getGeracao() );
        fsrt.addAtributo("Valor",  this.getValor());
        fsrt.addAtributo("Tipo",  this.getTipo());
        return fsrt;
        
    }
    
    @Override
    public String toString(){

        return "GeneEspecifico(Id:" + this.getId() + ";Nome:" + this.getNome() + ";Geracao:" + this.getGeracao() + ",Valor:"+ this.valor + ",Tipo:"+ this.tipo + ")" ;
    }
}
