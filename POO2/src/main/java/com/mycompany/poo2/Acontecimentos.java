/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Francisco MSI
 */
public enum Acontecimentos {
 
    OBITO("Óbito"),
    NASCIMENTO("Nascimento"),
    CONSTUCAO("Construção"),
    DESTRUICAO("Destruição"),
    VENDA("Venda"),
    COMPRA("Compra"),
    DESPESA("Despesa"),
    LUCRO("Lucro"),
    INFO("Informação"),
    FUGAANIMAL("Um animal fugio"),
    ENCONTRADO("Um animal foi encontrado");
    
    private String name;
    
    private Acontecimentos(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
