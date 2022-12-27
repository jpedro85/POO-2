/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public final class MenuAnimal extends Menu {
    
    private final int MAXOPTN=6;
    
    public void mostrarOpcoes(){
        String optn="";
        optn="""
                (1) -> Abater 
                (2) -> Libertar
                (3) -> Adequirir
                (4) -> Vender 
                (5) -> Realocar
                
                (0) -> Voltar Atraz""";
        System.out.println("=================================== Menu Gerir Animais =================================== ");
        this.mostrarOpcoes(optn);
        this.pedirOpcao(this.MAXOPTN);
    }

    @Override
    public void executarOpcao(int optn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
