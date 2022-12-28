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
    
    /**
     * devolve true se str é igual a um TipoMorte.ToString.
     * @param str
     * @return boolean
     */
    public static boolean estaRepresentado(String str){
        
        for (TipoMorte tipo :TipoMorte.values()) {
            
            if( str.equals(tipo.toString()) )
                return true;
        }
        
        return false;
    }
    
}
