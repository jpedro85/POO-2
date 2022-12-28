/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.poo2;

/**
 *  Devolve as pussibilidades para os anos chines.
 */
public enum AnoChines {
    RATO("rato"),
    BOI("boi"),
    TIGRE("tigre"),
    COELHO("coelho"),
    DRAGAO("dragao"),
    SERPENTE("serpente"),
    CAVALO("cavalo"),
    CABRA("cabra"),
    MACACO("macaoo"),
    GALO("galo"),
    CAO("cao"),
    PORCO("porco");

    private String nome;

    private AnoChines(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    /**
     *  Devolve True se str representa um AnoChines (se é igual ao toString de um AnoChines).
     */
    public static boolean estaRepresentado(String str){
        
        for (AnoChines chines : AnoChines.values()) {
            
            if( str.equals(chines.toString()) )
                return true;
        }
        return false;
    }
    
}
