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

    public static <T> void carrega(Class<T> cclass, String ficheiro) {
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
        }
    }
}
