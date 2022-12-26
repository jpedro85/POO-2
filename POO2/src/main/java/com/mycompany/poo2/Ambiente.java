/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Francisco MSI
 */
public enum Ambiente {
    
    DESERTICO("deserto"),ROCHOSO("rochoso"),SAVANA("savana"),SELVA("selva"),FLORESTA("floresta"),TUNDRA("tundra"),TAIGA("taiga");
    
    private String nome;
    
    private Ambiente(String nome){
        this.nome = nome;
    }
    
    @Override
    public String toString(){
        return nome;
    }
    
    public static boolean estaRepresentado(String str){
        
        for (Ambiente amb :Ambiente.values()) {
            
            if( str.equals(amb.toString()) )
                return true;
        }

        return false;
    }
  
} 
