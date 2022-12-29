/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 *  Main Class
 */
public class POO2 {


    public static void main(String[] args) {
        
        
     /*   Instalacao a = new Instalacao("teste1",5,Ambiente.DESERTICO,120,200,6);
        
        System.out.println(a);
        System.out.println(a.toFormatedString());
        
        try{
            Instalacao b = new Instalacao(a.toFormatedString());
            System.out.println(b);
        }
        catch(RepresentacaoInvalidaDoTipo e){
            System.out.println(e);
        }*/
        
        Carregador.carregarFicheiros();
        
        MenuGeral menuMenuGeral = new MenuGeral();
        menuMenuGeral.mostrarOpcoes();
        menuMenuGeral.executarOpcaoPedida();
     
       // MenuSimulador m = new MenuSimulador(null);
       // m.mostrarOpcoes();
       // m.executarOpcaoPedida();
        
    }
    
}
