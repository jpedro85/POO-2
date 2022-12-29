/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Francisco MSI
 */
public class MenuSimulador extends Menu{
    
    private static final int MAXOPTN = 5 ; 

    public MenuSimulador(Menu menu) {
        super(menu);
    }
    
    @Override
    public void mostrarOpcoes(){
        
        String str_optn = """
                            (1) -> Simular Proximo Dia
                            (2) -> Simular Proximos Dias
                            (3) -> Simular Até Ao Final Do Mês Atual
                            (4) -> Simular Até Ao Final Do Mês Tal 
                            (5) -> Simular um Ano
                         
                            (0) -> Voltar Atraz
                          """;
        super.mostrarOpcoes("======================================== Simulador =======================================",str_optn);

    }
      
    @Override
    public void executarOpcaoPedida(){
        this.executarOpcao(super.pedirOpcao(MAXOPTN));
    }
    
    @Override
    public void executarOpcao(int optn){
        
        switch(optn){
            
            case 0:
                this.voltarAtraz();
                break;
            case 1:
                Simulador.simularDia();
                this.pedirContinuar();
                break;
            case 2:
                this.simularDias(pedirNumero("Introduza o número de dias de 1 a 365 !", 1, 365));
                this.pedirContinuar();
                break;
            case 3:
                this.simularMes();
                this.pedirContinuar();
                break;
            case 4:
                this.simularMeses(pedirMes());
                this.pedirContinuar();
                break;
            case 5:
                this.simularAnos();
                this.pedirContinuar();
                break;
        }
        
    }
    
    private void simularDias(int dias){
        
        for (int i=0 ; i< dias ; i++) {
            Simulador.simularDia();
        }
    }
    
    private void simularMes(){
        
        for (int i = Simulador.getDiaCorrente(); i <= Simulador.getMesCorrente().getDias() ; i++) {
            Simulador.simularDia();
        }
        
    }
    
    private void simularMeses(Meses mesFinal){
        
        while(mesFinal.ordinal() > Simulador.getMesCorrente().ordinal()){
            Simulador.simularDia();
        }
    }
    
    private void simularAnos(){
        
        Meses atualUmAnoAtraz = Simulador.getMesCorrente();
        int ano = Simulador.getAnoCorrente();
        while(ano ==  Simulador.getAnoCorrente()){
            Simulador.simularDia();
        }
    }
    
    
}
