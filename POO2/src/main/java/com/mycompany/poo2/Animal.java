/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.Objects;

/**
 *
 * @author Pedro
 */
public class Animal implements Gravavel {

    private static int lastId = 0;
    
    private int id;
    private String nomeArtistico;
    private String nomeArtisticoPai;
    private String nomeArtisticoMae;
    private Genoma genoma;
    private int idade;//dias
    private int atratividadeBase;
    private boolean doente;
    private boolean tratado;
    private int ultimaTratacao;
    
    public Animal( String nomeArtisticoPai , String nomeArtisticoMae , boolean doente, Genoma genoma, int atratividadeBase ) {
        
        this.nomeArtisticoPai = nomeArtisticoPai;
        this.nomeArtisticoMae = nomeArtisticoMae;
        this.genoma = genoma;
        this.id = ++lastId;
        this.idade = 0;
        this.atratividadeBase = atratividadeBase;
        this.doente = false;
        this.tratado = true;
        this.ultimaTratacao = 0 ;
        this.nomeArtistico = this.genoma.getEspecie().getNome() + "_animal_ " + this.id ;
        
    }

    public Animal(String nomeArtistico , String nomeArtisticoPai , String nomeArtisticoMae , boolean doente , Genoma genoma, int atratividadeBase ) {
        
        this.nomeArtistico = nomeArtistico;
        this.nomeArtisticoPai = nomeArtisticoPai;
        this.nomeArtisticoMae = nomeArtisticoMae;
        this.genoma = genoma;
        this.id = ++lastId;
        this.idade = 0;
        this.atratividadeBase = atratividadeBase;
        this.doente = doente;
        this.tratado = true;
        this.ultimaTratacao = 0 ;
        
    }
    
    public Animal(FormatedString fstr) throws RepresentacaoInvalidaDoTipo,NumberFormatException {
                
        String className = Animal.class.getSimpleName();
        if( !fstr.getTipo().equals( className ) ) throw  new RepresentacaoInvalidaDoTipo("FormatedString fsrt não representa um : " + Instalacao.class.getSimpleName() );
        
        this.nomeArtistico = fstr.getAtributo("NomeArtistico",className);
        this.nomeArtisticoPai = fstr.getAtributo("NomePai",className);
        this.nomeArtisticoMae = fstr.getAtributo("NomeMae",className);
        this.genoma = new Genoma(  new FormatedString(fstr.getAtributo("NomeArtistico",className)) );
        this.id = Integer.parseInt(fstr.getAtributo("Id",className));
        this.idade = Integer.parseInt(fstr.getAtributo("Idade",className));
        this.atratividadeBase = Integer.parseInt(fstr.getAtributo("AtratividadeBase",className));
        this.doente = Boolean.parseBoolean(fstr.getAtributo("Doente",className));
        this.tratado = Boolean.parseBoolean(fstr.getAtributo("Tratado",className));
        this.ultimaTratacao = Integer.parseInt(fstr.getAtributo("UltimaTratacao",className));
        
        if (lastId < this.id) {
            lastId = this.id;
        }
        
    }
    
    public int getId() {
        return id;
    }

    public String getNomeArtistico() {
        return this.nomeArtistico;
    }
    
    public String setNomeArtistico() {
        return this.nomeArtistico;
    }
    
    public String getNomeArtisticoPai() {
        return this.nomeArtisticoPai;
    }
    
    public String getNomeArtisticoMae() {
        return this.nomeArtisticoMae;
    }

    public Genoma getGenoma() {
        return this.genoma;
    }
    
    public int getAtratividadeBase() {
        return this.atratividadeBase ;
    }
    
    public int getAtratividade() {
        return this.atratividadeBase + this.genoma.getGeneAtratividade().getAtratividade() ;
    }

    public int getIdade() {
        return idade;
    }
    
    public int getIdadeAnos() {
        return idade/365;
    }
      
    public int getUltimaTratacao(){
        return this.ultimaTratacao;
    }
        
    public boolean estaDoente(){
        return this.doente;
    }
    
    public boolean estaTratado(){
        return this.tratado;
    }
    
    public void envelhecer(){
        this.idade++;
    }
    
    public TipoMorte morre(boolean abate) {       
        if (abate) 
            return TipoMorte.ABATE;
        else 
            return morreProb();  
    }
    
    
    public Boolean foge(Instalacao instalacao,Boolean jumanji) {
        if (jumanji ) 
            return Gerador.gerarProbabilidade() <= 50;
        else
            return this.foge(instalacao);
    }
    
