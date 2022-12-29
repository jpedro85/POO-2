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

    public Empregado(FormatedString fstr, String className) throws RepresentacaoInvalidaDoTipo {
        super(fstr, className);
        
        try{
            
            this.salarioBase = Double.parseDouble(fstr.getAtributo("SalarioBase",className));
            this.bonusTarefa = Integer.parseInt(fstr.getAtributo("BonusTarefa",className));
            this.experiencia = Integer.parseInt(fstr.getAtributo("Experiencia",className));
            this.maxTarefas = Integer.parseInt(fstr.getAtributo("MaxTarefas",className));
            this.totalTarefas = Integer.parseInt(fstr.getAtributo("TotalTarefas",className));
            
        }catch(NumberFormatException exp){
            throw new RepresentacaoInvalidaDoTipo("Numero mal formatado na FormatedString: \n" + fstr );
        }
        
        numeroEmpregados++;
    }
    
    public Empregado(String nome, int nif, int idade, double salarioBase, int bonusTarefa, int experiencia, int maxTarefas, int totalTarefas) {
        super(nome, nif, idade);
        this.salarioBase = salarioBase;
        this.bonusTarefa = bonusTarefa;
        this.experiencia = experiencia;
        this.maxTarefas = maxTarefas;
        this.totalTarefas = totalTarefas;
        numeroEmpregados++;
    }

    public Empregado(String nome, int nif, int idade, double salarioBase, int bonusTarefa, int experiencia, int maxTarefas) {
        super(nome, nif, idade);
        this.salarioBase = salarioBase;
        this.bonusTarefa = bonusTarefa;
        this.experiencia = experiencia;
        this.maxTarefas = maxTarefas;
        this.totalTarefas = 0;
        numeroEmpregados++;
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

    public static int getNumeroEmpregados() {
        return numeroEmpregados;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getTotalTarefas() {
        return totalTarefas;
    }

    public void setMaxTarefas(int maxTarefas) {
        this.maxTarefas = maxTarefas;
    }
    
    public void evoluir(){
        if (this.totalTarefas%10 == 0) 
            this.experiencia++;
    }
    
    public void trabalhar(){
        this.totalTarefas++;
    }
    
    public abstract void trabalhar(Instalacao instalacao, int dia, Meses mes ,int ano);

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
        return "empregado :\n\t" + super.toString() + " Tarefas Bonus: " + this.bonusTarefa + " Experiencia: " + this.experiencia + " Max Tarefas: " + this.maxTarefas + " Total de Tarefas: " + this.totalTarefas;
    }
}
