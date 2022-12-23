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
    private Genoma genoma;
    private int idade;
    private int atratividadeBase;

    public Animal(String nomeArtistico, Genoma genoma, int atratividade) {
        this.nomeArtistico = nomeArtistico;
        this.genoma = genoma;
        this.id = lastId;
        this.idade = 0;
        this.atratividadeBase = atratividade;
        lastId++;
    }

    public static int getLastId() {
        return lastId;
    }

    public int getId() {
        return id;
    }

    public String getNomeArtistico() {
        return nomeArtistico;
    }

    public Genoma getGenoma() {
        return genoma;
    }

    public int getAtratividadeBase() {
        return atratividadeBase;
    }

    public int getIdade() {
        return idade;
    }

    public int comer() {
        return 1;
    }

    public boolean estaDoente(Instalacao instalacao) {
        return true;
    }

    public Animal reproduzir() {
        return null;
    }

    public void anoChinesEffect() {
        this.atratividadeBase++;
    }

    public int atratividade() {
        return this.atratividadeBase + this.getGenoma().getAtratividade();
    }

    @Override
    public FormatedString toFormatedString() {
        
        FormatedString fstr = new FormatedString(getClass().getSimpleName(), 8);
        fstr.addAtributo("Id", this.getId());
        fstr.addAtributo("NomeArtistico", this.getNomeArtistico());
        fstr.addAtributo("Idade", this.getIdade());
        fstr.addAtributo("AtratividadeBase", this.getAtratividadeBase());
        //falta Genoma
        
        return fstr;
    }

    @Override
    public String toString() {
        return "Animal tem:\n\t" + "Id:" + this.id + ", Nome Artistico:" + this.nomeArtistico + ", Genoma:" + this.genoma + ", Idade:" + this.idade + ", Atratividade Base:" + this.atratividadeBase;
    }

    /**
     * Devolve true se o Animal for igual em termos de id e genoma
     *
     * @param obj
     * @return
     */
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

}
