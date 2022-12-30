/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 *  Main Class
 */
public class POO2 {


    public static void main(String[] args) {
                
        Carregador.carregarFicheiros();
        
        MenuGeral menuMenuGeral = new MenuGeral();
        menuMenuGeral.mostrarOpcoes();
        menuMenuGeral.executarOpcaoPedida();
             
    }
    
}
