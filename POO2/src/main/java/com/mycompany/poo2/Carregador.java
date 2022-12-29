/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *  Oferece Métodos para caregar conteodos.
 */
public final class Carregador {

    private static boolean zooCarregado = false; //fica true quando no metodo carregar zoo
    private static final String FICHEIRO_GENES_ESPECIE = "SimuladorSaves/TodosGenesDeEspecie.txt";
    private static final String FICHEIRO_ESPECIES = "SimuladorSaves/TodosAsEspecies.txt";   
    private static final String FICHEIRO_GENES_AMBIENTE = "SimuladorSaves/TodosGenesDeAmbiente.txt";
    private static final String FICHEIRO_GENES_ATRATIVIDADE = "SimuladorSaves/TodosGenesDeAtratividade.txt";
    private static final String FICHEIRO_GENES_DIETA = "SimuladorSaves/TodosGenesDeDieta.txt";
    private static final String FICHEIRO_GENES_ESPECIFICOS = "SimuladorSaves/TodosGenesDeEspecifico.txt";
    private static final String FICHEIRO_GENES_LONGITIVIDADE = "SimuladorSaves/TodosGenesDeLongitividade.txt";
    private static final String FICHEIRO_GENES_REPRODUCAO = "SimuladorSaves/TodosGenesDeReproducao.txt";
    private static final String FICHEIRO_GENES_SEXO = "SimuladorSaves/TodosGenesDeSexo.txt";
    private static final String FICHEIRO_PESSOAS = "SimuladorSaves/Pessoas.txt";
    private static final String FICHEIRO_ANIMAIS = "SimuladorSaves/Animais.txt";
    private static final String FICHEIRO_EMPRESAS = "SimuladorSaves/Empresas.txt";
    private Carregador() {
    }
    
    public static boolean estaZooCarregado() {
        return zooCarregado;
    }
    
    public static <T> void carrega(Class<T> cclass, String ficheiro) {
        
        System.out.println("A carregar o ficheiro: " + ficheiro);
        int errors=0;
        try {
            
            FileReader rW = new FileReader(ficheiro);
            BufferedReader bW = new BufferedReader(rW);
            String linha="";
            linha=bW.readLine();
            int contador=0;
            
            while(linha!=null) {
                contador++;
                try {

                    T a = cclass.getConstructor(FormatedString.class).newInstance(new FormatedString(linha));
                    Registo<T> b = (Registo<T>) a;
                    b.addInstanceAoResgisto();

                } catch (RepresentacaoInvalidaDoTipo exp1) {
                    System.out.println(exp1);
                } catch (Exception expall) {//porque usamos a class construct nao é apanhada a exceccao representacaodotipo do construtor da class:Illegal access
                    System.out.print("Item não carregado!! ");
                    System.out.println("Na linha "+contador+" do ficheiro");
                    System.out.println(RepresentacaoInvalidaDoTipo.getUltimaExcecao().getMessage());
                }
                linha=bW.readLine();
            }
            bW.close();
            rW.close();
            
        } catch (IOException e) {
            System.out.println("Não foi possivel abrir o ficheiro: "+ficheiro);
            errors++;
        }
        System.out.println("O ficheiro foi carregado com " + errors + " erros !\n");
    }
    
    //carregar Strings carregar zoo
    
    public static void carregarStringS(String ficheiro,ArrayList<String> array){
        
        System.out.println("A carregar o ficheiro: " + ficheiro);
        int errors=0;
        try {
            
            FileReader rW = new FileReader(ficheiro);
            BufferedReader bW = new BufferedReader(rW);
            String linha="";
            linha=bW.readLine();

            while(linha!=null) {
                
                array.add(linha);
                linha=bW.readLine();
            }
            bW.close();
            rW.close();
            
        } catch (IOException e) {
            System.out.println("Não foi possivel abrir o ficheiro: "+ficheiro);
            errors++;
        }
        System.out.println("O ficheiro foi carregado com " + errors + " erros !\n");
    }
    
    public static void carregarFicheiros(){
    
        Carregador.carrega(GeneEspecie.class, Carregador.FICHEIRO_GENES_ESPECIE); 
        Carregador.carrega(Especie.class, Carregador.FICHEIRO_ESPECIES);
        Carregador.carrega(GeneAmbiente.class, FICHEIRO_GENES_AMBIENTE);
        Carregador.carrega(GeneAtratividade.class, FICHEIRO_GENES_ATRATIVIDADE);
        Carregador.carrega(GeneDieta.class, FICHEIRO_GENES_DIETA); 
        Carregador.carrega(GeneEspecifico.class, FICHEIRO_GENES_ESPECIFICOS);
        Carregador.carrega(GeneLongividade.class, FICHEIRO_GENES_LONGITIVIDADE);
        Carregador.carrega(GeneRepoducao.class, FICHEIRO_GENES_REPRODUCAO);
        Carregador.carrega(GeneSexo.class, FICHEIRO_GENES_SEXO);
        
        carregarStringS(Carregador.FICHEIRO_PESSOAS,Gerador.getPessoas());
        carregarStringS(Carregador.FICHEIRO_ANIMAIS,Gerador.getNomesArtisticos());
        carregarStringS(Carregador.FICHEIRO_EMPRESAS,Gerador.getEmpreiteiras());
        
    }
}
