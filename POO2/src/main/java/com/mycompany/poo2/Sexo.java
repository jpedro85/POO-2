/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
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
}
