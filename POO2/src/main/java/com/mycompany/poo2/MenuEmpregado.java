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
public final class MenuEmpregado extends Menu{

    public MenuEmpregado(Menu menu) {
        super(menu);
    }
    
    private final int MAXOPTN = 4;

    public void mostrarOpcoes() {
        String optn = "";
        optn = """
                (1) -> Ver Empregados
                (2) -> Despedir
                (3) -> Contratar
                (4) -> Mudar Salário

                (0) -> Voltar Atraz""";
        this.mostrarOpcoes("================================= Menu Gerir Empregados =================================",optn);
    }
    
    @Override
    public void executarOpcaoPedida() {
        this.executarOpcao(this.pedirOpcao(MAXOPTN));
    }
    
    @Override
    public void executarOpcao(int optn) {
        
        switch (optn){
            case 0:
                this.voltarAtraz();
                break;
            case 1:
                verEmpregados();
                break;
            case 2:
                despedirEmpregados();
                break;
            case 3:
                contratarEmpregados();
                break;
            case 4:
                mudarSalarioEmpregados();
                break;
        }
    }   
    
    private void verEmpregados(){
        
        if(Zoo.getAllEmpregados().isEmpty()){
            System.out.println("Não existem Empregados !");
            this.pedirContinuar();
        }else{
        
            for (Empregado empregado : Zoo.getAllEmpregados()) {
                System.out.println(empregado);
            }
            
            this.pedirContinuar();
        }
    }
    
    private void despedirEmpregados(){
        
        Empregado emp = this.pedirEmprepago();
        
        if(emp != null){
        
            Zoo.getAllEmpregados().remove(emp);
            System.out.println("Foi Despedido o :" + emp);
            Historico.adicionarAcontecimento(Acontecimentos.DESPEDIMENTO, "For Despedido o " + emp, Simulador.getDiaCorrente(), Simulador.getMesCorrente(), Simulador.getAnoCorrente());
        }
        
        this.pedirContinuar();
    }
    
    private void contratarEmpregados(){
        
        ArrayList<Empregado> empregados = new ArrayList<>(9);
        int contador=0;
        Empregado emp;
        
        for (int i = 0; i < 3; i++) {
            
            emp = Gerador.gerarTratador();
            empregados.add(emp);
            System.out.println(" ("+contador+") ->" + emp);
            contador++;
        }
        for (int i = 0; i < 3; i++) {
            
            emp = Gerador.gerarVeterinario();
            empregados.add(emp);
            System.out.println(" ("+contador+") ->" + emp);
            contador++;
        }
        for (int i = 0; i < 3; i++) {
            
            emp = Gerador.gerarZelador();
            empregados.add(emp);
            System.out.println(" ("+contador+") ->" + emp);
            contador++;
        }
        
        Empregado b = empregados.get(this.pedirOpcao(contador-1));
        System.out.println("Foi Contratado o :" + b );
        Historico.adicionarAcontecimento(Acontecimentos.CONTRATACAO, "For Contratado o " + b, Simulador.getDiaCorrente(), Simulador.getMesCorrente(), Simulador.getAnoCorrente());
        Zoo.getAllEmpregados().add(b);
        
        this.pedirContinuar();
        
    }
    
    public void mudarSalarioEmpregados(){
        
        Empregado emp = this.pedirEmprepago();
        
        if(emp != null){
        
            double salario = pedirNumero("Introduza o novo salário", 0.0, -1);
            emp.setSalarioBase(salario);
            
            System.out.println("O : " + emp +"\nRecebe agora :" + salario);
            Historico.adicionarAcontecimento(Acontecimentos.INFO, "O : " + emp +" Recebe agora :" + salario, Simulador.getDiaCorrente(), Simulador.getMesCorrente(), Simulador.getAnoCorrente());
            
            this.pedirContinuar();
        }
    }
}
