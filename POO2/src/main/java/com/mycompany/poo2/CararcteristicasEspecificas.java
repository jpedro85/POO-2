/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Francisco MSI
 */
public enum CararcteristicasEspecificas {
    
    OLHOS("olhos"),
    NARIS("naris"),
    MANDIBULA("mandibula"),
    PATAS("patas"),
    PELE("pele"),
    PELAGEM("pelagem"),
    ORELHAS("orelhas");
    
    private String name;
    
    CararcteristicasEspecificas(String nome){
        name = nome;
    }
   
    @Override
    public String toString(){
        return name;
    }
    
}
