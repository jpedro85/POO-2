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
public class Tratador extends Empregado implements Registo<Tratador>{

    private static int numeroTratadores;
    private static ArrayList<Tratador> allInstancesCreated = new ArrayList<>(200);

    public Tratador(FormatedString fstr) throws RepresentacaoInvalidaDoTipo {
        super(fstr,"Tratador");
        numeroTratadores++;
    }

    public Tratador(String nome, int nif, int idade, double salarioBase, int bonusTarefa, int experiencia, int maxTarefas, int totalTarefas) {
        super(nome, nif, idade, salarioBase, bonusTarefa, experiencia, maxTarefas, totalTarefas);
        numeroTratadores++;
    }

    //dar comer
    public static int getQuantidade() {
        return numeroTratadores;
    }

    @Override
    public void eleminar() {
        super.eleminar();
        numeroTratadores--;
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
    public void trabalhar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Tratador> getAllInstances() {
        return allInstancesCreated;
    }

    @Override
    public void addInstance( Tratador instance ){  
        allInstancesCreated.add(instance);
    }
   
    @Override
    public void removeInstance( Tratador instance ){
        allInstancesCreated.remove(instance);   
    }

}
