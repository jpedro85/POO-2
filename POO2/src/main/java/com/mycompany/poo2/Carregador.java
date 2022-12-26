/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author Pedro
 */
public final class Carregador {

    private Carregador() {
    }

    public static <T> void carregar(Class<T> cclass, String ficheiro) {
        try {
            
            FileReader rW = new FileReader(ficheiro);
            BufferedReader bW = new BufferedReader(rW);
            String linha="";
            linha=bW.readLine();
            while(linha!=null) {
                //System.out.println(linha);
                try {

                    T a = cclass.getConstructor(FormatedString.class).newInstance(new FormatedString(linha));

                    Registo<T> b = (Registo<T>) a;
                    b.addInstance(a);

                } catch (RepresentacaoInvalidaDoTipo exp1) {
                    System.out.println(exp1.getMessage());
                }catch(NoSuchMethodException exp2){
                    System.out.println("O Construtor não foi encontrado");
                }catch(InstantiationException exp3){
                    System.out.println("Não foi possivel instanciar o objeto da class: "+cclass.getSimpleName());
                }catch(IllegalAccessException exp4){
                    System.out.println("Acesso negado");
                }catch(InvocationTargetException exp5){
                    System.out.println("Erro de formatação na linha: "+linha);
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
