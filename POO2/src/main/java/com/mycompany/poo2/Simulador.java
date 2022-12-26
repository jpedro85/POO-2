/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public class Simulador {

    public static void main(String[] args) {
        Carregador.carrega(GeneEspecie.class, "SimuladorSaves/TodosGenesDeEspecie.txt");
        for (GeneEspecie gene : GeneEspecie.getAllInstances()) {
            System.out.println(gene);
        }
        System.out.println("-----------------------------------------");
        Carregador.carrega(Especie.class, "SimuladorSaves/TodosAsEspecies.txt");
        for (Especie gene2 : Especie.getAllInstances()) {
            System.out.println(gene2);
        }
        System.out.println("-----------------------------------------");
        Carregador.carrega(GeneAmbiente.class, "SimuladorSaves/TodosGenesDeAmbiente.txt");
        for (GeneAmbiente gene3 : GeneAmbiente.getAllInstances()) {
            System.out.println(gene3);
        }
        System.out.println("-----------------------------------------");
        Carregador.carrega(GeneAtratividade.class, "SimuladorSaves/TodosGenesDeAtratividade.txt");
        for (GeneAtratividade gene4 : GeneAtratividade.getAllInstances()) {
            System.out.println(gene4);
        }
        System.out.println("-----------------------------------------");
        Carregador.carrega(GeneDieta.class, "SimuladorSaves/TodosGenesDeDieta.txt");
        for (GeneDieta gene5 : GeneDieta.getAllInstances()) {
            System.out.println(gene5);
        }
        System.out.println("-----------------------------------------");
        Carregador.carrega(GeneEspecifico.class, "SimuladorSaves/TodosGenesDeEspecifico.txt");
        for (GeneEspecifico gene6 : GeneEspecifico.getAllInstances()) {
            System.out.println(gene6);
        }
        System.out.println("-----------------------------------------");
        Carregador.carrega(GeneLongividade.class, "SimuladorSaves/TodosGenesDeLongitividade.txt");
        for (GeneLongividade gene7 : GeneLongividade.getAllInstances()) {
            System.out.println(gene7);
        }
        System.out.println("-----------------------------------------");
        Carregador.carrega(GeneRepoducao.class, "SimuladorSaves/TodosGenesDeReproducao.txt");
        for (GeneRepoducao gene8 : GeneRepoducao.getAllInstances()) {
            System.out.println(gene8);
        }
        System.out.println("-----------------------------------------");
        Carregador.carrega(GeneSexo.class, "SimuladorSaves/TodosGenesDeSexo.txt");
        for (GeneSexo gene9 : GeneSexo.getAllInstances()) {
            System.out.println(gene9);
        }
        System.out.println("-----------------------------------------");
        
        
        
    }
}
