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
public class Veterinario extends Empregado implements Registo<Veterinario>{

    private static int numeroVeterinarios;
    private static ArrayList<Veterinario> allInstancesCreated = new ArrayList<>(200);

    public Veterinario(FormatedString fstr) throws RepresentacaoInvalidaDoTipo {
        super(fstr,"Veterinario");
        numeroVeterinarios++;
    }

    public Veterinario(String nome, int nif, int idade, double salarioBase, int bonusTarefa, int experiencia, int maxTarefas, int totalTarefas) {
        super(nome, nif, idade, salarioBase, bonusTarefa, experiencia, maxTarefas, totalTarefas);
        numeroVeterinarios++;
    }

    public static int getQuantidade() {
        return numeroVeterinarios;
    }

    //criar horario
    //gethorario
    @Override
    public void trabalhar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eleminar() {
        super.eleminar();
        numeroVeterinarios--;
    }

    @Override
    public Horario createHorario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Horario getHorario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public FormatedString toFormatedString() {

        FormatedString fstr = new FormatedString(getClass().getSimpleName(), 9);
        fstr.addAtributo("Nome", this.getNome());
        fstr.addAtributo("Nif", this.getNif());
        fstr.addAtributo("Idade", this.getIdade());
        fstr.addAtributo("SalarioBase", this.getSalarioBase());
        fstr.addAtributo("BonusTarefa", this.getBonusTarefa());
        fstr.addAtributo("Experiencia", this.getExperiencia());
        fstr.addAtributo("MaxTarefas", this.getMaxTarefas());
        fstr.addAtributo("TotalTarefas", this.getTotalTarefas());
        fstr.addAtributo("TarefasMes", this.getTarefasMes());

        return fstr;
    }

    @Override
    public ArrayList<Veterinario> getAllInstances() {
        return allInstancesCreated;
    }

    @Override
    public void addInstance(Veterinario instance) {
        allInstancesCreated.add(instance);
    }

    @Override
    public void removeInstance(Veterinario instance) {
        allInstancesCreated.remove(instance);
    }

}
