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
public final class Zoo {
    private ArrayList<Animal>obituario;
    private ArrayList<Animal>semiLivres;
    private ArrayList<Instalacao>instalacoes;
    private ArrayList<Empregado>empregados;
    private ArrayList<Cliente>clientes;

    public ArrayList<Animal> getAllObitos() {
        return obituario;
    }
    
    public void addObito(ArrayList<Animal> obituario) {
        this.obituario = obituario;
    }

    public ArrayList<Animal> getAllSemiLivres(){
        return semiLivres;
    }
    
    public Animal getSemiLivre(int i){
        if(i>0&& i<semiLivres.size()){
            return semiLivres.get(i);
        }
        return null;
    }
    
    public Animal getSemiLivreComId(int i){
        for(Animal a:semiLivres){
            if(a.getId()==i){
                return a;
            }
        }
        return null;
    }
    
    public void removeSemiLivre(int i){
        semiLivres.remove(i);
    }
    public void removeSemiLivreComId(int i){
        for(Animal a:semiLivres){
            if(a.getId()==i){
                semiLivres.remove(a);
            }
        }
    }
    
    
}
