/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Francisco MSI
 */
public enum Dieta {
    
    VEGETARIANO("vegetariano"),CARNIVORO("carnivoro"),OMNIVORO("omnivoro");
    
    private String nome;
    
    private Dieta(String nome){
        this.nome = nome;
    }
    
    @Override
    public String toString(){
        return nome;
    }
    
    public static boolean estaRepresentado(String str){
        
        for (Dieta dieta :Dieta.values()) {
            
            if( str.equals(dieta.toString()) )
                return true;
        }
        
        return false;
    }
}
