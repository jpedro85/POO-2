/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public final class MenuGerirBaseDeDados extends Menu {

    private final int MAXOPTN = 19;

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
    public void executarOpcao(int optn) {
        switch (optn) {
            case 0 ->
                this.voltarAtraz();
            case 1 -> {
                if (!Especie.getAllInstances().isEmpty()) {
                    for (Especie especie : Especie.getAllInstances()) {
                        System.out.println(especie);;
                    }
                } else {
                    System.out.println("Não possui especies ainda!");
                }
            }
            case 2 -> {
                if (!GeneEspecie.getAllInstances().isEmpty()) {
                    for (GeneEspecie allInstance : GeneEspecie.getAllInstances()) {
                        System.out.println(allInstance);
                    }
                } else {
                    System.out.println("Não possui Genes de Especies ainda!");
                }
            }
            case 3 -> {
                if (!GeneEspecifico.getAllInstances().isEmpty()) {
                    for (GeneEspecifico allInstance : GeneEspecifico.getAllInstances()) {
                        System.out.println(allInstance);
                    }
                } else {
                    System.out.println("Não possui Genes Especificos ainda!");
                }
            }
            case 4 -> {
                if (!GeneDieta.getAllInstances().isEmpty()) {
                    for (GeneDieta allInstance : GeneDieta.getAllInstances()) {
                        System.out.println(allInstance);
                    }
                } else {
                    System.out.println("Não possui Genes de Dieta ainda!");
                }
            }
            case 5 -> {
                if (!GeneSexo.getAllInstances().isEmpty()) {
                    for (GeneSexo allInstance : GeneSexo.getAllInstances()) {
                        System.out.println(allInstance);
                    }
                } else {
                    System.out.println("Não possui Genes de Sexo ainda!");
                }
            }
            case 6 -> {
                if (!GeneRepoducao.getAllInstances().isEmpty()) {
                    for (GeneRepoducao allInstance : GeneRepoducao.getAllInstances()) {
                        System.out.println(allInstance);
                    }
                } else {
                    System.out.println("Não possui Genes de Reprodução ainda!");
                }
            }
            case 7 -> {
                if (!GeneLongividade.getAllInstances().isEmpty()) {
                    for (GeneLongividade allInstance : GeneLongividade.getAllInstances()) {
                        System.out.println(allInstance);
                    }
                } else {
                    System.out.println("Não possui Genes de Longividade ainda!");
                }
            }
            case 8 -> {
                if (!GeneAmbiente.getAllInstances().isEmpty()) {
                    for (GeneAmbiente allInstance : GeneAmbiente.getAllInstances()) {
                        System.out.println(allInstance);
                    }
                } else {
                    System.out.println("Não possui Genes de Ambiente ainda!");
                }
            }
            case 9 -> {
                if (!GeneAtratividade.getAllInstances().isEmpty()) {
                    for (GeneAtratividade allInstance : GeneAtratividade.getAllInstances()) {
                        System.out.println(allInstance);
                    }
                }else{
                    System.out.println("Não possui Genes de Atratividade ainda!");
                }
            }
            case 10 -> {
            }
            case 11 -> {
            }
            case 12 -> {
            }
            case 13 -> {
            }
            case 14 -> {
            }
            case 15 -> {
            }
            case 16 -> {
            }
            case 17 -> {
            }
            case 18 -> {
            }
        }
    }

    @Override
    public void excutarOpcaoPedida() {
        this.mostrarOpcoes();
        this.executarOpcao(this.pedirOpcao(MAXOPTN));
    }
}
