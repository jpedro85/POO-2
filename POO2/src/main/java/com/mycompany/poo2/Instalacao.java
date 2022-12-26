/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    private int ultimaManutencao;
    private int entrevaloLimiteManutencao;
    private int sujidade;
    private int condicao;
    private HashMap<String,ArrayList<Animal>> animais;
    
    public Instalacao(String nome, int capacidade, double custoManutencao, int entrevaloLimiteManutencao ) {
    
        this.nome = nome;
        this.capacidade = capacidade;
        this.custoManutencao = custoManutencao;
        this.ultimaManutencao = 0;
        this.entrevaloLimiteManutencao = entrevaloLimiteManutencao;
        this.sujidade = 0;
        this.condicao = 100;
        this.animais = new HashMap<>();
        this.id = ++lastId;
        
        numeroInstalacoes++;
        
    }
    
    public Instalacao(String nome, int capacidade, int ultimaManutencao , int sujidade, int condicao ,double custoManutencao, int entrevaloLimiteManutencao , HashMap<String,ArrayList<Animal>> animais) {
    
        this.nome = nome;
        this.capacidade = capacidade;
        this.custoManutencao = custoManutencao;
        this.ultimaManutencao = ultimaManutencao;
        this.entrevaloLimiteManutencao = entrevaloLimiteManutencao;
        this.sujidade = sujidade;
        this.condicao = condicao;
        this.animais = animais;
        this.id = ++lastId;
        
        numeroInstalacoes++;
        
    }
    
    public Instalacao(FormatedString fstr) throws RepresentacaoInvalidaDoTipo,NumberFormatException {
        
        String className = Instalacao.class.getSimpleName();
        if( !fstr.getTipo().equals( className ) ) throw  new RepresentacaoInvalidaDoTipo("FormatedString fsrt não representa um : " + Instalacao.class.getSimpleName() );
        
        this.nome = fstr.getAtributo("Nome",className);
        this.id = Integer.parseInt(fstr.getAtributo("Id",className));
        this.capacidade = Integer.parseInt(fstr.getAtributo("Capacidade",className));
        this.custoManutencao = Double.parseDouble(fstr.getAtributo("CustoManutencao",className));
        this.ultimaManutencao = Integer.parseInt(fstr.getAtributo("UltimaManutencao",className));
        this.entrevaloLimiteManutencao = Integer.parseInt(fstr.getAtributo("EntrevaloLimiteManutencao",className));
        this.sujidade = Integer.parseInt(fstr.getAtributo("Sujidade",className));
        this.condicao = Integer.parseInt(fstr.getAtributo("Condicao",className));

        this.animais = new HashMap<>();
        this.animais.put("Saudaveis", FormatedString.converterFormatedArray(Animal.class, fstr.getAtributo("Saudaveis",className),this.capacidade));
        this.animais.put("Doentes", FormatedString.converterFormatedArray(Animal.class, fstr.getAtributo("Doentes",className),this.capacidade));
        
        if (lastId < this.id) {
            lastId = this.id;
        }
        
        numeroInstalacoes++;
        
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

    public Map<String, ArrayList<Animal>> getAnimais() {
        return this.animais;
    }

    public double getCustoManutencao() {
        return this.custoManutencao;
    }
    
    public int getultimaManutencao() {
        return this.ultimaManutencao;
    }

    public void setCustoManutencao(double custoManutencao) {
        this.custoManutencao = custoManutencao;
    }

    public int getEntrevaloLimiteManutencao() {
        return this.entrevaloLimiteManutencao;
    }

    public void setEntrevaloLimiteManutencao(int entrevaloLimite) {
        if (entrevaloLimite > 0 ) 
            this.entrevaloLimiteManutencao = entrevaloLimite;  
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
        fstr.addAtributo("CustoManutencao", this.getCustoManutencao());
        fstr.addAtributo("UltimaManutencao", this.getUltimaManutencao());
        fstr.addAtributo("EntrevaloLimiteManutencao", this.getEntrevaloLimiteManutencao());
        fstr.addAtributo("Sujidade", this.getSujidade());
        fstr.addAtributo("Condicao", this.getCondicao());
        fstr.addAtributo("Saudaveis", FormatedString.formatArray(this.animais.get("Saudaveis")));
        fstr.addAtributo("Doentes", FormatedString.formatArray(this.animais.get("Doentes")));
        
        return fstr;
    }
    
    @Override
    public String toString(){
        
        String text="";
        text+= "nome: "+nome+" ID: "+id+" capapacidade: "+capacidade+" vacancia: "+ getVacancia() +" sujidade: "+sujidade+" condicao: "+condicao+" Custo de manutencao: "+custoManutencao+" Tempo medio manutencao: "+entrevaloLimiteManutencao+"\n Animais:\n";
        for (Animal animal:animais.get("Doentes")) {
            text+= animal+"\n";
        }
        for (Animal animal:animais.get("Saudaveis")) {
            text+= animal+"\n";
        }
        return text;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        final Instalacao i = (Instalacao) obj;

        return (nome.equals(i.getNome())) && (id == i.getId());
    }
}