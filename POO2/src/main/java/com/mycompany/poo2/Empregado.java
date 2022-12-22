/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public abstract class Empregado extends Pessoa {

    private static int numeroEmpregados;
    private double salarioBase;
    private int bonusTarefa;
    private int experiencia;
    private int maxTarefas;
    private int totalTarefas;
    private int tarefasMes;
    private Horario horario;

    public Empregado(String nome, int nif, int idade, double salarioBase, int bonusTarefa, int experiencia, int maxTarefas, int totalTarefas) {
        super(nome, nif, idade);
        this.salarioBase = salarioBase;
        this.bonusTarefa = bonusTarefa;
        this.experiencia = experiencia;
        this.maxTarefas = maxTarefas;
        this.totalTarefas = totalTarefas;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getBonusTarefa() {
        return bonusTarefa;
    }

    public void setBonusTarefa(int bonusTarefa) {
        this.bonusTarefa = bonusTarefa;
    }

    public int getMaxTarefas() {
        return maxTarefas;
    }

    public int getTarefasMes() {
        return tarefasMes;
    }

    public void setTarefasMes(int tarefasMes) {
        this.tarefasMes = tarefasMes;
    }

    public void setMaxTarefas(int maxTarefas) {
        this.maxTarefas = maxTarefas;
    }

    public abstract Horario createHorario();

    public abstract Horario getHorario();

    public abstract void trabalhar();

    public double getSalario() {
        return salarioBase + salarioBase * bonusTarefa * maxTarefas / 100;
    }

    public static int getQuantidade() {
        return numeroEmpregados;
    }

    @Override
    public void eleminar() {
        super.eleminar();
        numeroEmpregados--;
    }

    @Override
    public String toString() {
        String text;
        text = "O Empregado tem: ";
        text += super.toString() + "\n";
        text += "Salario: " + salarioBase + " Tarefas bonus: " + bonusTarefa + " experiencia: " + experiencia + " maximo Tarefas: " + maxTarefas + " total de Tarefas: " + totalTarefas;
        return text;
    }
}
