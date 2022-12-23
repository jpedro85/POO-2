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
        
        GeneEspecie a = new GeneEspecie("rosnar","geneEspecie");
        GeneEspecifico b = new GeneEspecifico("carinhoso","geneEspecifico", CararcteristicasEspecificas.OLHOS );
        GeneDieta c = new GeneDieta(Dieta.CARNIVORO,"geneDieta");
        GeneSexo d = new GeneSexo(Sexo.FEMEA ,"geneSexo");
        
        GeneLongividade e = new GeneLongividade(10,"geneLongitividade",5);
        GeneRepoducao f = new GeneRepoducao(30,"geneRepoducao",4);
        GeneAmbiente g = new GeneAmbiente(Ambiente.DESETICO,"geneAmbiente",3);
        GeneAtratividade h = new GeneAtratividade(50,"geneAtratividade",2);
        
        System.out.println(a);
        System.out.println(a.getId() );
        System.out.println(a.getNome());
        System.out.println(a.getValor());
        System.out.println("---------------------------------------------");
        System.out.println(b);
        System.out.println(b.getId() );
        System.out.println(b.getNome() );
        System.out.println(b.getTipo() );
        System.out.println(b.getValor() );
        System.out.println("---------------------------------------------");
        System.out.println(c);
        System.out.println(c.getId() );
        System.out.println(c.getNome());
        System.out.println(c.getDiteta());
        System.out.println("---------------------------------------------");
        System.out.println(d);
        System.out.println(d.getId() );
        System.out.println(d.getNome() );
        System.out.println(d.getSexo() );
        System.out.println("---------------------------------------------");
        System.out.println(e);
        System.out.println(e.getId() );
        System.out.println(e.getNome());
        System.out.println(e.getGeracao());
        System.out.println(e.getAnos());
        System.out.println("---------------------------------------------");
        System.out.println(f);
        System.out.println(f.getId() );
        System.out.println(f.getNome());
        System.out.println(f.getGeracao());
        System.out.println(f.getApetite());
        System.out.println("---------------------------------------------");
        System.out.println(g);
        System.out.println(g.getId() );
        System.out.println(g.getNome());
        System.out.println(g.getGeracao());
        System.out.println(g.getAmbiente());
        System.out.println("---------------------------------------------");
        System.out.println(h); 
        System.out.println(h.getId() );
        System.out.println(h.getNome());
        System.out.println(h.getGeracao());
        System.out.println(h.getAtratividade());
        System.out.println("---------------------------------------------");
        
        System.out.println("------------------------------------------------------------------------------------------");
        
        FormatedString fstr_a = a.toFormatedString();
        FormatedString fstr_b = b.toFormatedString();
        FormatedString fstr_c = c.toFormatedString();
        FormatedString fstr_d = d.toFormatedString();
        
        FormatedString fstr_e = e.toFormatedString();
        FormatedString fstr_f = f.toFormatedString();
        FormatedString fstr_g = g.toFormatedString();
        FormatedString fstr_h = h.toFormatedString();
        
        System.out.println(a);
        System.out.println(fstr_a);
        System.out.println("---------------------------------------------");
        
        System.out.println(b);
        System.out.println(fstr_b);
        System.out.println("---------------------------------------------");
        
        System.out.println(c);
        System.out.println(fstr_c);
        System.out.println("---------------------------------------------");
        
        System.out.println(d);
        System.out.println(fstr_d);
        System.out.println("---------------------------------------------");
        
        System.out.println(e);
        System.out.println(fstr_e);
        System.out.println("---------------------------------------------");
        
        System.out.println(f);
        System.out.println(fstr_f);
        System.out.println("---------------------------------------------");
        
        System.out.println(g);
        System.out.println(fstr_g);
        System.out.println("---------------------------------------------");
        
        System.out.println(h);
        System.out.println(fstr_h);
        
        System.out.println("------------------------------------------------------------------------------------------");
        
        
        try {
            
        
            Gene a1 = new GeneEspecie(fstr_a);
            Gene b1 = new GeneEspecifico(fstr_b );
            Gene c1 = new GeneDieta(fstr_c);
            Gene d1 = new GeneSexo(fstr_d);
            
            Gene e1 = new GeneLongividade(fstr_e);
            Gene f1 = new GeneRepoducao(fstr_f);
            Gene g1 = new GeneAmbiente(fstr_g);
            Gene h1 = new GeneAtratividade(fstr_h);
            
            System.out.println(a1);
            System.out.println(b1);
            System.out.println(c1);
            System.out.println(d1);
            System.out.println(e1);
            System.out.println(f1);
            System.out.println(g1);
            System.out.println(h1);
        
        } catch (RepresentacaoInvalidaDoTipo exec) {
            
            System.out.println("Merta:" + exec.getMessage() );
            
        }
        
        
        /*
        GeneEspecie(Id:1;Nome:geneEspecie;Valor:rosnar)
GeneEspecifico(Id:2;Nome:geneEspecifico;Valor:carinhoso;Tipo:olhos)
GeneDieta(Id:3;Nome:geneDieta;Dieta:carnivoro)
GeneSexo(Id:4;Nome:geneSexo;Sexo:femea)
GeneLongividade(Id:5;Nome:geneLongitividade;Geracao:5,Anos:10)
GeneRepoducao(Id:6;Nome:geneRepoducao;Geracao:4,Apetite:30)
GeneAmbiente(Id:7;Nome:geneAmbiente;Geracao:3,Ambiente:deserto)
GeneAtratividade(Id:8;Nome:geneAtratividade;Geracao:2,Atratividade:50)
        */
        
        String fr = "GeneEspecie(Id:1;Nome:geneEspecie;Valor:rosnar)";
       
        try{
            FormatedString teste = new FormatedString(fr);
            Gene teset = new GeneEspecie(teste);
            System.out.println(teset);
        }catch(RepresentacaoInvalidaDoTipo j){
            System.out.println(":: " + j.getMessage() );
        }
        
        
    }
    
    
}