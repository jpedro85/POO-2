/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public final class MenuInstalacao extends Menu {

    private final int MAXOPTN = 4;

    public void mostrarOpcoes() {
        String optn = "";
        optn = """
                  (1) -> Destruir 
                  (2) -> Construir
                  (3) -> Ver instala\u00e7\u00e3o
                  
                  (0) -> Voltar Atraz""";
        this.mostrarOpcoes("================================= Menu Gerir Instalações =================================",optn);
        this.pedirOpcao(this.MAXOPTN);
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
