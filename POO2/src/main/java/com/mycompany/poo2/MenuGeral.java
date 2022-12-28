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


    @Override
    public void mostrarOpcoes() {
        String optn="";
        optn = """
                   (1) -> Simulador 
                   (2) -> Gerir Base De dados 
                   (3) -> Gerir Animais 
                   (4) -> Gerir Instalaçõees
                   (5) -> Gerir Funcionarios
                   (8) -> Gerir Clientes
                   (9) -> Gerir Capital
                  (10) -> Gerir Eventos(JUmanji e ano chinês)
                  (11) -> Histórico
                  (12) -> Caregar Zoo
                  (13) -> Gravar Zoo
                 
                   (0) -> Sair""";
        this.mostrarOpcoes("======================================= Menu Geral =======================================",optn);
        this.pedirOpcao(13);
    }

    @Override
    public void executarOpcao(int optn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excutarOpcaoPedida() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
