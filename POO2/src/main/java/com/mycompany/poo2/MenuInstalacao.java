/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public final class MenuInstalacao extends Menu {

    private final int MAXOPTN = 4;

    public MenuInstalacao(Menu menu) {
        super(menu);
    }
    
    public void mostrarOpcoes() {
        String optn = "";
        optn = """
                   (1) -> Destruir 
                   (2) -> Construir Ecpecifica
                   (3) -> Construir Aleatória
                   (4) -> Ver instalações
                  
                   (0) -> Voltar Atraz""";
        this.mostrarOpcoes("================================= Menu Gerir Instalações =================================",optn);
    }

    @Override
    public void executarOpcaoPedida() {
        this.executarOpcao(super.pedirOpcao(MAXOPTN));
    }
    
    @Override
    public void executarOpcao(int optn) {
        
        switch (optn) {
            case 0:
                this.voltarAtraz();
                break;
            case 1:
                destruirInstalação();
                break;
            case 2:
                construirInstalação();
                break;
            case 3:
                construirInstalaçãoAleatoria();
                break;
            case 4:
                verInstalacoes();
                break;
        }
    }
    
    private void construirInstalação(){
        
        String nome = this.pedirNome("Introduza o nome da Instalação !");
        Ambiente ambiente = this.pedirAmbiente();
        int capacidade = this.pedirNumero("Introduza a capacidade da Instalacao !", 0, -1);
        int intervaloManutenção = this.pedirNumero("Introduza o número de dias máximo em que a instalacao pode ficar sem manutenção !", 0, -1);
        double custoManutencao = this.pedirNumero("Introduza o custo de cada manutenção !", 0, -1);//-1 -> limit é max double representable
        double custolinpeza = this.pedirNumero("Introduza o custo de cada limpeza !", 0, -1);
        
        Instalacao novaInstalacao = new Instalacao(nome,capacidade,ambiente,custoManutencao,custolinpeza,intervaloManutenção);
        Zoo.getAllInstalacoes().add(novaInstalacao);
        
        Empreiteira emp = this.pedirEmpreiteira(novaInstalacao);
        
        System.out.println("Foi Construida a Isntalação:");
        Historico.adicionarAcontecimento(Acontecimentos.DESPESA, "Contrato de construcao da instalação " + novaInstalacao.getNome() + " id:" + novaInstalacao.getId(), Simulador.getDiaCorrente(), Simulador.getMesCorrente(), Simulador.getAnoCorrente(), emp.getPreco());
        Historico.adicionarAcontecimento(Acontecimentos.CONSTUCAO, "Foi Construida a instalação " + novaInstalacao.getNome() + " id:" + novaInstalacao.getId(), Simulador.getDiaCorrente(),Simulador.getMesCorrente(),Simulador.getAnoCorrente());
        System.out.println(novaInstalacao);
        
        this.pedirContinuar();        
    }
    
    private void construirInstalaçãoAleatoria(){
        
        ArrayList<Instalacao> instalacoes = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            Instalacao a = Gerador.gerarInstalacao();
            instalacoes.add(a);
            System.out.println(" (" + i + ") " + a  );
  
        }
        
        Instalacao novaInstalacao = instalacoes.get(this.pedirOpcao(2));
        Zoo.getAllInstalacoes().add(novaInstalacao);
        
        Empreiteira emp = this.pedirEmpreiteira(novaInstalacao);
        
        System.out.println("Foi Construida a Isntalação:");
        Historico.adicionarAcontecimento(Acontecimentos.DESPESA, "Contrato de construcao da instalação " + novaInstalacao.getNome() + " id:" + novaInstalacao.getId(), Simulador.getDiaCorrente(), Simulador.getMesCorrente(), Simulador.getAnoCorrente(), emp.getPreco());
        Historico.adicionarAcontecimento(Acontecimentos.CONSTUCAO, "Foi Construida a instalação " + novaInstalacao.getNome() + " id:" + novaInstalacao.getId(), Simulador.getDiaCorrente(),Simulador.getMesCorrente(),Simulador.getAnoCorrente());
        System.out.println(novaInstalacao);
        
        this.pedirContinuar();        
    }
    
    
    
    private void destruirInstalação(){
        
        Instalacao instalacao = this.pedirInstalacao();

        if(instalacao != null){
            if (instalacao.getOcupacao() != 0 && this.pedirBooleano("Os Animais da Instalação vão ser realocados para a \"arrecadação\". Deseja continuar ?")) {
                Zoo.getAllInstalacoes().remove(instalacao);
                System.out.println("A Instalação foi destruida !");
                Historico.adicionarAcontecimento(Acontecimentos.DESTRUICAO, "A instalação "+ instalacao.getNome() + " id:" + instalacao.getId() + " foi destruida.",Simulador.getDiaCorrente(), Simulador.getMesCorrente(), Simulador.getAnoCorrente());
                
                this.pedirContinuar();
            }else{
                
                Zoo.getAllInstalacoes().remove(instalacao);
                System.out.println("A Instalação foi destruida !");
                Historico.adicionarAcontecimento(Acontecimentos.DESTRUICAO, "A instalação "+ instalacao.getNome() + " id:" + instalacao.getId() + " foi destruida.",Simulador.getDiaCorrente(), Simulador.getMesCorrente(), Simulador.getAnoCorrente());
                
                this.pedirContinuar();
            }
        }
        
    }
    
    private void verInstalacoes(){
    
        for(Instalacao instalacao : Zoo.getAllInstalacoes()) {
            System.out.println(instalacao);
        }
        
        if(Zoo.getAllInstalacoes().isEmpty())
            System.out.println("O Zoo Não Tem Instalações !");
        
        this.pedirContinuar();
 
    }
    
}
