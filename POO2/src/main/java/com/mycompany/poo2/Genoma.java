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
public class Genoma implements Gravavel,Registo<Genoma>{
    //add especie
    private GeneSexo sexo;
    private GeneDieta dieta;
    private GeneAtratividade atratividade;
    private GeneLongividade logitividade;
    private GeneRepoducao repoducao;
    private GeneAmbiente ambiete;
    private ArrayList<GeneEspecifico> especificos;
    private static ArrayList<Genoma> allInstancesCreated = new ArrayList<>(200);
    
    public Genoma(GeneSexo sexo, GeneDieta dieta, GeneAtratividade atratividade, GeneLongividade logitividade, GeneRepoducao repoducao, GeneAmbiente ambiete, ArrayList<GeneEspecifico> especificos) {
        this.sexo = sexo;
        this.dieta = dieta;
        this.atratividade = atratividade;
        this.logitividade = logitividade;
        this.repoducao = repoducao;
        this.ambiete = ambiete;
        this.especificos = especificos;
    }
    
    //add getEspecie e getGeneEspecies

    public GeneSexo getGeneSexo(){
        return this.sexo;
    }
    public String getSexo() {
        return sexo.getSexo();
    }
    
    public GeneDieta getGeneDieta(){
        return this.dieta;
    }

    public String getDieta() {
        return dieta.getDiteta();
    }

    public GeneAtratividade getGeneAtratividade() {
        return this.atratividade;
    }
    public int getAtratividade() {
        return atratividade.getAtratividade();
    }

    public GeneLongividade getGeneLogitividade() {
        return this.logitividade;
    }
    
    public int getLogitividade() {
        return logitividade.getAnos();
    }

    public GeneRepoducao getGeneRepoducao() {
        return this.repoducao;
    }
    
    public int getRepoducao() {
        return repoducao.getApetite();
    }

    public GeneAmbiente getGeneAmbiete() {
        return this.ambiete;
    }
    
    public String getAmbiete() {
        return ambiete.getAmbiente();
    }

    public ArrayList<GeneEspecifico> getGeneEspecificos() {
        return this.especificos;
    }
    
    public String getEspecificos(int i) {
        if(i>0&& i<this.especificos.size()){
            return this.especificos.get(i).getValor();
        }
        return null;
    }
    
    @Override
    public ArrayList<Genoma> getAllInstances(){
        return allInstancesCreated; 
    }
    
    @Override
    public void addInstance( Genoma instance ){  
        allInstancesCreated.add(instance);
    }
    
    @Override
    public void removeInstance( Genoma instance ){
        allInstancesCreated.remove(instance);   
    }
    
    @Override
    public FormatedString toFormatedString(){
        
        FormatedString fsrt = new FormatedString("GeneEspecie",4);
        return fsrt;
        
    }
    
    //add eDaEspecie
}
