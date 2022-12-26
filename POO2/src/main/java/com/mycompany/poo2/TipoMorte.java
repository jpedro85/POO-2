/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Francisco MSI
 */
public enum TipoMorte {
    
    DOENTE("doença"),FOME("fome"),IDOSO("velhice"),ABATE("abate");
    
    private String razao;
    
    private TipoMorte(String str){
        this.razao = str;
    }

    @Override
    public String toString() {
        return "TipoMorte(" + "razao:" + razao + ')';
    }
    
}
