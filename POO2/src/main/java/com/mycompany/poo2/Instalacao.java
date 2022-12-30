/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Pedro
 */
public class Instalacao implements Gravavel {
    
    private static int numeroInstalacoes = 0;
    private static int lastId = 0;
    
    private int id;
    private String nome;
    private int capacidade;
    private double custoManutencao;
    private double custoLimpeza;
    private int ultimaManutencao;
    private int entrevaloLimiteManutencao;
    private int sujidade;
    private int condicao;
    private String ambiente;
    private HashMap<String,ArrayList<Animal>> animais;
    
    public Instalacao(String nome, int capacidade,Ambiente ambiente ,double custoManutencao, double custoLimpeza, int entrevaloLimiteManutencao ) {
    
        this.nome = nome;
        this.capacidade = capacidade;
        this.custoLimpeza = custoLimpeza;
        this.custoManutencao = custoManutencao;
        this.ultimaManutencao = 0;
        this.entrevaloLimiteManutencao = entrevaloLimiteManutencao;
        this.sujidade = 0;
        this.condicao = 100;
        this.ambiente = ambiente.toString();
        this.animais = new HashMap<>();
        this.animais.put("Doentes",new ArrayList<>(this.capacidade) );
        this.animais.put("Saudaveis",new ArrayList<>(this.capacidade) );
        this.id = ++lastId;
        
        numeroInstalacoes++;
        
    }
       
    public Instalacao(FormatedString fstr) throws RepresentacaoInvalidaDoTipo,NumberFormatException {
        
        String className = Instalacao.class.getSimpleName();
        if( !fstr.getTipo().equals( className ) ) throw  new RepresentacaoInvalidaDoTipo("FormatedString fsrt não representa um : " + Instalacao.class.getSimpleName() );
        
        this.nome = fstr.getAtributo("Nome",className);
        
        try{
            
            this.id = Integer.parseInt(fstr.getAtributo("Id",className));
            this.capacidade = Integer.parseInt(fstr.getAtributo("Capacidade",className));
            this.custoLimpeza = Double.parseDouble(fstr.getAtributo("CustoLimpeza",className));
            this.custoManutencao = Double.parseDouble(fstr.getAtributo("CustoManutencao",className));
            this.ultimaManutencao = Integer.parseInt(fstr.getAtributo("UltimaManutencao",className));
            this.entrevaloLimiteManutencao = Integer.parseInt(fstr.getAtributo("EntrevaloLimiteManutencao",className));
            this.ambiente = fstr.getAtributo("Ambiente",className);
            if(!Ambiente.estaRepresentado(this.ambiente))
                throw new RepresentacaoInvalidaDoTipo("O valor do campo Ambiente não representa nenhum do tipo Ambiente.");
            this.sujidade = Integer.parseInt(fstr.getAtributo("Sujidade",className));
            this.condicao = Integer.parseInt(fstr.getAtributo("Condicao",className));
            
        }catch(NumberFormatException exp){
            throw new RepresentacaoInvalidaDoTipo("Numero mal formatado na FormatedString: \n" + fstr );
        }

        this.animais = new HashMap<>();
        this.animais.put("Saudaveis", FormatedString.converterFormatedArray(Animal.class, fstr.getAtributo("Saudaveis",className),this.capacidade));
        this.animais.put("Doentes", FormatedString.converterFormatedArray(Animal.class, fstr.getAtributo("Doentes",className),this.capacidade));
        
        if (lastId < this.id) {
            lastId = this.id;
        }
        
        numeroInstalacoes++;
        
    }

    public String getAmbiente() {
        return ambiente;
    }
    
    public static int getNumeroInstalacoes() {
        return numeroInstalacoes;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }
    
    public int getOcupacao() {
      return this.animais.get("Doentes").size() + this.animais.get("Saudaveis").size();
    }
    
    public int getVacancia() {
      return this.capacidade - this.getOcupacao();
    }
    
    public int getUltimaManutencao(){
        return this.ultimaManutencao;
    }

    public int getSujidade() {
        return this.sujidade;
    }

    public int getCondicao() {
        return this.condicao;
    }

    public int getCapacidade() {
        return this.capacidade;
    }

