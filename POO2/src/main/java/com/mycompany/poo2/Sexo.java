/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.poo2;

/**
 *  Sexos disponiveis.
 */
public enum Sexo {
    MACHO("macho"),
    FEMEA("femea");
    
    private String nome;
    
    private Sexo(String nome){
        this.nome = nome;
    }
    
    @Override
    public String toString(){
        return nome;
    }
    
    /**
     * devolve true se str é igual a um sexo.ToString.
     * @param str
     * @return boolean
     */
    public static boolean estaRepresentado(String str){
        
        for (Sexo sex :Sexo.values()) {
            
            if( str.equals(sex.toString()) )
                return true;
        }
        
        return false;
    }

}
