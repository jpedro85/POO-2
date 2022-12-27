/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public class MenuCapital extends Menu {

    private static final int MAXOPTN = 6;

    @Override
    public void mostrarOpcoes() {
        String optn = "";
        optn = """
                  (1) -> Ver Balanço
                  (2) -> Ver Despesas 
                  (3) -> Ver Lucros
                  (2) -> Calcular Balanço (Periodo Comtabilistico)
                  (3) -> Mudar salarios
                  (4) -> Vender 
                  (5) -> Realocar
                  
                  (0) -> Voltar Atraz""";
        this.mostrarOpcoes("=================================== Menu Gerir Capital =================================== ", optn);
        this.pedirOpcao(MAXOPTN);
    }

    @Override
    public void excutarOpcaoPedida() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void executarOpcao(int optn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
