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

    private static ArrayList<Veterinario> allInstancesCreated = new ArrayList<>(200);
    private static int numeroVeterinarios;

    public Veterinario(FormatedString fstr) throws RepresentacaoInvalidaDoTipo {
        super(fstr,"Veterinario");
        numeroVeterinarios++;
    }

    public Veterinario(String nome, int nif, int idade, double salarioBase, int bonusTarefa, int experiencia, int maxTarefas, int totalTarefas) {
        super(nome, nif, idade, salarioBase, bonusTarefa, experiencia, maxTarefas, totalTarefas);
        numeroVeterinarios++;
    }

    @Override
    public void trabalhar(Instalacao instalacao, int dia, Meses mes, int ano) {
        
        if (instalacao.temAnimaisDoentes()) {
            
            for (Animal animalDoente:instalacao.getAnimaisDoentes()) {
                
                if(animalDoente.ficaCorado(this)){
                    String mesg = "O animal o animal " + animalDoente + "foi curado pelo veterinário " + this;
                    Historico.adicionarAcontecimento(Acontecimentos.DESPESA,mesg, dia, mes, ano,Gerador.gerarNumero(50, 150));
                } else {
                    String mesg = "Tentativa de curar o animal " + animalDoente + " pelo veterinário " + this;
                    Historico.adicionarAcontecimento(Acontecimentos.DESPESA,mesg, dia, mes, ano,Gerador.gerarNumero(25, 50));
                }
            }           
        }
        
        super.trabalhar();
        super.evoluir();
    } 

    @Override
    public void eleminar() {
        super.eleminar();
        numeroVeterinarios--;
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

        return fstr;
    }
    
    public static int getQuantidade() {
        return numeroVeterinarios;
    }
    
    public static ArrayList<Veterinario> getAllInstances(){
        return allInstancesCreated; 
    }
    
    public static void addInstanceToResgisto( Veterinario instance ){  
        allInstancesCreated.add(instance);
    }
   
    public static void removeInstanceToRegisto( Veterinario instance ){
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
