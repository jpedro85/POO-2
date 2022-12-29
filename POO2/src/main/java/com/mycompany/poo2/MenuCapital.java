/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public class MenuCapital extends Menu {

    private static final int MAXOPTN = 6;

    public MenuCapital(Menu menu) {
        super(menu);
    }
    
    @Override
    public void mostrarOpcoes() {
        String optn = "";
        optn = """
                (1) -> Ver Despesas 
                (2) -> Ver Lucros
                (3) -> Calcular Balanço (Periodo Comtabilistico)

                (0) -> Voltar Atraz""";
        this.mostrarOpcoes("=================================== Menu Gerir Capital =================================== ", optn);
    }

    @Override
    public void executarOpcaoPedida() {
        this.executarOpcao(this.pedirOpcao(MAXOPTN));
    }

    @Override
    public void executarOpcao(int optn) {
        switch (optn) {
            case 0:
                this.voltarAtraz();
                break;
            case 1:
                this.verDespesas();
                break;
            case 2:
                this.verLucros();
                break;
            case 3:
                this.calcularBanço();
                break;
        }
    }
    
    private void verDespesas(){
        
        if (Historico.getAcontecimentos().isEmpty()) {
            System.out.println("O Histórico está vazio.");
            this.pedirContinuar();
        }else{
            
            boolean hadespesas = false;
            for ( Historico.Acontecimento acontecimento : Historico.getAcontecimentos() ) {
                
                if (acontecimento.getTipo()==Acontecimentos.DESPESA) {
                    System.out.println(acontecimento);
                    hadespesas = true;
                }

            }
            
            if (!hadespesas) System.out.println("Não há despesas!");
            
            this.pedirContinuar();
        
        }
    }
    
    private void verLucros(){
        
        if (Historico.getAcontecimentos().isEmpty()) {
            System.out.println("O Histórico está vazio.");
            this.pedirContinuar();
        }else{
            
            boolean halucros = false;
            for ( Historico.Acontecimento acontecimento : Historico.getAcontecimentos() ) {
                
                if (acontecimento.getTipo()==Acontecimentos.LUCRO) {
                    System.out.println(acontecimento);
                    halucros = true;
                }

            }
            
            if (!halucros) System.out.println("Não há lucros!");
            
            this.pedirContinuar();
        
        }
    }
    
    public void calcularBanço(){
        
        Simulador.periodoComtabilistico(true);
        this.pedirContinuar();
    }

}
