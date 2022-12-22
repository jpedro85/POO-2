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
        
        
        System.out.println("teste");
        
        Gene a = new GeneEspecie("rosnar","geneEspecie");
        Gene b = new GeneEspecifico("carinhoso","geneEspecifico", CararcteristicasEspecificas.OLHOS );
        Gene c = new GeneDieta(Dieta.CARNIVORO,"geneDieta");
        Gene d = new GeneLongividade(10,"geneLongitividade");
        Gene e = new GeneRepoducao(30,"geneRepoducao");
        Gene f = new GeneSexo(Sexo.FEMEA ,"geneSexo");
        Gene g = new GeneAmbiente(Ambiente.DESETICO,"geneAmbiente");
        Gene h = new GeneAtratividade(50,"geneAtratividade");
        
        /*System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);*/        
        
        FormatedString fstr_a = a.toFormatedString();
        FormatedString fstr_b = b.toFormatedString();
        FormatedString fstr_c = c.toFormatedString();
        FormatedString fstr_d = d.toFormatedString();
        FormatedString fstr_e = e.toFormatedString();
        FormatedString fstr_f = f.toFormatedString();
        FormatedString fstr_g = g.toFormatedString();
        FormatedString fstr_h = h.toFormatedString();
        
        System.out.println(a);
        System.out.println(fstr_a.getString() );
        System.out.println("---------------------------------------------");
        
        System.out.println(b);
        System.out.println(fstr_b.getString());
        System.out.println("---------------------------------------------");
        
        System.out.println(c);
        System.out.println(fstr_c.getString());
        System.out.println("---------------------------------------------");
        
        System.out.println(d);
        System.out.println(fstr_d.getString());
        System.out.println("---------------------------------------------");
        
        System.out.println(e);
        System.out.println(fstr_e.getString());
        System.out.println("---------------------------------------------");
        
        System.out.println(f);
        System.out.println(fstr_f.getString());
        System.out.println("---------------------------------------------");
        
        System.out.println(g);
        System.out.println(fstr_g.getString());
        System.out.println("---------------------------------------------");
        
        System.out.println(h);
        System.out.println(fstr_h.getString());
        
        System.out.println("------------------------------------------------------------------------------------------");
        
        
    }
    
    
}