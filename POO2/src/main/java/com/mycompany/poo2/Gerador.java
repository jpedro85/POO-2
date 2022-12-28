/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Francisco MSI
 */
public final class Gerador {
    
    private static ArrayList<String> nomes;
    private static ArrayList<String> empresas;
    
    private Gerador(){}
    private final static Random rand = new Random();
    
    public static int gerarNumero(int min,int max){
        
        return rand.nextInt(min,max);
        
    }
    
    public static double gerarNumero(double min,double max){
        
        return rand.nextDouble(min,max);
        
    }
    
    public static Double gerarProbabilidade(){
        
        return rand.nextDouble(100);
    }
    
    public static int gerarOrdinal( int max){
        
        return rand.nextInt(max);
    }
    
    public static int gerarNIF() {
        
        return rand.nextInt(10000000,99999999);
        
    }

    public static ArrayList<String> getNomes() {
        return nomes;
    }

    public static ArrayList<String> getEmpresas() {
        return empresas;
    }

    public static void setNomes(ArrayList<String> nomes) {
        Gerador.nomes = nomes;
    }

    public static void setEmpresas(ArrayList<String> empresas) {
        Gerador.empresas = empresas;
    }
    
    
    
}