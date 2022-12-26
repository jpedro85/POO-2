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
public class Zelador extends Empregado implements Registo<Zelador>{

    private static ArrayList<Zelador> allInstancesCreated = new ArrayList<>(200);
    private static int numeroZeladores;

    public Zelador(FormatedString fstr) throws RepresentacaoInvalidaDoTipo {
        super(fstr,"Zelador");
        numeroZeladores++;
    }

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

    public static ArrayList<Zelador> getAllInstances(){
        return allInstancesCreated; 
    }
    
    public static void addInstanceToResgisto( Zelador instance ){  
        allInstancesCreated.add(instance);
    }
   
    public static void removeInstanceToRegisto( Zelador instance ){
        allInstancesCreated.remove(instance);   
    }
    
    @Override
    public void addInstanceAoResgisto(){  
        allInstancesCreated.add(this);
    }
   
    @Override
    public void removeInstanceDoResgisto(){
        allInstancesCreated.remove(this);   
    }

}
