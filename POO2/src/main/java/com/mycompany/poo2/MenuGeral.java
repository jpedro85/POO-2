/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public final class MenuGeral extends Menu {


    public void mostrarOpcoes() {
        String optn="";
        optn = """
                   (1) -> Simulador 
                   (2) -> Gerir Base De dados 
                   (3) -> Gerir Animais 
                   (4) -> Gerir Instala\u00e7\u00f5es
                   (5) -> Gerir Funcionarios
                   (8) -> Gerir Clientes
                   (9) -> Gerir Capital
                  (10) -> Gerir Eventos(JUmanji e ano chin\u00eas)
                  (11) -> Hist\u00f3rico
                  (12) -> Caregar Zoo
                  (13) -> Gravar Zoo
                 
                   (0) -> Sair""";
        System.out.println("======================================= Menu Geral ======================================= ");
        this.mostrarOpcoes(optn);
        this.pedirOpcao(13);
    }

    @Override
    public void executarOpcao(int optn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