    public ArrayList<Animal> getAnimaisTodos() {
        ArrayList<Animal> anim = new ArrayList<Animal>(this.getOcupacao());
        anim.addAll(this.getAnimaisDoentes());
        anim.addAll(this.getAnimaisSaudaveis());
        return anim;
    }
    
    public ArrayList<Animal> getAnimaisSaudaveis() {
        return this.animais.get("Saudaveis");
    }
   
    public ArrayList<Animal> getAnimaisDoentes() {
        return this.animais.get("Doentes");
    }
    
    public double getCustoLimpeza() {
        return this.custoLimpeza;
    }
    
    public double getCustoManutencao() {
        return this.custoManutencao;
    }
    
    public int getultimaManutencao() {
        return this.ultimaManutencao;
    }

    public boolean setCustoManutencao(double custoManutencao) {
        if (custoManutencao>0) {
            this.custoManutencao = custoManutencao;
            return true;
        }
        return false;
    }

    public int getEntrevaloLimiteManutencao() {
        return this.entrevaloLimiteManutencao;
    }

    public void setEntrevaloLimiteManutencao(int entrevaloLimite) {
        if (entrevaloLimite > 0 ) 
            this.entrevaloLimiteManutencao = entrevaloLimite;  
    }

    public void ocoreuMorte() {
        this.sujidade = 60;
    }

    public void ocoreuFuga() {
        this.condicao = 0;
    }
    
    public boolean estaCheia(){
        return this.capacidade == this.getOcupacao();
    }
    
    public boolean estaPrecaria(){
        return (sujidade>=100);
    }
        
    public boolean precisaManutencao(){
        return (condicao<25) || this.ultimaManutencao >= this.entrevaloLimiteManutencao ;
    }
    
    public boolean precisaLimpeza(){
        return (sujidade>50);
    }
    
    public boolean temAnimaisDoentes(){
        return !animais.get("Doentes").isEmpty();
    }
    
    public void limpar(){
        this.sujidade = 0;
    }
    
    public void reparar(){
        this.condicao = 100;
    }
    
    public void desgaste(){
        condicao--;
        sujidade++;
    }
    
    @Override
    public FormatedString toFormatedString(){
        
        FormatedString fstr = new FormatedString(Instalacao.class.getSimpleName(),10);
        fstr.addAtributo("Nome", this.getNome());
        fstr.addAtributo("Id", this.getId());
        fstr.addAtributo("Capacidade", this.getCapacidade());
        fstr.addAtributo("CustoLimpeza", this.getCustoLimpeza());
        fstr.addAtributo("CustoManutencao", this.getCustoManutencao());
        fstr.addAtributo("UltimaManutencao", this.getUltimaManutencao());
        fstr.addAtributo("EntrevaloLimiteManutencao", this.getEntrevaloLimiteManutencao());
        fstr.addAtributo("Sujidade", this.getSujidade());
        fstr.addAtributo("Condicao", this.getCondicao());
        fstr.addAtributo("Ambiente", this.getAmbiente());
        fstr.addAtributo("Saudaveis", FormatedString.formatArray(this.animais.get("Saudaveis")));
        fstr.addAtributo("Doentes", FormatedString.formatArray(this.animais.get("Doentes")));
        
        return fstr;
    }
    
    @Override
    public String toString(){
        
        String text="";
        text+= "nome: "+nome+" ID: "+id+ " ambinete: "+ this.ambiente +" capapacidade: "+capacidade+" vacancia: "+ getVacancia() +" sujidade: "+sujidade+" condicao: "+condicao+" Custo de manutencao: "+custoManutencao+" Tempo medio manutencao: "+entrevaloLimiteManutencao+"\n\t";
        
        if (this.getOcupacao() != 0) {
            
            text += "Animais:\n";
            for (Animal animal : animais.get("Doentes")) {
                text += animal + "\n";
            }
            for (Animal animal : animais.get("Saudaveis")) {
                text+= animal+"\n";
            }
            
        }else
            text += "Animais:Não Tem";
        
        return text;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        final Instalacao i = (Instalacao) obj;

        return (id == i.getId()) && (nome.equals(i.getNome()));
    }
}