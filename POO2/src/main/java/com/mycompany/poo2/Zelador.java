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

    public static int getQuantidade() {
        return numeroZeladores;
    }

    @Override
    public Horario createHorario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Horario getHorario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    //arranjar
    //limpar
    @Override
    public void trabalhar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eleminar() {
        super.eleminar();
        numeroZeladores--;
    }

}
