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

    private static ArrayList<Tratador> allInstancesCreated = new ArrayList<>(200);
    private static int numeroTratadores;

    public Tratador(FormatedString fstr) throws RepresentacaoInvalidaDoTipo {
        super(fstr,"Tratador");
        numeroTratadores++;
    }

    public Tratador(String nome, int nif, int idade, double salarioBase, int bonusTarefa, int experiencia, int maxTarefas, int totalTarefas) {
        super(nome, nif, idade, salarioBase, bonusTarefa, experiencia, maxTarefas, totalTarefas);
        numeroTratadores++;
    }

    @Override
    public void trabalhar(Instalacao instalacao, int dia, Meses mes, int ano) {
        
        double desconto = 0;
        
        for (Animal animalDoente : instalacao.getAnimaisDoentes()) {
            trabalharAuxiliar( animalDoente ,desconto, dia, mes ,ano);    
        }  
        
        for (Animal animalSaudavel : instalacao.getAnimaisSaudaveis()) {
            trabalharAuxiliar( animalSaudavel ,desconto, dia, mes ,ano);    
        }
      
        super.trabalhar();
        super.evoluir();
    } 
    
    private void trabalharAuxiliar(Animal animalDoente,double desconto,int dia,Meses mes ,int ano){
        
        String mesg = "";
        String dieta = animalDoente.getGenoma().getGeneDieta().toString();
        animalDoente.resetUltimaTratacao();
        
        if (dieta.equals(Dieta.VEGETARIANO.toString())) {

            mesg = "O animal " + animalDoente + " foi alimentado pelo tratador " + this;
            desconto = this.getExperiencia() * 0.2;
            desconto = desconto > 20 ? 20 : desconto;
            Historico.adicionarAcontecimento(Acontecimentos.DESPESA, mesg, dia, mes, ano, Gerador.gerarNumero(20 - desconto, 40 - desconto));
        } else if (dieta.equals(Dieta.OMNIVORO.toString())) {

            mesg = "O animal " + animalDoente + " foi alimentado pelo tratador " + this;
            desconto = this.getExperiencia() * 0.2;
            desconto = desconto > 40 ? 40 : desconto;
            Historico.adicionarAcontecimento(Acontecimentos.DESPESA, mesg, dia, mes, ano, Gerador.gerarNumero(40 - desconto, 80 - desconto));
        } else {

            mesg = "O animal " + animalDoente + " foi alimentado pelo tratador " + this;
            desconto = this.getExperiencia() * 0.2;
            desconto = desconto > 30 ? 30 : desconto;
            Historico.adicionarAcontecimento(Acontecimentos.DESPESA, mesg, dia, mes, ano, Gerador.gerarNumero(30 - desconto, 65 - desconto));
        }
    }
    
    @Override
    public void eleminar() {
        super.eleminar();
        numeroTratadores--;
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
        return numeroTratadores;
    }
    
    public static ArrayList<Tratador> getAllInstances(){
        return allInstancesCreated; 
    }
    
    public static void addInstanceToResgisto( Tratador instance ){  
        allInstancesCreated.add(instance);
    }
   
    public static void removeInstanceToRegisto( Tratador instance ){
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
