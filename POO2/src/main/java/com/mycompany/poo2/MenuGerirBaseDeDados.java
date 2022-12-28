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

    public MenuGerirBaseDeDados(Menu menu) {
        super(menu);
    }
    
    
    
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
        String nome=this.pedirNome("Introduza uma nova Especie");
        GeneEspecie gene=this.pedirGeneEspecie();
        ArrayList<GeneEspecie> genes=new ArrayList<GeneEspecie>();
        genes.add(gene);
        boolean bool;
        while(bool=this.pedirBooleano("Pretende introduzir mais genes?")==true){
            genes.add(this.pedirGeneEspecie());
        }
        Especie e=new Especie(nome,genes);
    }
    
    private void inserirNovoGenesDeEspecie(){
        String nome=this.pedirNome("Introduza uma nova GeneEspecie");
        String valor=this.pedirValorStringGeneEspecie();
        GeneEspecie e=new GeneEspecie(valor, nome);
    }
    
    private void inserirNovoGenesEspecificos(){
        String nome=this.pedirNome("Introduza um novo GeneEspecifico");
        String valor=this.pedirValorStringGeneEspecifico();
        CararcteristicasEspecificas tipo=pedirTipoCaracteristica();
        GeneEspecifico e=new GeneEspecifico(valor, nome, tipo);
    }
    
    private void inserirNovoGenesDeSexo(){
        Sexo sexo=pedirSexo();
        String nome=sexo.toString();
        GeneSexo s=new GeneSexo(sexo, nome);
    }
    private void inserirNovoGeneDeDieta(){
        Dieta d=pedirDieta();
        String nome=this.pedirNome("Introduza uma nova Alimentacao");
        GeneDieta dieta=new GeneDieta(d, nome);
    }
    private void inserirNovoGeneDeReproducao(){
        String nome=this.pedirNome("Introduza uma novo GeneReproducao");
        int i=this.pedirNumero("Introduza um Valor entre 0 e 100 para o Apetite de Reprodução", 0, 100);
        GeneRepoducao r=new GeneRepoducao(i, nome);
    }
    
    private void inserirNovoGeneDeLongitividade(){
        String nome=this.pedirNome("Introduza uma novo GeneLongitividade");
        int i=this.pedirNumero("Introduza um Valor entre 1 e 10000 para os anos", 0, 10000);
        GeneLongividade l=new GeneLongividade(i, nome);
    }
    
    private void inserirNovoGeneDeAmbiente(){
        String nome=this.pedirNome("Introduza uma novo GeneAmbiente");
        Ambiente a=pedirAmbiente();
        GeneAmbiente ambi=new GeneAmbiente(a, nome);
    }
    
    private void inserirNovoGeneDeAtratividade(){
        String nome=this.pedirNome("Introduza uma novo GeneAtratividade");
        int i=this.pedirNumero("Introduza um Valor entre 1 e 1000 para a Atratividade Base", 0, 1000);
        GeneAtratividade a=new GeneAtratividade(i, nome);
    }
}
