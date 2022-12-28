/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.LinkedHashSet;

/**
 *
 * @author Pedro
 */
public final class Historico {
    
    private static LinkedHashSet<Acontecimento> acontecimentos = new LinkedHashSet<>(200);

    private Historico() {}

    public static void adicionarAcontecimento(Acontecimentos acontecimento, String descricao , int dia , Meses mes , int ano) {
                
        acontecimentos.add(  new Acontecimento(acontecimento,descricao,dia,mes,ano));
    }
    
    public static void adicionarAcontecimento(Acontecimentos acontecimento, String descricao , int dia , Meses mes , int ano,double valor) {
                
        acontecimentos.add(  new AcontecimentoMonetario(acontecimento,descricao,dia,mes,ano,valor) );
    }

    public static String getStringHistoricoDeTipo(Acontecimentos acontecimento){
        
        String text = "Historico de " + acontecimento + ":\n";
        
        for (Acontecimento acont : acontecimentos) {
            if (acont.getTipo() == acontecimento)  
                text += "\t" + acont + "\n";
        }
        return text;
        
    }
    
    public static String getStringHistorico() {
        String text = "Historico:\n";
        for (Acontecimento acont : acontecimentos) {
            text += acont + "\n";
        }
        return text;
    }
    
    private static class Acontecimento {
        
        private Acontecimentos tipo;
        private String desscricao;
        private int ano;
        private Meses mes;
        private int dia;
        
        
        public Acontecimento(Acontecimentos acontcimentos , String descricao , int dia , Meses mes, int ano){
            
            this.tipo = acontcimentos;
            this.desscricao = descricao;
            this.ano = ano;
            this.mes = mes;
            this.dia = dia;
            
        }

        public Acontecimentos getTipo() {
            return tipo;
        }

        public String getDesscricao() {
            return desscricao;
        }

        public int getAno() {
            return ano;
        }

        public Meses getMes() {
            return mes;
        }

        public int getDia() {
            return dia;
        }
        
        @Override
        public String toString() {
            return "Ano:" + dia + " Mês:" + mes + " Ano:" + ano + " Acontecimento:" + this.tipo + " desscricao:" + this.desscricao ;
        }
        
    }
    
    private static class AcontecimentoMonetario extends Acontecimento {
        
        private double valor;
        
        public AcontecimentoMonetario(Acontecimentos acontcimentos , String descricao , int dia , Meses mes, int ano, double valor){
            
            super(acontcimentos,descricao,dia,mes,ano);
            if(acontcimentos.equals(Acontecimentos.DESPESA))
                this.valor = -valor;
            else
                this.valor = valor;
            
        }

        public double getValor() {
            return valor;
        }
        
        @Override
        public String toString() {
            return "Ano:" + this.getAno() + " Mês:" + this.getMes() + " Ano:" + this.getAno() + " Acontecimento:" + Acontecimentos.DESPESA + " " + this.valor + " desscricao:" + this.getDesscricao() ;
        }
        
    }

}
