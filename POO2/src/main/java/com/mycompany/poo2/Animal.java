/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.Objects;

/**
 * Representa um animal.
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
    
    /**
    * Cria um animal novo com valores novos nomeArtistico a defenir.
    */
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
        this.nomeArtistico = this.genoma.getEspecie().getNome() + "_animal_" + this.id ;
        
    }
    
    /**
    * Cria um animal novo com valores novos.
    */
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
    
    /**
    * Cria um animal novo apartir de uma formated string.
    */
    public Animal(FormatedString fstr) throws RepresentacaoInvalidaDoTipo,NumberFormatException {
                
        String className = Animal.class.getSimpleName();
        if( !fstr.getTipo().equals( className ) ) throw  new RepresentacaoInvalidaDoTipo("FormatedString fsrt não representa um : " + Instalacao.class.getSimpleName() );
        
        this.nomeArtistico = fstr.getAtributo("NomeArtistico",className);
        this.nomeArtisticoPai = fstr.getAtributo("NomeArtisticoPai",className);
        this.nomeArtisticoMae = fstr.getAtributo("NomeArtisticoMae",className);
        this.genoma = new Genoma(  new FormatedString(fstr.getAtributo("Genoma",className)) );
        
        try{
            this.id = Integer.parseInt(fstr.getAtributo("Id",className));
            this.idade = Integer.parseInt(fstr.getAtributo("Idade",className));
            this.atratividadeBase = Integer.parseInt(fstr.getAtributo("AtratividadeBase",className));
            this.doente = Boolean.parseBoolean(fstr.getAtributo("Doente",className));
            this.tratado = Boolean.parseBoolean(fstr.getAtributo("Tratado",className));
            this.ultimaTratacao = Integer.parseInt(fstr.getAtributo("UltimaTratacao",className));
        }catch(NumberFormatException e){
            throw new RepresentacaoInvalidaDoTipo("numero mal formatado");
        }
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
    
    /**
    * Devolve a atratividade do animal (atratividade base + valor do gene).
    */
    public int getAtratividade() {
        return this.atratividadeBase + this.genoma.getGeneAtratividade().getAtratividade() ;
    }
    
    /**
    * Devolve a idade em dias.
    */
    public int getIdade() {
        return idade;
    }
    
    /**
    * Devolve a idade em anos.
    */
    public int getIdadeAnos() {
        return idade/365;
    }
    
    /**
     * Devolve à quantos dias foi tratado.
     */
    public int getUltimaTratacao(){
        return this.ultimaTratacao;
    }
    
    /**
     * Reseta a o tratado para "ficar com fome"
     */
    public void ressetTratado() {
        this.tratado = false;
    }
    
    /**
     * Reseta a ultima tratacao
     */
    public void resetUltimaTratacao() {
        this.ultimaTratacao = 0;
        this.tratado = true;
    }
    
    /**
     * Retorna se o animal esta doente
     */
    public boolean estaDoente(){
        return this.doente;
    }
    
    /**
     * Retorna se o animal esta tratado "sem fome"
     */
    public boolean estaTratado(){
        return this.tratado;
    }
    
    /**
     * aumenta o numero de dias na idade.
     */
    public void envelhecer(){
        this.idade++;
    }
    
    /**
    *   Determina se o animal morre com base no tempo que viveu , na longitividade e no se esta doente ou não. Se abate o anima morre e tipo de morte é abate.
    */
    public TipoMorte morre(boolean abate) {       
        if (abate) 
            return TipoMorte.ABATE;
        else 
            return morreProb();  
    }
    
    /**
    *   Determina se o animal foge com base no efeito jumanji .
    */
    public Boolean foge(Instalacao instalacao,Boolean jumanji) {
        if (jumanji ) 
            return Gerador.gerarProbabilidade() <= 50;
        else
            return this.foge(instalacao);
    }
    
    private Boolean foge(Instalacao instalacao) {
        return instalacao.precisaManutencao() && Gerador.gerarProbabilidade() < instalacao.getUltimaManutencao()*10 ; 
    }
    
    /**
    *   Determina se o animal morre com base no tempo que viveu , na longitividade e no se esta doente ou não.
    */
    public TipoMorte morre() {
        return morreProb(); 
    }
    
    /**
    *   Determina se o fica doente com base no tempo que viveu , na longitividade e na instalacao.
    */
    public boolean ficaDoente(Instalacao instalacao) {
        
        double chance = Math.pow( ( (double)(((10 + this.genoma.getGeneLogitividade().getAnos()) / this.genoma.getGeneLogitividade().getAnos()) - 1) / 2.5 ) + 1, this.getIdadeAnos() );
        if (instalacao.estaPrecaria())
            chance += 20;
        if (!instalacao.getAmbiente().equals(this.genoma.getAmbiete()))
            chance += 20;
        
        this.doente = Gerador.gerarProbabilidade() < chance;
        
        return this.doente;
        
    }
    
    /**
     *  Retorna true se corado , com base na esperiencia do veterinario e probabilidade minima 25%.
     */
    public boolean ficaCorado(Veterinario veterinario) {
        
        double chance = (veterinario.getExperiencia()/100) + 25;
        if (Gerador.gerarProbabilidade() <= chance) {
            this.doente = false;  
            return true;
        }else{
            return false;
        }
        
    }
    
    /**
     *  Retorna um animal se este animal repeosuzio com outro da mesma especie e do sexo oposto.
     */
    public Animal reproduzir(Animal animal) {
        
        if (!this.equals(animal) && this.getGenoma().getEspecie().equals(animal.getGenoma().getEspecie() )) {
            
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
    
    /**
     *  Aumenta de forma permanente a atratividade base do animal.
     */
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
        return "Animal: Id:" + this.id + ", Nome Artistico:" + this.nomeArtistico + ", Idade:" + this.idade + ", Atratividade Base:" + this.atratividadeBase +"\n" + this.genoma;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) return true;
        
        if (obj == null) return false;
        
        if (getClass() != obj.getClass()) return false;
        
        final Animal other = (Animal) obj;
        if (this.id != other.id) return false;
        
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