    private Boolean foge(Instalacao instalacao) {
        return instalacao.precisaManutencao() && Gerador.gerarProbabilidade() < instalacao.getUltimaManutencao()*10 ; 
    }
    
    public TipoMorte morre() {
        return morreProb(); 
    }
    
    public boolean ficaDoente(Instalacao instalacao) {
        
        double chance = Math.pow( ( (double)(((10 + this.genoma.getGeneLogitividade().getAnos()) / this.genoma.getGeneLogitividade().getAnos()) - 1) / 2.5 ) + 1, this.getIdadeAnos() );
        if (instalacao.estaPrecaria())
            chance += 20;
        
        this.doente = Gerador.gerarProbabilidade() < chance;
        
        return this.doente;
        
    }
    
    public boolean ficaCorado(Veterinario veterinario) {
        
        double chance = (veterinario.getExperiencia()/100) + 25;
        if (Gerador.gerarProbabilidade() <= chance) {
            this.doente = false;  
            return true;
        }else{
            return false;
        }
        
    }

    public Animal reproduzir(Animal animal) {
        
        if (!this.equals(animal)) {
            
            if( Gerador.gerarProbabilidade() < this.genoma.getGeneRepoducao().getApetite()  ){

                if( Gerador.gerarProbabilidade() < animal.genoma.getGeneRepoducao().getApetite() ){

                    if( !this.genoma.getGeneSexo().getSexo().equals(animal.getGenoma().getGeneSexo().getSexo()) ){

                        Genoma novoGenoma = Genoma.comabinarGenomas(this.genoma,animal.getGenoma());
                        int atratividade = (this.getAtratividadeBase() + animal.getAtratividadeBase()) / 2;
                        
                        boolean doent = false;
                        if ((this.estaDoente() || animal.estaDoente()) && Gerador.gerarProbabilidade() < 50 ) doent = true;

                        if (this.genoma.getGeneSexo().getSexo().equals(Sexo.MACHO.toString() )) 
                            return new Animal(this.getNomeArtistico(),animal.getNomeArtistico(),doent,novoGenoma,atratividade);
                        else
                            return new Animal(animal.getNomeArtistico(),this.getNomeArtistico(),doent,novoGenoma,atratividade);

                    } else return null;

                }else return null;

            }else return null;
        
        }else
            return null;
        
    }

    public void aumentarAtratividadeBase(int bonus) {
        if ( bonus > 0 )
            this.atratividadeBase+=bonus;
    }

    @Override
    public FormatedString toFormatedString() {
        
        FormatedString fstr = new FormatedString(Animal.class.getSimpleName(), 8);
        fstr.addAtributo("Id", this.getId());
        fstr.addAtributo("NomeArtistico", this.getNomeArtistico());
        fstr.addAtributo("NomeArtisticoPai", this.getNomeArtisticoPai());
        fstr.addAtributo("NomeArtisticoMae", this.getNomeArtisticoMae());
        fstr.addAtributo("Genoma", this.genoma.toFormatedString());
        fstr.addAtributo("Idade", this.getIdade());
        fstr.addAtributo("AtratividadeBase", this.getAtratividadeBase());
        fstr.addAtributo("Doente", this.estaDoente());
        fstr.addAtributo("Tratado", this.estaTratado());
        fstr.addAtributo("UltimaTratacao", this.getUltimaTratacao());
        
        return fstr;
    }

    @Override
    public String toString() {
        return "Animal tem: Id:" + this.id + ", Nome Artistico:" + this.nomeArtistico + ", Genoma:" + this.genoma + ", Idade:" + this.idade + ", Atratividade Base:" + this.atratividadeBase;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.genoma, other.genoma);
    }
    
    private  TipoMorte morreProb(){
        
        double chance = Math.pow( ( (double)(((11 + this.genoma.getGeneLogitividade().getAnos()) / this.genoma.getGeneLogitividade().getAnos()) - 1) / 2.5 ) + 1, this.getIdadeAnos());
        
        if (this.doente)chance += 10;
        if (!this.tratado && this.ultimaTratacao > 1 ) chance += (int) Math.pow(2, this.ultimaTratacao)*5;
        
        if(Gerador.gerarProbabilidade() < chance){
            
            if (this.doente) return TipoMorte.DOENTE;
            if (!this.tratado) 
                return TipoMorte.FOME;
            else
                return TipoMorte.IDOSO;
            
        }else
            return null;
    
    }
    
}
