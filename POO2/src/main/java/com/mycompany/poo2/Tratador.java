/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public class Tratador extends Empregado{
    private static int numeroTratadores;
    public Tratador(String nome, int nif, int idade, double salarioBase, int bonusTarefa, int experiencia, int maxTarefas, int totalTarefas) {
        super(nome, nif, idade, salarioBase, bonusTarefa, experiencia, maxTarefas, totalTarefas);
    }
    
    //criarHorario
    //getHorario
    //trabalhar
    //dar comer
    
    public double getSalario(){
        return super.getSalarioBase()+super.getSalarioBase()*super.getBonusTarefa()*super.getMaxTarefas()/100;
    }
    
    public static int getQuantidade(){
        return numeroTratadores;
    }
    
    public void eleminar(){
        super.eleminar();
        numeroTratadores--;
    }
}
