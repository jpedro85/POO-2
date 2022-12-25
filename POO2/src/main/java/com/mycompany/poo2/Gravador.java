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

/**
 *
 * @author Pedro
 */
public final class Gravador {

    private Gravador() {}

    public static void escreverAnimais(ArrayList<? extends Animal> animais, String ficheiro) {
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

    public static void escreverPessoas(ArrayList<? extends Pessoa> pessoas, String ficheiro){
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
            PrintWriter out = new PrintWriter(bW);

            for (Gene g : genes) {
                out.println(g.toFormatedString());
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            out.close();
        }
    }

    public static void escreverEspecies(ArrayList<? extends Especie> especies, String ficheiro) {
        try {
            FileWriter fW = new FileWriter(ficheiro);
            BufferedWriter bW = new BufferedWriter(fW);
            PrintWriter out = new PrintWriter(bW);

            for (Especie e : especies) {
                out.println(e.toFormatedString());
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            out.close();
        }
    }

    public static void gravarZoo() {}
}
