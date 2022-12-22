/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public class Veterinario extends Empregado {

    private static int numeroVeterinarios;

    public Veterinario(String nome, int nif, int idade, double salarioBase, int bonusTarefa, int experiencia, int maxTarefas, int totalTarefas) {
        super(nome, nif, idade, salarioBase, bonusTarefa, experiencia, maxTarefas, totalTarefas);
        numeroVeterinarios++;
    }

    public static int getQuantidade() {
        return numeroVeterinarios;
    }

    //criar horario
    //gethorario
    public void trabalhar() {

    }

    public void eleminar() {
        super.eleminar();
        numeroVeterinarios--;
    }

}
