/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Pedro
 */
public final class Carregador {

    private Carregador() {
    }

    public <T> void carrega(Class<T> cclass, String ficheiro) {
        try {
            
            FileReader rW = new FileReader(ficheiro);
            BufferedReader bW = new BufferedReader(rW);
            String linha="";
            while(linha!=null) {
                
                try {

                    T a = cclass.getConstructor(FormatedString.class).newInstance(new FormatedString(ficheiro));

                    Registo<T> b = (Registo<T>) a;
                    b.addInstance(a);

                } catch (RepresentacaoInvalidaDoTipo exp1) {
                    System.out.println(exp1.getMessage());
                } catch (Exception expall) {
                    System.out.println("MERDA!!!!!");
                }
                linha=bW.readLine();
            }
            bW.close();
            rW.close();
        } catch (IOException e) {
            System.out.println("Não foi possivel abrir o ficheiro: "+ficheiro);
        }
    }
}
