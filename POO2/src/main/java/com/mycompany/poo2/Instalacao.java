/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Pedro
 */
public class Instalacao {
    private int numeroInstalacoes;
    private static int lastId;
    private String nome;
    private int capacidade;
    private int vacancia;
    private double custoManutencao;
    private int tempoMedioManutencao;
    private int sujidade;
    private int condicao;
    private Map<String,ArrayList<Animal>> animais;

    public Instalacao(int numeroInstalacoes, String nome, int capacidade, int vacancia, double custoManutencao, int tempoMedioManutencao, int sujidade, int condicao, Map<String, ArrayList<Animal>> animais) {
        this.numeroInstalacoes = numeroInstalacoes;
        this.nome = nome;
        this.capacidade = capacidade;
        this.vacancia = vacancia;
        this.custoManutencao = custoManutencao;
        this.tempoMedioManutencao = tempoMedioManutencao;
        this.sujidade = sujidade;
        this.condicao = condicao;
        this.animais = animais;
    }

    public static int getLastId() {
        return lastId;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public Map<String, ArrayList<Animal>> getAnimais() {
        return animais;
    }

    public double getCustoManutencao() {
        return custoManutencao;
    }

    public void setCustoManutencao(double custoManutencao) {
        this.custoManutencao = custoManutencao;
    }

    public int getTempoMedioManutencao() {
        return tempoMedioManutencao;
    }

    public void setTempoMedioManutencao(int tempoMedioManutencao) {
        this.tempoMedioManutencao = tempoMedioManutencao;
    }
    
    public boolean isPrecaria(){
        if(sujidade==0) return true;
        else return false;
    }
    
    public boolean precisaManutencao(){
        if(condicao<25) return true;
        else return false;
    }
    
    public boolean precisaLimpeza(){
        if(sujidade>50)return true;
        else return false;
    }
    
    public boolean temAnimaisDoentes(){
        if(animais.containsKey("doente"))return true;
        else return false;
    }
    
    public void desgaste(){
        condicao++;
        sujidade--;
    }
    
    
}