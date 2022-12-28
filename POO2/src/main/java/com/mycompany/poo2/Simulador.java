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
    private static boolean jumangi;
    
    private Simulador(){}

    public static boolean isJumangi() {
        return jumangi;
    }

    public static void setJumangi(boolean jumangi) {
        Simulador.jumangi = jumangi;
    }

    public static void setAnoCorrente(int anoCorrente) {
        Simulador.anoCorrente = anoCorrente;
    }

    public static void setDiaCorrente(int diaCorrente) {
        Simulador.diaCorrente = diaCorrente;
    }

    public static void setMesCorrente(Meses mesCorrente) {
        Simulador.mesCorrente = mesCorrente;
    }
    
    public static int getAnoCorrente() {
        return anoCorrente;
    }

    public static int getDiaCorrente() {
        return diaCorrente;
    }

    public static Meses getMesCorrente() {
        return mesCorrente;
    }
    
    public static void simularDia() {
        
    
        
    }
     
    private static void simularDiaIstalacao(){ // ainmais e instalacao
        
        ArrayList<Instalacao> instalacoes = Zoo.getAllInstalacoes();
        ArrayList<Animal> todosAnimais;
        
        for (Instalacao inst : instalacoes) {
            
            todosAnimais = inst.getAnimaisSaudaveis();
            
            for (Animal animalSuadavel : todosAnimais) {
                                
                //ver se moorre
                TipoMorte morte = animalSuadavel.morre();
                if( morte != null){
                    
                    inst.ocoreuMorte();
                    Zoo.getAllObitos().add(animalSuadavel);
                    Historico.adicionarAcontecimento(Acontecimentos.OBITO, "O Animal:" + animalSuadavel + "morreu de " + morte + ".", diaCorrente, mesCorrente, anoCorrente);
                
                } else {
                    
                    //ver se fica doente
                    if( animalSuadavel.ficaDoente(inst)){
                        inst.getAnimaisSaudaveis().remove(animalSuadavel);
                        inst.getAnimaisDoentes().add(animalSuadavel);
                    }
                    
                    //ver se foge
                    if(animalSuadavel.foge(inst,jumangi)){
                        
                        inst.ocoreuFuga();
                        inst.getAnimaisSaudaveis().remove(animalSuadavel);
                        Zoo.getAllSemiLivres().put(animalSuadavel,inst);
                        Historico.adicionarAcontecimento(Acontecimentos.FUGAANIMAL, "O Animal:" + animalSuadavel + "Fugio da instalacao " + inst + ".", diaCorrente, mesCorrente, anoCorrente);

                    }else{
                        
                        //ver se repruduz
                        Animal novo = null;
                        for (Animal animal : inst.getAnimaisSaudaveis() ) {

                            novo = animalSuadavel.reproduzir(animal);
                            if(novo != null) break;
                        }

                        if ( novo == null) {

                            for (Animal animal : inst.getAnimaisDoentes() ) {

                                novo = animalSuadavel.reproduzir(animal);
                                if(novo != null) break;

                            }
                        }

                        if (novo != null){
                            Zoo.getAllNascimentos().add(novo);
                            Historico.adicionarAcontecimento(Acontecimentos.NASCIMENTO, "O Animal:" + novo + "nasceu.", diaCorrente, mesCorrente, anoCorrente);
                        }
                        
                        //envelhecer
                        animalSuadavel.envelhecer();
                    }
                }
            }
            
            todosAnimais = inst.getAnimaisDoentes();
            
            for (Animal animalDoente : todosAnimais) {
                
                 //ver se moorre
                TipoMorte morte = animalDoente.morre();
                if( morte != null){
                    
                    inst.ocoreuMorte();
                    Zoo.getAllObitos().add(animalDoente);
                    Historico.adicionarAcontecimento(Acontecimentos.OBITO, "O Animal:" + animalDoente + "morreu de " + morte + "." , diaCorrente, mesCorrente, anoCorrente);
                
                } else {
                    
                    //ver se foge
                    if(animalDoente.foge(inst,jumangi)){
                        
                        inst.ocoreuFuga();
                        inst.getAnimaisDoentes().remove(animalDoente);
                        Zoo.getAllSemiLivres().put(animalDoente,inst);
                        Historico.adicionarAcontecimento(Acontecimentos.FUGAANIMAL, "O Animal:" + animalDoente + "Fugio da instalacao " + inst + ".", diaCorrente, mesCorrente, anoCorrente);

                    }else{
                        
                        //ver se repruduz
                        Animal novo = null;
                        for (Animal animal : inst.getAnimaisSaudaveis() ) {

                            novo = animalDoente.reproduzir(animal);
                            if(novo != null) break;
                        }

                        if ( novo == null) {

                            for (Animal animal : inst.getAnimaisDoentes() ) {

                                novo = animalDoente.reproduzir(animal);
                                if(novo != null) break;
                            } 
                        }

                        if (novo != null){
                            Zoo.getAllNascimentos().add(novo);
                            Historico.adicionarAcontecimento(Acontecimentos.NASCIMENTO, "O Animal:" + novo + "nasceu.", diaCorrente, mesCorrente, anoCorrente);
                        }
                        
                    }
                    
                    //envelhecer
                    animalDoente.envelhecer();
                }
            }
            
            inst.desgaste();    
        }
    }
    
    private static int simuladorDiaTratador(Tratador tratador,int ultima){
        
        int i = ultima;
        for (; i < tratador.getMaxTarefas() && i< Zoo.getAllInstalacoes().size() ; i++) {
            tratador.trabalhar(Zoo.getAllInstalacoes().get(i),diaCorrente,mesCorrente,anoCorrente);
        }
        return i;
    }
    
    private static int simuladorDiaZelador(Zelador zelador,int ultima,int tarefasPorZelador){
        
        int i = ultima;
        for ( ; i < tarefasPorZelador && i < zelador.getMaxTarefas() && i< Zoo.getAllInstalacoes().size() ; i++) {
            zelador.trabalhar(Zoo.getAllInstalacoes().get(i),diaCorrente,mesCorrente,anoCorrente);
        }
        return i;
    }
    
    private static int simuladorDiaVeterinario(Veterinario veterinario ,int ultima ,int tarefasPorVeterinario){
        
        int i = ultima;
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
        
        int totalDoentes= 0,tarefasPorVeterinario = 0;
        for (Instalacao instalacao : Zoo.getAllInstalacoes()) {  
            totalDoentes += instalacao.getAnimaisDoentes().size();
        }
        
        if ( (totalDoentes / Veterinario.getQuantidade())%1.0 == 0){ 
            tarefasPorVeterinario = totalDoentes / Veterinario.getQuantidade();
        }else{
            tarefasPorVeterinario = (totalDoentes / Veterinario.getQuantidade()) + 1;
        }
        
        int ultimaManunecao=0 ,ultimaTrtacao=0, ultimaCura=0;
        for (Empregado empregado:Zoo.getAllEmpregados()) {
            
            if( empregado.getClass().getSimpleName().equals(Zelador.class.getSimpleName()) ){
                ultimaManunecao = simuladorDiaZelador((Zelador)empregado,ultimaManunecao,tarefasPorZelador);
            }
            
            if ( empregado.getClass().getSimpleName().equals(Veterinario.class.getSimpleName())) {  
                ultimaCura += simuladorDiaVeterinario((Veterinario)empregado,ultimaCura,tarefasPorVeterinario);  
            }
            
            if ( empregado.getClass().getSimpleName().equals(Tratador.class.getSimpleName())) {                
                ultimaTrtacao = simuladorDiaTratador((Tratador)empregado,ultimaTrtacao);
            }
            
        }
        
    } 
    
    private static void simularDiaClientes(){
        
        ArrayList<Cliente> clientes = criarClientesDoDia();
        
        double dinheiroOferecido = 0;
        for (Cliente cliente: clientes) {
            
            Historico.adicionarAcontecimento(Acontecimentos.LUCRO, "Entrada paga cliente " + cliente , diaCorrente, mesCorrente, anoCorrente ,cliente.pagar(Zoo.getEntrada()));
            
            for (Instalacao instalacao : Zoo.getAllInstalacoes()) {
                
                for (Animal animal: instalacao.getAnimaisTodos()) {
                
                    dinheiroOferecido = cliente.oferecerDinheiro(animal);
                    if (dinheiroOferecido == 0) 
                        Historico.adicionarAcontecimento(Acontecimentos.LUCRO, "O cliente " + cliente + " ofereceu dinheiro ao animal " + animal, diaCorrente, mesCorrente, anoCorrente);
                }
            }
        }
        
    } 
    
    
    private static ArrayList<Cliente> criarClientesDoDia(){
        
        int nClienets = Gerador.gerarNumero(100, 199);
        ArrayList<Cliente> clientes = new ArrayList<>(nClienets);
        
        String nome;
        int nif,idade,generozidade,interece;
        double salto;
        
        for (int i = 0; i < nClienets; i++) {
            
            nome = Gerador.getPessoas().get(Gerador.gerarNumero(0,Gerador.getPessoas().size() ));
            nif = Gerador.gerarNIF();
            idade = Gerador.gerarNumero(1, 120);
            generozidade = Gerador.gerarNumero(0, 99);
            salto = Gerador.gerarNumero(100.0, 3000.0);
            interece = Gerador.gerarNumero(0, 100);
            
            clientes.add(new Cliente(nome,nif,idade,salto,generozidade,interece));
            
        }
        
        return clientes;
    }
            
}
