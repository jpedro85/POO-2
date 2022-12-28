/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Francisco MSI
 */
public final class Gerador {

    private static ArrayList<String> pessoas = new ArrayList<>();
    private static ArrayList<String> nomesArtisticos = new ArrayList<>();
    private static ArrayList<String> empreiteiras = new ArrayList<>();

    private Gerador() {
    }
    private final static Random rand = new Random();

    public static int gerarNumero(int min, int max) {

        return rand.nextInt(min, max);

    }

    public static double gerarNumero(double min, double max) {

        return rand.nextDouble(min, max);

    }

    public static Double gerarProbabilidade() {

        return rand.nextDouble(100);
    }

    public static int gerarOrdinal(int max) {

        return rand.nextInt(max);
    }

    public static int gerarNIF() {

        return rand.nextInt(10000000, 99999999);

    }

    public static boolean gerarBoolean() {
        return gerarProbabilidade() < 50;
    }

    public static double gerarValorAnimal(Animal animal){
        
        return 200;
    }
    
    public static Animal gerarAnimal() {
        Especie especieAleatoria = Especie.getAllInstances().get(gerarNumero(0, Especie.getAllInstances().size()));
        GeneSexo geneSexo = GeneSexo.getAllInstances().get(gerarNumero(0, GeneSexo.getAllInstances().size()));
        GeneDieta geneDieta = GeneDieta.getAllInstances().get(gerarNumero(0, GeneDieta.getAllInstances().size()));
        GeneAtratividade geneAtratividade = GeneAtratividade.getAllInstances().get(gerarNumero(0, GeneAtratividade.getAllInstances().size()));
        GeneLongividade geneLongividade = GeneLongividade.getAllInstances().get(gerarNumero(0, GeneLongividade.getAllInstances().size()));
        GeneRepoducao geneRepoducao = GeneRepoducao.getAllInstances().get(gerarNumero(0, GeneRepoducao.getAllInstances().size()));
        GeneAmbiente geneAmbiente = GeneAmbiente.getAllInstances().get(gerarNumero(0, GeneAmbiente.getAllInstances().size()));
        ArrayList<GeneEspecifico> geneEspecificos = new ArrayList<>();
        for (int i = 0; i < gerarNumero(1, CararcteristicasEspecificas.values().length); i++) {
            GeneEspecifico geneEspecifico = GeneEspecifico.getAllInstances().get(gerarNumero(0, GeneEspecifico.getAllInstances().size()));
            while (geneEspecificos.contains(geneEspecifico)) {
                geneEspecifico = GeneEspecifico.getAllInstances().get(gerarNumero(0, GeneEspecifico.getAllInstances().size()));
            }
            geneEspecificos.add(geneEspecifico);
        }
        Genoma genoma = new Genoma(especieAleatoria, geneSexo, geneDieta, geneAtratividade, geneLongividade, geneRepoducao, geneAmbiente, geneEspecificos);
        String nomeArtisticoPai = getNomesArtisticos().get(gerarNumero(0, getNomesArtisticos().size()));
        String nomeArtisticoMae = getNomesArtisticos().get(gerarNumero(0, getNomesArtisticos().size()));

        return new Animal(nomeArtisticoPai, nomeArtisticoMae, gerarBoolean(), genoma, gerarNumero(0, 20));
    }

    public static ArrayList<String> getPessoas() {
        return pessoas;
    }

    public static ArrayList<String> getNomesArtisticos() {
        return nomesArtisticos;
    }

    public static ArrayList<String> getEmpreiteiras() {
        return empreiteiras;
    }

    public static void setPessoas(ArrayList<String> pessoas) {
        Gerador.pessoas = pessoas;
    }

    public static void setNomesArtisticos(ArrayList<String> nomesArtisticos) {
        Gerador.nomesArtisticos = nomesArtisticos;
    }

    public static void setEmpreiteiras(ArrayList<String> empreiteiras) {
        Gerador.empreiteiras = empreiteiras;
    }

}
