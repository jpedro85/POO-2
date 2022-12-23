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

    private GeneSexo sexo;
    private GeneDieta dieta;
    private GeneAtratividade atratividade;
    private GeneLongividade logitividade;
    private GeneRepoducao repoducao;
    private GeneAmbiente ambiete;
    private ArrayList<GeneEspecifico> especificos;
    private Especie especie;
    private static ArrayList<Genoma> allInstancesCreated = new ArrayList<>(200);

    public Genoma(Especie especie ,GeneSexo sexo, GeneDieta dieta, GeneAtratividade atratividade, GeneLongividade logitividade, GeneRepoducao repoducao, GeneAmbiente ambiete, ArrayList<GeneEspecifico> especificos) {
        this.sexo = sexo.clone();
        this.dieta = dieta.clone();
        this.atratividade = atratividade.clone();
        this.logitividade = logitividade.clone();
        this.repoducao = repoducao.clone();
        this.ambiete = ambiete.clone();
        this.especie = especie;
        this.especificos = especificos;
    }
    
    public Genoma(Especie especie ,GeneSexo sexo, GeneDieta dieta, GeneAtratividade atratividade, GeneLongividade logitividade, GeneRepoducao repoducao, GeneAmbiente ambiete, GeneEspecifico ... genesEspecificos) {
        this.sexo = sexo.clone();
        this.dieta = dieta.clone();
        this.atratividade = atratividade.clone();
        this.logitividade = logitividade.clone();
        this.repoducao = repoducao.clone();
        this.ambiete = ambiete.clone();
        this.especie = especie;
        this.especificos = new ArrayList<>(genesEspecificos.length );
        
        for (GeneEspecifico gene : genesEspecificos ) {
            this.especificos.add(gene);
        }
    }
    
    public Genoma(FormatedString fstr) throws RepresentacaoInvalidaDoTipo {
        
        if ( !fstr.getTipo().equals("Genoma") ) 
            throw new RepresentacaoInvalidaDoTipo("A FormatedString : " + fstr + " não representa um Genoma.");
        
        this.sexo = new GeneSexo( new FormatedString(fstr.getAtributo("GeneSexo","Genoma")) );
        this.dieta = new GeneDieta( new FormatedString(fstr.getAtributo("GeneDieta","Genoma")) );
        this.atratividade = new GeneAtratividade( new FormatedString(fstr.getAtributo("GeneAtratividade","Genoma")) );
        this.logitividade = new GeneLongividade( new FormatedString(fstr.getAtributo("GeneLongividade","Genoma")) );
        this.repoducao = new GeneRepoducao( new FormatedString(fstr.getAtributo("GeneRepoducao","Genoma")) );
        this.ambiete = new GeneAmbiente( new FormatedString(fstr.getAtributo("GeneAmbiente","Genoma")) );
        this.especie = new Especie( new FormatedString(fstr.getAtributo("Especie","Genoma")) );
        this.especificos = FormatedString.converterFormatedArray("Especificos", fstr.getAtributo("Especificos", "Genoma"));

    }
    
    public Especie getEspecie(){
        return this.especie;
    }
    
    public ArrayList<GeneEspecie> getGeneEspecies(){
        return this.especie.getGenes();
    }

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

    public ArrayList<GeneEspecifico> getGenesEspecificos() {
        return this.especificos;
    }
    
    public String getGeneEspecifico(int i) {
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
        
        FormatedString fstr = new FormatedString("Genoma",4);
        fstr.addAtributo("GeneSexo", this.sexo.toFormatedString() );
        fstr.addAtributo("GeneDieta", this.dieta.toFormatedString() );
        fstr.addAtributo("GeneAtratividade", this.atratividade.toFormatedString() );
        fstr.addAtributo("GeneLongividade", this.logitividade.toFormatedString() );
        fstr.addAtributo("GeneRepoducao", this.repoducao.toFormatedString() );
        fstr.addAtributo("GeneAmbiente", this.ambiete.toFormatedString() );
        fstr.addAtributo("Especie", this.especie.toFormatedString() );
        fstr.addAtributo("Especificos", FormatedString.formatArray(this.especificos) );

        return fstr;
        
    }
    
    @Override
    public String toString(){
        
        String temp = "Genoma(Genes:\n";
        temp += this.sexo + "\n";
        temp += this.dieta + "\n";
        temp += this.atratividade + "\n";
        temp += this.logitividade + "\n";
        temp += this.repoducao + "\n";
        temp += this.ambiete + "\n";
        temp += this.especie + "\n";
        temp += this.especificos + ")";
        
        return temp;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
      
        final Genoma genoma = (Genoma) obj;
        
        if(! this.sexo.equals(genoma.getGeneSexo() )) return false;
        if(! this.repoducao.equals(genoma.getGeneRepoducao() )) return false;
        if(! this.logitividade.equals(genoma.getGeneLogitividade() )) return false;
        if(! this.especie.equals(genoma.getEspecie() )) return false;
        if(! this.dieta.equals(genoma.getGeneDieta())) return false;
        if(! this.atratividade.equals(genoma.getGeneAtratividade())) return false;
        if(! this.ambiete.equals(genoma.getGeneAmbiete() )) return false;
        
        return this.especificos.equals(genoma.getGenesEspecificos() );
    }
}
