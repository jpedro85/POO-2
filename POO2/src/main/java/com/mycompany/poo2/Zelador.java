/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public class Zelador extends Empregado {

    private static int numeroZeladores;

    public Zelador(String nome, int nif, int idade, double salarioBase, int bonusTarefa, int experiencia, int maxTarefas, int totalTarefas) {
        super(nome, nif, idade, salarioBase, bonusTarefa, experiencia, maxTarefas, totalTarefas);
        numeroZeladores++;
    }

    public void trabalhar() {
        
    }

    public static int getQuantidade() {
        return numeroZeladores;
    }

    public double getSalario() {
        return super.getSalarioBase()+super.getSalarioBase()*super.getBonusTarefa()*super.getMaxTarefas()/100;
    }

    public static Zelador eleminar(Zelador zela) {
        Empregado.eleminar((Empregado)zela);
        numeroZeladores--;
        return null;
    }

    
}
