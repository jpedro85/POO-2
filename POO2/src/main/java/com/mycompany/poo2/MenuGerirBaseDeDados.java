/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public final class MenuGerirBaseDeDados extends Menu {
    
    private final int MAXOPTN=19;
    
    public void mostrarOpcoes(){
        String optn="";
        optn="""
                        (1) -> Ver Todas As Especie
                        (2) -> Ver Todos Os Genes De Especie
                        (3) -> Ver Todos Os Genes Especificos
                        (4) -> Ver Todos Os Genes De Dieta
                        (5) -> Ver Todos Os Genes De Sexo
                        (6) -> Ver Todos Os Genes De Reprodução
                        (7) -> Ver Todos Os Genes De Longitividade
                        (8) -> Ver Todos Os Genes De Ambiente
                        (9) -> Ver Todos Os Genes De Atratividade
                        (10) -> Inserir Nova Especie
                        (11) -> Inserir Novo Genes De Especie
                        (12) -> Inserir Novo Genes Especificos
                        (13) -> Inserir Novo Genes De Dieta
                        (14) -> Inserir Novo Genes De Sexo
                        (15) -> Inserir Novo Genes De Reprodução
                        (16) -> Inserir Novo Genes De Longitividade
                        (17) -> Inserir Novo Genes De Ambiente
                        (18) -> Inserir Novo Genes De Atratividade
                    
                        (0) -> Voltar Atraz
                    """;
        this.mostrarOpcoes("================================ Menu Gerir Base De Dados ================================",optn);
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
    
    private void inserirNovaEspecie(){
        String nome=this.pedirNome();
        GeneEspecie gene=this.pedirGeneEspecie();
        ArrayList<GeneEspecie> genes=new ArrayList<GeneEspecie>();
        genes.add(gene);
        boolean bool;
        while(bool=this.pedirBooleano("Pretende introduzir mais genes?")==true){
            genes.add(this.pedirGeneEspecie());
        }
        Especie e=new Especie(nome,genes);
    }
    
}
