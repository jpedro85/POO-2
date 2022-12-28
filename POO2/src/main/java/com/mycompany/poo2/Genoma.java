/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  Repreenta o genoma do animal 
 */
public class Genoma implements Gravavel{

    private GeneSexo sexo;
    private GeneDieta dieta;
    private GeneAtratividade atratividade;
    private GeneLongividade logitividade;
    private GeneRepoducao repoducao;
    private GeneAmbiente ambiete;
    private ArrayList<GeneEspecifico> especificos;
    private Especie especie;

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
        this.especificos.addAll(Arrays.asList(genesEspecificos));
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
        this.especificos = FormatedString.converterFormatedArray(GeneEspecifico.class, fstr.getAtributo("Especificos", "Genoma"));

    }
    
    public Especie getEspecie(){
        return this.especie;
    }
    
    public ArrayList<GeneEspecie> getGenesEspecies(){
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
    
    public boolean isMutado(){
        
        if (!this.ambiete.estaMutado())return false;
        if (!this.logitividade.estaMutado())return false;
        if (!this.repoducao.estaMutado())return false;
        return this.atratividade.estaMutado();
    }
        
    public static Genoma comabinarGenomas (Genoma genoma1 , Genoma genoma2){
            
        Especie especie = escolher( genoma1.getEspecie(),genoma2.getEspecie() );

        int tamanho = genoma1.getGenesEspecificos().size() + genoma2.getGenesEspecificos().size();        
        ArrayList<GeneEspecifico> espedificos = new ArrayList<>(tamanho);
        espedificos.addAll(genoma1.getGenesEspecificos());
        
        for (GeneEspecifico gene_presente: espedificos) {
            
            for (GeneEspecifico gene_por: genoma2.getGenesEspecificos()) {
                
                if (!gene_por.equals(gene_presente)) espedificos.add(gene_por);
            }  
        }
        
        GeneDieta geneDieta = escolher(genoma1.getGeneDieta(),genoma2.getGeneDieta()).clone();
        GeneSexo geneSexo = escolher(genoma1.getGeneSexo(),genoma2.getGeneSexo()).clone();
        
        GeneLongividade geneLongitividade = escolher(genoma1.getGeneLogitividade(),genoma2.getGeneLogitividade()).clone();
        geneLongitividade.mutar();
        
        GeneRepoducao geneReproducao = escolher(genoma1.getGeneRepoducao(),genoma2.getGeneRepoducao()).clone();
        geneReproducao.mutar();
        
        GeneAmbiente geneAmbiente = escolher(genoma1.getGeneAmbiete(),genoma2.getGeneAmbiete()).clone();
        geneAmbiente.mutar();
        
        GeneAtratividade geneAtratividade = escolher(genoma1.getGeneAtratividade(),genoma2.getGeneAtratividade()).clone();
        geneAtratividade.mutar();
        
        
        return new Genoma(especie,geneSexo,geneDieta,geneAtratividade,geneLongitividade,geneReproducao,geneAmbiente, espedificos);   
    }
    
    private static <T> T escolher(T a,T b){
        
        if ( a.equals(b) ) {
            
            return a;
            
        }else{
        
            if(Gerador.gerarProbabilidade() < 50)
                return a;
            else
                return b;
            
        }
    }
        
    @Override
    public FormatedString toFormatedString(){
        
        FormatedString fstr = new FormatedString("Genoma",8);
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
        
        String temp = "Genoma("+this.especie ;
        temp += ";Genes:\n\t" + this.sexo + "\n";
        temp += "\t" + this.dieta + "\n";
        temp += "\t" + this.atratividade + "\n";
        temp += "\t" + this.logitividade + "\n";
        temp += "\t" + this.repoducao + "\n";
        temp += "\t" + this.ambiete + "\n";
        temp += "\t" + "Especificos" + this.especificos + ")";
        
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
