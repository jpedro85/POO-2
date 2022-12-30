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
        
        int nif = rand.nextInt(10000000, 99999999);
        
        while(true){
            for (Empregado a : Zoo.getAllEmpregados()) {
                if (a.getNif()==nif) break;
            }
            break;
        }
        return nif;

    }

    public static boolean gerarBoolean() {
        return gerarProbabilidade() < 50;
    }

    public static double gerarValorAnimal(Animal animal){
        
        return animal.getAtratividade()*100;
    }
    
    public static Empreiteira gerarEmpreiteira(Instalacao inst){
    
        String nome = Gerador.empreiteiras.get(Gerador.gerarNumero(0, Gerador.empreiteiras.size()-1));
        return new Empreiteira(nome, Gerador.gerarNumero(1000.0, 2500.0)*inst.getCapacidade() );
        
    }
    
    public static Instalacao gerarInstalacao() {
        
        String nome = "Instalacao_" + Gerador.gerarNumero(10, 100000) ;
        int capacidade = Gerador.gerarNumero(5, 100);
        double custoM = Gerador.gerarNumero(2000.0, 10000.0);
        double custoL = Gerador.gerarNumero(1000.0, 6000.0);
        int intervalo = Gerador.gerarNumero(10, 31);
        Ambiente amb = Ambiente.values()[Gerador.gerarNumero(0, Ambiente.values().length-1)];
        return new Instalacao(nome, capacidade, amb, custoM, custoL, intervalo);
        
    }
    
    public static Tratador gerarTratador() {
        
        String nome = Gerador.getPessoas().get(Gerador.gerarNumero(0, Gerador.getPessoas().size() ));
        int nif = Gerador.gerarNIF();
        int idade = Gerador.gerarNumero(18, 90);
        double salario = Gerador.gerarNumero(1000.0, 3000.0);
        int experiencia = Gerador.gerarNumero(0, 30);
        int bonus = Gerador.gerarNumero(10, 50);
        int max = Gerador.gerarNumero(20, 40);
        return new Tratador(nome,nif,idade,salario,bonus,experiencia, max, 0);
        
    }
    
    public static Zelador gerarZelador() {
        
        String nome = Gerador.getPessoas().get(Gerador.gerarNumero(0, Gerador.getPessoas().size() ));
        int nif = Gerador.gerarNIF();
        int idade = Gerador.gerarNumero(18, 90);
        double salario = Gerador.gerarNumero(1000.0, 2000.0);
        int experiencia = Gerador.gerarNumero(0, 30);
        int bonus = Gerador.gerarNumero(10, 100);
        int max = Gerador.gerarNumero(2, 5);
        return new Zelador(nome,nif,idade,salario,bonus,experiencia, max, 0);
        
    }
    
    public static Veterinario gerarVeterinario() {
        
        String nome = Gerador.getPessoas().get(Gerador.gerarNumero(0, Gerador.getPessoas().size() ));
        int nif = Gerador.gerarNIF();
        int idade = Gerador.gerarNumero(18, 90);
        double salario = Gerador.gerarNumero(1000.0, 5000.0);
        int experiencia = Gerador.gerarNumero(0, 50);
        int bonus = Gerador.gerarNumero(50, 200);
        int max = Gerador.gerarNumero(2, 5);
        return new Veterinario(nome,nif,idade,salario,bonus,experiencia, max, 0);
        
    }
    
    public static Animal gerarAnimal(GeneEspecifico gene) {
        
        Especie especieAleatoria = Especie.getAllInstances().get(gerarNumero(0, Especie.getAllInstances().size()));
        GeneSexo geneSexo = GeneSexo.getAllInstances().get(gerarNumero(0, GeneSexo.getAllInstances().size()));
        GeneDieta geneDieta = GeneDieta.getAllInstances().get(gerarNumero(0, GeneDieta.getAllInstances().size()));
        GeneAtratividade geneAtratividade = GeneAtratividade.getAllInstances().get(gerarNumero(0, GeneAtratividade.getAllInstances().size()));
        GeneLongividade geneLongividade = GeneLongividade.getAllInstances().get(gerarNumero(0, GeneLongividade.getAllInstances().size()));
        GeneRepoducao geneRepoducao = GeneRepoducao.getAllInstances().get(gerarNumero(0, GeneRepoducao.getAllInstances().size()));
        GeneAmbiente geneAmbiente = GeneAmbiente.getAllInstances().get(gerarNumero(0, GeneAmbiente.getAllInstances().size()));
        ArrayList<GeneEspecifico> geneEspecificos = new ArrayList<>();
        
        geneEspecificos.add(gene);
        
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
