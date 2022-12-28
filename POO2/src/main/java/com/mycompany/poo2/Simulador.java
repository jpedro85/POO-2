/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.ArrayList;

/**
 *
 * @author Francisco MSI
 */
public final class Simulador {
    
    private static int anoCorrente = 0;
    private static int diaCorrente = 0;
    private static Meses mesCorrente = Meses.JANEIRO;
    
    private Simulador(){}
    
    public static void simularDia() {
        
    
        
    }
    
    
    
        /*
- simularDiaFuncionarios() : void 
- simularDiaClientes() : void*/
    
    
    
    public static int getAnoCorrente() {
        return anoCorrente;
    }

    public static int getDiaCorrente() {
        return diaCorrente;
    }

    public static Meses getMesCorrente() {
        return mesCorrente;
    }
    
    private static void simularDiaIstalacao(){ // ainmais e instalacao
        
        ArrayList<Instalacao> instalacoes = Zoo.getAllInstalacoes();
        ArrayList<Animal> todosAnimais;
        
        for (Instalacao inst : instalacoes) {
            
            todosAnimais = inst.getAnimais().get("Saudaveis");
            
            for (Animal animalSuadavel : todosAnimais) {
                
                
                TipoMorte morte = animalSuadavel.morre();
                if( morte != null){
                    
                    Zoo.getAllObitos().add(animalSuadavel);
                    Historico.adicionarAcontecimento(Acontecimentos.OBITO, "O Animal:" + animalSuadavel + "morreu de " + morte + ".", diaCorrente, mesCorrente, anoCorrente);
                
                } else {
                
                    if( animalSuadavel.ficaDoente(inst)){
                        inst.getAnimais().get("Saudaveis").remove(animalSuadavel);
                        inst.getAnimais().get("Doentes").add(animalSuadavel);
                    }
                    
                    Animal novo = null;
                    for (Animal animal : inst.getAnimais().get("Saudaveis") ) {
                        
                        novo = animalSuadavel.reproduzir(animal);
                        if(novo != null) break;
                    }
                    
                    if ( novo == null) {
                        
                        for (Animal animal : inst.getAnimais().get("Doentes") ) {
                        
                            novo = animalSuadavel.reproduzir(animal);
                            if(novo != null) break;

                        }
                    }
                    
                    if (novo != null){
                        Zoo.getAllNascimentos().add(novo);
                        Historico.adicionarAcontecimento(Acontecimentos.NASCIMENTO, "O Animal:" + novo + "nasceu.", diaCorrente, mesCorrente, anoCorrente);
                    }
                }
            }
            
            todosAnimais = inst.getAnimais().get("Doentes");
            
            for (Animal animalDoente : todosAnimais) {
                
                TipoMorte morte = animalDoente.morre();
                if( morte != null){
                    
                    Zoo.getAllObitos().add(animalDoente);
                    Historico.adicionarAcontecimento(Acontecimentos.OBITO, "O Animal:" + animalDoente + "morreu de " + morte + "." , diaCorrente, mesCorrente, anoCorrente);
                
                } else {
                
                    Animal novo = null;
                    for (Animal animal : inst.getAnimais().get("Saudaveis") ) {
                        
                        novo = animalDoente.reproduzir(animal);
                        if(novo != null) break;
                    }
                    
                    if ( novo == null) {
                        
                        for (Animal animal : inst.getAnimais().get("Doentes") ) {
                        
                            novo = animalDoente.reproduzir(animal);
                            if(novo != null) break;
                        } 
                    }
                    
                    if (novo != null){
                        Zoo.getAllNascimentos().add(novo);
                        Historico.adicionarAcontecimento(Acontecimentos.NASCIMENTO, "O Animal:" + novo + "nasceu.", diaCorrente, mesCorrente, anoCorrente);
                    }
                }
            }
            
            inst.desgaste();
            
        }
    }
    
    private static int simuladorDiaTratador(Tratador tratador){
        
        int i =0 , tarefas = 0;
        for (; i < tratador.getMaxTarefas() && i< Zoo.getAllInstalacoes().size() ; i++) {
            tratador.trabalhar(Zoo.getAllInstalacoes().get(i),diaCorrente,mesCorrente,anoCorrente);
            tarefas++;//corrigir
        }
        return i;
    }
    
    private static void simuladorDiaZelador(Zelador zelador,int tarefasPorZelador){
        
        for (int i = 0; i < tarefasPorZelador && i < zelador.getMaxTarefas() && i< Zoo.getAllInstalacoes().size() ; i++) {
            zelador.trabalhar(Zoo.getAllInstalacoes().get(i),diaCorrente,mesCorrente,anoCorrente);
        }
    }
    
    private static int simuladorDiaVeterinario(Veterinario veterinario ,int tarefasPorVeterinario){
        
        int i = 0;
        for ( ; i < tarefasPorVeterinario && i < veterinario.getMaxTarefas() && i< Zoo.getAllInstalacoes().size() ; i++) {

            veterinario.trabalhar(Zoo.getAllInstalacoes().get(i),diaCorrente,mesCorrente,anoCorrente);
        }
        
        return i;
        
    }
    
    private static void simularDiaFuncionarios(){
    
        int tarefasPorZelador;
        if ( (Zoo.getAllInstalacoes().size() / Zelador.getQuantidade())%1.0 == 0){ 
            tarefasPorZelador = Zoo.getAllInstalacoes().size() / Zelador.getQuantidade();
        }else{
            tarefasPorZelador = (Zoo.getAllInstalacoes().size() / Zelador.getQuantidade()) + 1;
        }
        
        
        int totalDoentes= 0;
        for (Instalacao instalacao : Zoo.getAllInstalacoes()) {  
            totalDoentes += instalacao.getAnimais().get("Doentes").size();
        }
        
        
        int tarefasPorVeterinario = 0;
        if ( (totalDoentes / Veterinario.getQuantidade())%1.0 == 0){ 
            tarefasPorVeterinario = totalDoentes / Veterinario.getQuantidade();
        }else{
            tarefasPorVeterinario = (totalDoentes / Veterinario.getQuantidade()) + 1;
        }
        
        int totaldeAnimisTratados = 0;
        

        for (Empregado empregado:Zoo.getAllEmpregados()) {
            
            if( empregado.getClass().getSimpleName().equals(Zelador.class.getSimpleName()) ){

                simuladorDiaZelador((Zelador)empregado,tarefasPorZelador);
            }
            
            if ( empregado.getClass().getSimpleName().equals(Veterinario.class.getSimpleName())) {
                
                totaldeAnimisTratados += simuladorDiaVeterinario((Veterinario)empregado,tarefasPorVeterinario);
                
            }
            
            if ( empregado.getClass().getSimpleName().equals(Tratador.class.getSimpleName())) {
                
                //tarefasNoDia+=simuladorDiaVeterinario((Veterinario)empregado,tarefasPorVeterinario);
                
            }
            
        }
        
        if (totalDoentes != totaldeAnimisTratados) 
            Historico.adicionarAcontecimento(Acontecimentos.INFO, "Ficaram animais por tratar Falta funcionários ou mais carga por funcionário.", diaCorrente, mesCorrente, anoCorrente);
            
        
    
    } 
            
}
