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

    private final int MAXOPTN = 19;
    
    public MenuGerirBaseDeDados(Menu menu) {
        super(menu);
    }

    public void mostrarOpcoes() {
        String optn = "";
        optn = """
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
        this.mostrarOpcoes("================================ Menu Gerir Base De Dados ================================", optn);
    }
    
    @Override
    public void executarOpcaoPedida() {
        this.mostrarOpcoes();
        this.executarOpcao(this.pedirOpcao(MAXOPTN));
    }

    @Override
    public void executarOpcao(int optn) {
        switch (optn) {
            case 0 ->
                this.voltarAtraz();
            case 1 -> {
                if (!Especie.getAllInstances().isEmpty()) {
                    for (Especie especie : Especie.getAllInstances()) {
                        System.out.println(especie);
                    }
                } else {
                    System.out.println("Não possui especies ainda!");
                }
                this.pedirContinuar();
            }
            case 2 -> {
                if (!GeneEspecie.getAllInstances().isEmpty()) {
                    for (GeneEspecie allInstance : GeneEspecie.getAllInstances()) {
                        System.out.println(allInstance);
                    }
                } else {
                    System.out.println("Não possui Genes de Especies ainda!");
                }
                this.pedirContinuar();
            }
            case 3 -> {
                if (!GeneEspecifico.getAllInstances().isEmpty()) {
                    for (GeneEspecifico allInstance : GeneEspecifico.getAllInstances()) {
                        System.out.println(allInstance);
                    }
                } else {
                    System.out.println("Não possui Genes Especificos ainda!");
                }
                this.pedirContinuar();
            }
            case 4 -> {
                if (!GeneDieta.getAllInstances().isEmpty()) {
                    for (GeneDieta allInstance : GeneDieta.getAllInstances()) {
                        System.out.println(allInstance);
                    }
                } else {
                    System.out.println("Não possui Genes de Dieta ainda!");
                }
                this.pedirContinuar();
            }
            case 5 -> {
                if (!GeneSexo.getAllInstances().isEmpty()) {
                    for (GeneSexo allInstance : GeneSexo.getAllInstances()) {
                        System.out.println(allInstance);
                    }
                } else {
                    System.out.println("Não possui Genes de Sexo ainda!");
                }
                this.pedirContinuar();
            }
            case 6 -> {
                if (!GeneRepoducao.getAllInstances().isEmpty()) {
                    for (GeneRepoducao allInstance : GeneRepoducao.getAllInstances()) {
                        System.out.println(allInstance);
                    }
                } else {
                    System.out.println("Não possui Genes de Reprodução ainda!");
                }
                this.pedirContinuar();
            }
            case 7 -> {
                if (!GeneLongividade.getAllInstances().isEmpty()) {
                    for (GeneLongividade allInstance : GeneLongividade.getAllInstances()) {
                        System.out.println(allInstance);
                    }
                } else {
                    System.out.println("Não possui Genes de Longividade ainda!");
                }
                this.pedirContinuar();
            }
            case 8 -> {
                if (!GeneAmbiente.getAllInstances().isEmpty()) {
                    for (GeneAmbiente allInstance : GeneAmbiente.getAllInstances()) {
                        System.out.println(allInstance);
                    }
                } else {
                    System.out.println("Não possui Genes de Ambiente ainda!");
                }
                this.pedirContinuar();
            }
            case 9 -> {
                if (!GeneAtratividade.getAllInstances().isEmpty()) {
                    for (GeneAtratividade allInstance : GeneAtratividade.getAllInstances()) {
                        System.out.println(allInstance);
                    }
                }else{
                    System.out.println("Não possui Genes de Atratividade ainda!");
                }
                this.pedirContinuar();
            }
            case 10 -> {
                this.inserirNovaEspecie();
                this.pedirContinuar();
            }
            case 11 -> {
                this.inserirNovoGenesDeEspecie();
                this.pedirContinuar();
            }
            case 12 -> {
                this.inserirNovoGenesEspecificos();
                this.pedirContinuar();
            }
            case 13 -> {
                this.inserirNovoGeneDeDieta();
                this.pedirContinuar();
            }
            case 14 -> {
                this.inserirNovoGenesDeSexo();
                this.pedirContinuar();
            }
            case 15 -> {
                this.inserirNovoGeneDeReproducao();
                this.pedirContinuar();
            }
            case 16 -> {
                this.inserirNovoGeneDeLongitividade();
                this.pedirContinuar();
            }
            case 17 -> {
                this.inserirNovoGeneDeAmbiente();
                this.pedirContinuar();
            }
            case 18 -> {
                this.inserirNovoGeneDeAtratividade();
                this.pedirContinuar();
            }
        }
    }
    
     private void inserirNovaEspecie(){
        String nome=this.pedirNome("Introduza um nome para a Especie.");
        GeneEspecie gene=this.pedirGeneEspecie();
        if ( gene == null) {
            System.out.println("Não existem genes de especie carregados !");
        }else
        {
            ArrayList<GeneEspecie> genes = new ArrayList<GeneEspecie>();
            genes.add(gene);
            
            Boolean jaAdicionado;
            while(this.pedirBooleano("Pretende introduzir mais genes?")==true){
                
                gene = this.pedirGeneEspecie();
                jaAdicionado = false;
                for (Gene g : genes) {
                    if (g.equals(gene)) {
                        System.out.println("O gene: " + gene + " já foi adicionado !");
                        jaAdicionado = true;
                    }
                }
                
                if (!jaAdicionado) 
                    genes.add(gene);
                else if(GeneEspecie.getAllInstances().size() == 1 && jaAdicionado){
                    System.out.println("Jáforam adicionados todos os genes existentes.");
                    break;
                }
                    
                    
            }
            
            Especie e = new Especie(nome,genes);
            Especie.addInstanceToResgisto(e);
            System.out.println("Menu -> Foi criada a especie:\n" + e);
        }  
    }
    
    private void inserirNovoGenesDeEspecie(){
        String nome = this.pedirNome("Introduza um nome para o GeneEspecie.");
        String valor = this.pedirValorStringGeneEspecie();
        GeneEspecie e = new GeneEspecie(valor, nome);
        GeneEspecie.addInstanceToResgisto(e);
        System.out.println("Menu -> Foi criada o gene:\n" + e);
    }
    
    private void inserirNovoGenesEspecificos(){
        String nome=this.pedirNome("Introduza um nome para o GeneEspecifico.");
        CararcteristicasEspecificas tipo = pedirTipoCaracteristica();
        String valor=this.pedirValorStringGeneEspecifico();
        GeneEspecifico e=new GeneEspecifico(valor, nome, tipo);
        GeneEspecifico.addInstanceToResgisto(e);
        System.out.println("Menu -> Foi criada o gene:\n" + e);
    }
    
    private void inserirNovoGenesDeSexo(){
        String nome = pedirNome("Introduza um nome para o GeneSexo.");
        Sexo sexo = pedirSexo();
        GeneSexo s = new GeneSexo(sexo, nome);
        GeneSexo.addInstanceToResgisto(s);
        System.out.println("Menu -> Foi criada o gene:\n" + s);
    }
    private void inserirNovoGeneDeDieta(){
        String nome=this.pedirNome("Introduza um nome para o GeneDieta.");
        Dieta d=pedirDieta();
        GeneDieta dieta=new GeneDieta(d, nome);
        GeneDieta.addInstanceToResgisto(dieta);
        System.out.println("Menu -> Foi criada o gene:\n" + dieta);
    }
    private void inserirNovoGeneDeReproducao(){
        String nome= this.pedirNome("Introduza um nome para o GeneReproducao.");
        int i=this.pedirNumero("Introduza um Valor entre 0 e 100 para o Apetite de Reprodução", 0, 100);
        GeneRepoducao r=new GeneRepoducao(i, nome);
        GeneRepoducao.addInstanceToResgisto(r);
        System.out.println("Menu -> Foi criada o gene:\n" + r);
    }
    
    private void inserirNovoGeneDeLongitividade(){
        String nome = this.pedirNome("Introduza um nome para o GeneLongitividade.");
        int i = this.pedirNumero("Introduza um Valor para os anos", 0, -1);
        GeneLongividade l=new GeneLongividade(i, nome);
        GeneLongividade.addInstanceToResgisto(l);
        System.out.println("Menu -> Foi criada o gene:\n" + l);
    }
    
    private void inserirNovoGeneDeAmbiente(){
        String nome = this.pedirNome("Introduza um nome para o GeneAmbiente.");
        Ambiente a = pedirAmbiente();
        GeneAmbiente ambi=new GeneAmbiente(a, nome);
        GeneAmbiente.addInstanceToResgisto(ambi);
        System.out.println("Menu -> Foi criada o gene:\n" + ambi);
    }
    
    private void inserirNovoGeneDeAtratividade(){
        String nome = this.pedirNome("Introduza um nome para o GeneAtratividade.");
        int i = this.pedirNumero("Introduza um Valor entre para a Atratividade Base", 0, -1);
        GeneAtratividade a = new GeneAtratividade(i, nome);
        GeneAtratividade.addInstanceToResgisto(a);
        System.out.println("Menu -> Foi criada o gene:\n" + a);
    }
    
}
