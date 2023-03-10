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
public final class Zoo {
    
    private static ArrayList<Animal>nascimentos;
    private static ArrayList<Animal>obituario;
    private static HashMap<Animal,Instalacao>semiLivres;
    private static ArrayList<Instalacao>instalacoes;
    private static ArrayList<Empregado>empregados;
    private static ArrayList<Cliente>clientes;
    private static double entrada;

    public static double getEntrada() {
        return entrada;
    }

    public static void setEntrada(double entrada) {
        Zoo.entrada = entrada;
    }

    public static ArrayList<Animal> getAllNascimentos(){
        return nascimentos;
    }
    
    public static void addNascimento(Animal animal){
         nascimentos.add(animal);
    }
    
 /*   public static void realocar(Animal animal,Instalacao instalacao){
         
        int indice = nascimentos.indexOf(animal);
        
        if (nascimentos.indexOf(animal) > 0) {
            
        }else
    }*/
    
    
    public static ArrayList<Animal> getAllObitos() {
        return obituario;
    }
    
    public static void addObito(ArrayList<Animal> obituario) {
        Zoo.obituario = obituario;
    }

    public static HashMap<Animal,Instalacao> getAllSemiLivres(){
        return semiLivres;
    }
            
    public static ArrayList<Instalacao> getAllInstalacoes(){
        return instalacoes;
    }
    
    public static Instalacao getInstalacao(int i){
        if(i>0&& i<instalacoes.size()){
            return instalacoes.get(i);
        }
        return null;
    }
    
    public static Instalacao getInstalacaoComId(int i){
        for(Instalacao a:instalacoes){
            if(a.getId()==i){
                return a;
            }
        }
        return null;
    }
    
    public static void removeInstalacao(int i){
        instalacoes.remove(i);
    }
    
    public static void removeInstalacaoComId(int i){
        for(Instalacao a:instalacoes){
            if(a.getId()==i){
                instalacoes.remove(a);
            }
        }
    }
    
    public static ArrayList<Empregado> getAllEmpregados(){
        return empregados;
    }
    
    public static Empregado getEmpregado(int i){
        if(i>0&& i<empregados.size()){
            return empregados.get(i);
        }
        return null;
    }
    
    public static void addEmpregado(Empregado empregado){
        empregados.add(empregado);
    }
    
    public static void removeEmpregado(int i){
        empregados.remove(i);
    }
    
    public static ArrayList<Cliente> getAllClientes(){
        return clientes;
    }
    
    public static Cliente getCliente(int i){
        if(i>0&& i<clientes.size()){
            return clientes.get(i);
        }
        return null;
    }
    
    public static void addCliente(Cliente cliente){
        clientes.add(cliente);
    }
    
    public static void removeCliente(int i){
        clientes.remove(i);
    }
    
    public static void reset(){
        obituario.clear();
        semiLivres.clear();
        instalacoes.clear();
        empregados.clear();
        clientes.clear();
    }
}
