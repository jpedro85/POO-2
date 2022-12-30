/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 *
 * @author Pedro
 */
public final class Gravador {

    private Gravador() {}

   /* public static void escreverAnimais(ArrayList<? extends Animal> animais, String ficheiro) {
        try {
            FileWriter fW = new FileWriter(ficheiro);
            BufferedWriter bW = new BufferedWriter(fW);
            PrintWriter out = new PrintWriter(bW);

            for (Animal a : animais) {
                out.println(a.toFormatedString());
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            out.close();
        }
    }

    public static void escreverInstalacoes(ArrayList<? extends Instalacao> instalacoes, String ficheiro) {
        try {
            FileWriter fW = new FileWriter(ficheiro);
            BufferedWriter bW = new BufferedWriter(fW);
            PrintWriter out = new PrintWriter(bW);

            for (Instalacao i : instalacoes) {
                out.println(i.toFormatedString());
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            out.close();
        }
    }

    public static void escreverPessoas(ArrayList<? extends Pessoa> pessoas, String ficheiro) {
        try {
            FileWriter fW = new FileWriter(ficheiro);
            BufferedWriter bW = new BufferedWriter(fW);
            PrintWriter out = new PrintWriter(bW);

            for (Pessoa p : pessoas) {
                out.println(p.toFormatedString());
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            out.close();
        }

    }

    public static void escreverGenes(ArrayList<? extends Gene> genes, String ficheiro) {
        try {
            FileWriter fW = new FileWriter(ficheiro);
            BufferedWriter bW = new BufferedWriter(fW);
            PrintWriter pw = new PrintWriter(bW);

            for (Gene g : genes) {
                pw.println(g.toFormatedString());
            }
            
            pw.close();
        } catch (IOException e) {
            System.out.println(e);
        } 
    }

    public static void escreverEspecies(ArrayList<? extends Especie> especies, String ficheiro) {
        try {
            FileWriter fW = new FileWriter(ficheiro);
            BufferedWriter bW = new BufferedWriter(fW);
            PrintWriter pw = new PrintWriter(bW);

            for (Especie e : especies) {
                pw.println(e.toFormatedString());
            }
            
            pw.close();
        } catch (IOException e) {
            System.out.println(e);
        } 
    }*/
    
    public static void gravarBaseDados(){
        
        gravarGravavel(GeneEspecie.getAllInstances(), Carregador.FICHEIRO_GENES_ESPECIE);
        gravarGravavel(Especie.getAllInstances(), Carregador.FICHEIRO_ESPECIES);
        gravarGravavel(GeneAmbiente.getAllInstances(), Carregador.FICHEIRO_GENES_AMBIENTE);
        gravarGravavel(GeneAtratividade.getAllInstances(), Carregador.FICHEIRO_GENES_ATRATIVIDADE);
        gravarGravavel(GeneDieta.getAllInstances(), Carregador.FICHEIRO_GENES_DIETA);
        gravarGravavel(GeneEspecifico.getAllInstances(), Carregador.FICHEIRO_GENES_ESPECIFICOS);
        gravarGravavel(GeneLongividade.getAllInstances(), Carregador.FICHEIRO_GENES_LONGITIVIDADE);
        gravarGravavel(GeneRepoducao.getAllInstances(), Carregador.FICHEIRO_GENES_REPRODUCAO);
        gravarGravavel(GeneSexo.getAllInstances(), Carregador.FICHEIRO_GENES_SEXO);
        
    }

    public static void gravarZoo() {
        
        gravarGravavel(Zoo.getAllEmpregados(), Carregador.FICHEIRO_ZOOEMPREGADOS);
        gravarGravavel(Zoo.getAllInstalacoes(), Carregador.FICHEIRO_ZOOINSTALACOES);
        gravarGravavel(Zoo.getAllNascimentos(), Carregador.FICHEIRO_ZOONASCIDOS);
        gravarGravavel(Zoo.getAllObitos(), Carregador.FICHEIRO_ZOOOBITUS);
        gravarHasMap(Zoo.getAllSemiLivres(), Carregador.FICHEIRO_ZOOSMILIVRES);
        gravarlinkedHasSet(Historico.getAcontecimentos(), Carregador.FICHEIRO_ZOOHISTORICO);
     
    }
    
    public static <T> void gravarGravavel( ArrayList<T> array,String ficheiro){
        
        System.out.println("A gravar no ficheiro " + ficheiro );
        try {
            FileWriter fW = new FileWriter(ficheiro);
            BufferedWriter bW = new BufferedWriter(fW);
            PrintWriter pw = new PrintWriter(bW);

            for (T e : array) {
                pw.println(((Gravavel)e).toFormatedString());
            }
            
            pw.close();
            
            System.out.println("Gravado !\n");
            
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Não Gravado !\n");
        } 
        
    
    }
    
    public static void gravarHasMap(HashMap<Animal,Instalacao> hasMap ,String ficheiro){
        
        System.out.println("A gravar no ficheiro " + ficheiro );
        try {
            FileWriter fW = new FileWriter(ficheiro);
            BufferedWriter bW = new BufferedWriter(fW);
            PrintWriter pw = new PrintWriter(bW);

            for (Map.Entry<Animal,Instalacao> entry : hasMap.entrySet()) {
                pw.println( entry.getKey().toFormatedString() +"|"+ entry.getValue().toFormatedString() );
            }
            
            pw.close();
            
            System.out.println("Gravado !\n");
            
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Não Gravado !\n");
        } 
    }
    
    public static <T> void gravarlinkedHasSet( LinkedHashSet<T> hasSet,String ficheiro){
        
        System.out.println("A gravar no ficheiro " + ficheiro );
        try {
            FileWriter fW = new FileWriter(ficheiro);
            BufferedWriter bW = new BufferedWriter(fW);
            PrintWriter pw = new PrintWriter(bW);

            for (T e : hasSet) {
                pw.println(((Gravavel)e).toFormatedString());
            }
            
            pw.close();
            
            System.out.println("Gravado !\n");
            
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Não Gravado !\n");
        } 

    }
    
    
}
