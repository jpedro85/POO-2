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
public class GeneSexo extends GeneCaraterisca implements Registo<GeneSexo>{

    private String sexo;
    private static ArrayList<GeneSexo> allInstancesCreated = new ArrayList<>(200);

    public GeneSexo(Sexo sexo, String nome) {
        super(nome);
        this.sexo = sexo.toString();
        addInstance(this);
    }

    public GeneSexo(FormatedString fstr) throws RepresentacaoInvalidaDoTipo{
        super(fstr , "GeneSexo");
        this.sexo = fstr.getAtributo("Sexo");
        addInstance(this);
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
    public void mutar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public FormatedString toFormatedString(){
        
        FormatedString fsrt = new FormatedString(this.getClass().getSimpleName(),4);
        fsrt.addAtributo("Id",  this.getId() );
        fsrt.addAtributo("Nome", this.getNome() );
        fsrt.addAtributo("Geracao",  this.getGeracao() );
        fsrt.addAtributo("Sexo",  this.getSexo() );
        return fsrt;
        
    }
    
    @Override
    public String toString(){

        return "GeneSexo(Id:" + this.getId() + ";Nome:" + this.getNome() + ";Geracao:" + this.getGeracao() + ",Sexo:"+ this.getSexo()+")" ;
    }

}
