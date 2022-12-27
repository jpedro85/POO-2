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
    
    public ArrayList<Instalacao> getAllInstalacoes(){
        return instalacoes;
    }
    
    public Instalacao getInstalacao(int i){
        if(i>0&& i<instalacoes.size()){
            return instalacoes.get(i);
        }
        return null;
    }
    
    public Instalacao getInstalacaoComId(int i){
        for(Instalacao a:instalacoes){
            if(a.getId()==i){
                return a;
            }
        }
        return null;
    }
    
    public void removeInstalacao(int i){
        instalacoes.remove(i);
    }
    public void removeInstalacaoComId(int i){
        for(Instalacao a:instalacoes){
            if(a.getId()==i){
                instalacoes.remove(a);
            }
        }
    }
    
    public ArrayList<Empregado> getAllEmpregados(){
        return empregados;
    }
    
    public Empregado getEmpregado(int i){
        if(i>0&& i<empregados.size()){
            return empregados.get(i);
        }
        return null;
    }
    public void addEmpregado(Empregado empregado){
        empregados.add(empregado);
    }
    public void removeEmpregado(int i){
        empregados.remove(i);
    }
    
    public ArrayList<Cliente> getAllClientes(){
        return clientes;
    }
    
    public Cliente getCliente(int i){
        if(i>0&& i<clientes.size()){
            return clientes.get(i);
        }
        return null;
    }
    public void addCliente(Cliente cliente){
        clientes.add(cliente);
    }
    public void removeCliente(int i){
        clientes.remove(i);
    }
    
    public void reset(){
        this.obituario.clear();
        this.semiLivres.clear();
        this.instalacoes.clear();
        this.empregados.clear();
        this.clientes.clear();
    }
}
