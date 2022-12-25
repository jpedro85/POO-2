/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.Random;

/**
 *
 * @author Francisco MSI
 */
public final class Gerador {
    
    private Gerador(){}
    private final static Random rand = new Random();
    
    public static int gerarNumero(int min,int max){
        
        return rand.nextInt(min,max);
        
    }
    
    public static Double gerarProbabilidade(){
        
        return rand.nextDouble(100);
    }
    
    public static int gerarOrdinal( int max){
        
        return rand.nextInt(max);
    }
    
}