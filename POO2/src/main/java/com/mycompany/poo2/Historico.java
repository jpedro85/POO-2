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
    
    public static void adicionarAcontecimento(FormatedString fstr ) throws RepresentacaoInvalidaDoTipo{
        
        Acontecimento acontecimento;
        if (fstr.getTipo().equals(Acontecimento.class.getSimpleName())) {
            acontecimento = new Historico.Acontecimento(fstr);
        } else if (fstr.getTipo().equals(AcontecimentoMonetario.class.getSimpleName())) {
            acontecimento = new Historico.AcontecimentoMonetario(fstr);
        } else {
            throw new RepresentacaoInvalidaDoTipo("FromatedString " + fstr + " não representa nem um Acontecimento nem AcontecimentoMonetário.");
        }
        acontecimentos.add( acontecimento);
    }
    
    public static void adicionarAcontecimento(Acontecimento acontecimento ) {
                
        acontecimentos.add( acontecimento);
    }
    
    public static LinkedHashSet<Acontecimento> getAcontecimentos(){
        return acontecimentos;
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
    
    public static class Acontecimento implements Gravavel{
        
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
        
        public Acontecimento(FormatedString fstr) throws RepresentacaoInvalidaDoTipo{
            
            if (!fstr.getTipo().equals(Acontecimento.class.getSimpleName() )) 
                throw new RepresentacaoInvalidaDoTipo("FormatedString " + fstr + " não representa um Acontecimento.");
            
            this.tipo = Acontecimentos.representa(fstr.getAtributo("Tipo", Acontecimento.class.getSimpleName()));
            if(this.tipo == null)
                throw new RepresentacaoInvalidaDoTipo("O valor do campo Tipo não representa nenhum do tipo Acontecimentos.");
            
            this.mes = Meses.representa(fstr.getAtributo("Mês", Acontecimento.class.getSimpleName()));
            if(this.mes == null)
                throw new RepresentacaoInvalidaDoTipo("O valor do campo Mês não representa nenhum do tipo Meses.");
            
            this.desscricao = fstr.getAtributo("Descrição", Acontecimento.class.getSimpleName());
            
            try {
                this.ano = Integer.parseInt(fstr.getAtributo("Ano", Acontecimento.class.getSimpleName()));
                this.dia = Integer.parseInt(fstr.getAtributo("Dia", Acontecimento.class.getSimpleName()));

            } catch (NumberFormatException exp) {
                throw new RepresentacaoInvalidaDoTipo("Numero mal formatado na FormatedString: \n" + fstr);
            }
            
            
        }
        
        public Acontecimento(FormatedString fstr,String className) throws RepresentacaoInvalidaDoTipo{
            
            if (!fstr.getTipo().equals(className )) 
                throw new RepresentacaoInvalidaDoTipo("FormatedString " + fstr + " não representa um Acontecimento.");
            
            this.tipo = Acontecimentos.representa(fstr.getAtributo("Tipo", className));
            if(this.tipo == null)
                throw new RepresentacaoInvalidaDoTipo("O valor do campo Tipo não representa nenhum do tipo Acontecimentos.");
            
            this.mes = Meses.representa(fstr.getAtributo("Mês", className));
            if(this.mes == null)
                throw new RepresentacaoInvalidaDoTipo("O valor do campo Mês não representa nenhum do tipo Meses.");
            
            this.desscricao = fstr.getAtributo("Descrição", className);
            
            try {
                this.ano = Integer.parseInt(fstr.getAtributo("Ano", className));
                this.dia = Integer.parseInt(fstr.getAtributo("Dia", className));

            } catch (NumberFormatException exp) {
                throw new RepresentacaoInvalidaDoTipo("Numero mal formatado na FormatedString: \n" + fstr);
            }
            
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
            return "Ano:" + dia + " Mês:" + mes + " Ano:" + ano + " Acontecimento:" + this.tipo + "\n\t"+"desscricao: " + this.desscricao +"\n";
        }

        @Override
        public FormatedString toFormatedString() {
            
            FormatedString fstr = new FormatedString(Acontecimento.class.getSimpleName(), 5);
            fstr.addAtributo("Tipo", this.tipo.toString());
            fstr.addAtributo("Descrição", this.desscricao);
            fstr.addAtributo("Dia", this.dia);
            fstr.addAtributo("Mês", this.mes);
            fstr.addAtributo("Ano", this.ano);
            
            return fstr;  
        }
        
    }
    
    public static class AcontecimentoMonetario extends Acontecimento {
        
        private double valor;
        
        public AcontecimentoMonetario(Acontecimentos acontcimentos , String descricao , int dia , Meses mes, int ano, double valor){
            
            super(acontcimentos,descricao,dia,mes,ano);
            this.valor = valor;
            
        }
        
        public AcontecimentoMonetario(FormatedString fstr) throws RepresentacaoInvalidaDoTipo{
            
            super(fstr,AcontecimentoMonetario.class.getSimpleName());
            
            try {
                this.valor = Double.parseDouble(fstr.getAtributo("Valor", AcontecimentoMonetario.class.getSimpleName()));

            } catch (NumberFormatException exp) {
                throw new RepresentacaoInvalidaDoTipo("Numero mal formatado na FormatedString: \n" + fstr);
            }
            
        }
        
        public double getValor() {
            return valor;
        }
        
        @Override
        public String toString() {
            return "Dia:" + this.getDia() + " Mês:" + this.getMes() + " Ano:" + this.getAno() + " Acontecimento: " + Acontecimentos.DESPESA + " " + this.valor + "\n\t"+"desscricao: " + this.getDesscricao() + "\n";
        }
        
        @Override
        public FormatedString toFormatedString() {
            
            FormatedString fstr = new FormatedString(Acontecimento.class.getSimpleName(), 5);
            fstr.addAtributo("Tipo", this.getTipo());
            fstr.addAtributo("Descrição", this.getDesscricao());
            fstr.addAtributo("Dia", this.getDia());
            fstr.addAtributo("Mês", this.getMes());
            fstr.addAtributo("Ano", this.getAno());
            fstr.addAtributo("Valor", this.getValor());
            
            return fstr;  
        }
    }

}
