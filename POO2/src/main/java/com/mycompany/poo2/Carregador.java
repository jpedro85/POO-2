/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *  Oferece Métodos para caregar conteodos.
 */
public final class Carregador {

    public static final String FICHEIRO_GENES_ESPECIE = "SimuladorSaves/TodosGenesDeEspecie.txt";
    public static final String FICHEIRO_ESPECIES = "SimuladorSaves/TodosAsEspecies.txt";   
    public static final String FICHEIRO_GENES_AMBIENTE = "SimuladorSaves/TodosGenesDeAmbiente.txt";
    public static final String FICHEIRO_GENES_ATRATIVIDADE = "SimuladorSaves/TodosGenesDeAtratividade.txt";
    public static final String FICHEIRO_GENES_DIETA = "SimuladorSaves/TodosGenesDeDieta.txt";
    public static final String FICHEIRO_GENES_ESPECIFICOS = "SimuladorSaves/TodosGenesDeEspecifico.txt";
    public static final String FICHEIRO_GENES_LONGITIVIDADE = "SimuladorSaves/TodosGenesDeLongitividade.txt";
    public static final String FICHEIRO_GENES_REPRODUCAO = "SimuladorSaves/TodosGenesDeReproducao.txt";
    public static final String FICHEIRO_GENES_SEXO = "SimuladorSaves/TodosGenesDeSexo.txt";
    public static final String FICHEIRO_PESSOAS = "SimuladorSaves/Pessoas.txt";
    public static final String FICHEIRO_ANIMAIS = "SimuladorSaves/Animais.txt";
    public static final String FICHEIRO_EMPRESAS = "SimuladorSaves/Empresas.txt";
    
    //ficheiros do zoo.
    public static final String FICHEIRO_ZOONASCIDOS = "SimuladorSaves/ZooNascidos.txt";
    public static final String FICHEIRO_ZOOEMPREGADOS = "SimuladorSaves/ZooEmpregados.txt";
    public static final String FICHEIRO_ZOOSMILIVRES = "SimuladorSaves/ZooSmiLivres.txt";
    public static final String FICHEIRO_ZOOOBITUS = "SimuladorSaves/ZooObitus.txt";
    public static final String FICHEIRO_ZOOINSTALACOES = "SimuladorSaves/ZooInstalacoes.txt";
    public static final String FICHEIRO_ZOOHISTORICO = "SimuladorSaves/ZooHistorico.txt";
    
    private Carregador() {
    }
    
    public static <T> void carrega(Class<T> cclass, String ficheiro) {
                
        System.out.println("A carregar o ficheiro: " + ficheiro);
        int errors=0;
        try {
            
            FileReader rW = new FileReader(ficheiro);
            BufferedReader bW = new BufferedReader(rW);
            String linha = bW.readLine();
            int contador=0;
            
            while(linha!=null) {
                contador++;
                try {

                    T a = cclass.getConstructor(FormatedString.class).newInstance(new FormatedString(linha));
                    Registo<T> b = (Registo<T>) a;
                    b.addInstanceAoResgisto();

                } catch (RepresentacaoInvalidaDoTipo exp1) {
                    System.out.println(exp1);
                } catch (Exception expall) {//porque usamos a class construct nao é apanhada a exceccao representacaodotipo do construtor da class:Illegal access
                    System.out.print("Item não carregado!! ");
                    System.out.println("Na linha "+contador+" do ficheiro");
                    System.out.println(RepresentacaoInvalidaDoTipo.getUltimaExcecao().getMessage());
                }
                linha=bW.readLine();
            }
            bW.close();
            rW.close();
            
            System.out.println("O ficheiro foi carregado com " + errors + " erros !\n");
        
        } catch (IOException e) {
            System.out.println("Não foi possivel abrir o ficheiro: "+ficheiro);
            errors++;
        }
    }
    
    public static void carregarStringS(String ficheiro,ArrayList<String> array){
        
        if (array.isEmpty()) 
            array.clear();
        
        System.out.println("A carregar o ficheiro: " + ficheiro);
        int errors=0;
        try {
            
            FileReader rW = new FileReader(ficheiro);
            BufferedReader bW = new BufferedReader(rW);
            String linha = bW.readLine();

            while(linha!=null) {
                
                array.add(linha);
                linha=bW.readLine();
            }
            bW.close();
            rW.close();
            
            System.out.println("O ficheiro foi carregado com " + errors + " erros !\n");
            
        } catch (IOException e) {
            System.out.println("Não foi possivel abrir o ficheiro: "+ficheiro);
            errors++;
        }
    }
    
    public static void carregarFicheiros(){
        
        if(!Especie.getAllInstances().isEmpty())
            Especie.getAllInstances().clear();
        Carregador.carrega(Especie.class, Carregador.FICHEIRO_ESPECIES);
        
        if(!GeneEspecie.getAllInstances().isEmpty())
            GeneEspecie.getAllInstances().clear();
        Carregador.carrega(GeneEspecie.class, Carregador.FICHEIRO_GENES_ESPECIE); 
        
        if(!GeneAmbiente.getAllInstances().isEmpty())
            GeneAmbiente.getAllInstances().clear();
        Carregador.carrega(GeneAmbiente.class, FICHEIRO_GENES_AMBIENTE);
        
        if(!GeneAtratividade.getAllInstances().isEmpty())
            GeneAtratividade.getAllInstances().clear();
        Carregador.carrega(GeneAtratividade.class, FICHEIRO_GENES_ATRATIVIDADE);
        
        if(!GeneDieta.getAllInstances().isEmpty())
            GeneDieta.getAllInstances().clear();
        Carregador.carrega(GeneDieta.class, FICHEIRO_GENES_DIETA); 
        
        if(!GeneEspecifico.getAllInstances().isEmpty())
            GeneEspecifico.getAllInstances().clear();
        Carregador.carrega(GeneEspecifico.class, FICHEIRO_GENES_ESPECIFICOS);
        
        if(!GeneLongividade.getAllInstances().isEmpty())
            GeneLongividade.getAllInstances().clear();
        Carregador.carrega(GeneLongividade.class, FICHEIRO_GENES_LONGITIVIDADE);
        
        if(!GeneRepoducao.getAllInstances().isEmpty())
            GeneRepoducao.getAllInstances().clear();
        Carregador.carrega(GeneRepoducao.class, FICHEIRO_GENES_REPRODUCAO);
        
        if(!GeneSexo.getAllInstances().isEmpty())
            GeneSexo.getAllInstances().clear();
        Carregador.carrega(GeneSexo.class, FICHEIRO_GENES_SEXO);
        
        carregarStringS(Carregador.FICHEIRO_PESSOAS,Gerador.getPessoas());
        carregarStringS(Carregador.FICHEIRO_ANIMAIS,Gerador.getNomesArtisticos());
        carregarStringS(Carregador.FICHEIRO_EMPRESAS,Gerador.getEmpreiteiras());
        
    }
    
    public static void carregarZoo(){
        
        carregarHistorico();
        carregarInstalações();
        carregarNascidos();
        carregarSmilivres();
        carregarObitus();
        carregarEmpregados();
        
        if (!Historico.getAcontecimentos().isEmpty()){
            Historico.Acontecimento acont = null;
            int count = 0;
            int size = Historico.getAcontecimentos().size();
            for (Historico.Acontecimento acontecimento : Historico.getAcontecimentos()) {
                
                if (count == size-1) {
                    acont = acontecimento;
                }
                count++;
            }
            
            if (acont != null) {
               
                Simulador.setDiaCorrente(acont.getDia());
                Simulador.setAnoCorrente(acont.getAno());
                Simulador.setMesCorrente(acont.getMes());
            }
        }
            
    }
    
    private static void carregarHistorico(){
        
        if (!Historico.getAcontecimentos().isEmpty()) 
            Historico.getAcontecimentos().clear();
        
        System.out.println("A carregar o ficheiro: " + FICHEIRO_ZOOHISTORICO);
        int errors=0;
        try {
            
            FileReader rW = new FileReader(FICHEIRO_ZOOHISTORICO);
            BufferedReader bW = new BufferedReader(rW);
            
            String linha = bW.readLine();
            
            FormatedString fstr;
            while(linha!=null) {

                try {
                    fstr = new FormatedString(linha);
                    Historico.adicionarAcontecimento(fstr);
                    
                }catch(RepresentacaoInvalidaDoTipo e){
                    System.out.println(e.getMessage());
                    errors++;
                }
                
                linha = bW.readLine();
            }
            bW.close();
            rW.close();
            
            System.out.println("O ficheiro foi carregado com " + errors + " erros !\n");
            
        } catch (IOException e) {
            System.out.println("Não foi possivel abrir o ficheiro: "+ FICHEIRO_ZOOHISTORICO +"\n");
            errors++;
        }
    } 
    
    
    private static void carregarInstalações(){
        
        if (!Zoo.getAllInstalacoes().isEmpty()) 
            Zoo.getAllInstalacoes().clear();
        
        System.out.println("A carregar o ficheiro: " + FICHEIRO_ZOOINSTALACOES);
        int errors=0;
        try {
            
            FileReader rW = new FileReader(FICHEIRO_ZOOINSTALACOES);
            BufferedReader bW = new BufferedReader(rW);
            
            String linha = bW.readLine();
            
            FormatedString fstr;
            Instalacao instalacao;
            while(linha!=null) {
                
                try {
                    fstr = new FormatedString(linha);
                    instalacao = new Instalacao(fstr);
                    Zoo.getAllInstalacoes().add(instalacao);
                   
                }catch(RepresentacaoInvalidaDoTipo e){
                    System.out.println(e.getMessage());
                    errors++;
                }
                
                linha = bW.readLine();
            }
            bW.close();
            rW.close();
            
            System.out.println("O ficheiro foi carregado com " + errors + " erros !\n");
            
        } catch (IOException e) {
            System.out.println("Não foi possivel abrir o ficheiro: "+ FICHEIRO_ZOOINSTALACOES +"\n");
            errors++;
        }
    }
    
    private static void carregarNascidos(){
        
        if(!Zoo.getAllNascimentos().isEmpty())
            Zoo.getAllNascimentos().clear();
        
        System.out.println("A carregar o ficheiro: " + FICHEIRO_ZOONASCIDOS);
        int errors=0;
        try {
            
            FileReader rW = new FileReader(FICHEIRO_ZOONASCIDOS);
            BufferedReader bW = new BufferedReader(rW);
            
            String linha = bW.readLine();
            
            FormatedString fstr;
            Animal animal;
            while(linha!=null) {
                
                try {
                    fstr = new FormatedString(linha);
                    animal = new Animal(fstr);
                    Zoo.getAllNascimentos().add(animal);
                   
                }catch(RepresentacaoInvalidaDoTipo e){
                    System.out.println(e.getMessage());
                    errors++;
                }
                
                linha = bW.readLine();
            }
            bW.close();
            rW.close();
            
            System.out.println("O ficheiro foi carregado com " + errors + " erros !\n");
            
        } catch (IOException e) {
            System.out.println("Não foi possivel abrir o ficheiro: "+ FICHEIRO_ZOONASCIDOS+"\n");
            errors++;
        }
    }
    
    private static void carregarSmilivres(){
        
        if(!Zoo.getAllSemiLivres().isEmpty())
            Zoo.getAllSemiLivres().clear();
        
        System.out.println("A carregar o ficheiro: " + FICHEIRO_ZOOSMILIVRES);
        int errors=0;
        try {
            
            FileReader rW = new FileReader(FICHEIRO_ZOOSMILIVRES);
            BufferedReader bW = new BufferedReader(rW);
            
            String linha = bW.readLine();
            
            FormatedString fstr;
            Animal animal;
            Instalacao inst;
            while(linha!=null) {
                
                try {
                    
                    
                    fstr = new FormatedString(linha.substring(0,linha.indexOf("|")));
                    animal = new Animal(fstr);
                    fstr = new FormatedString(linha.substring(linha.indexOf("|")+1));
                    inst = new Instalacao(fstr);
                    Zoo.getAllSemiLivres().put(animal,inst);
                   
                }catch(RepresentacaoInvalidaDoTipo e){
                    System.out.println(e.getMessage());
                    errors++;
                }
                
                linha = bW.readLine();
            }
            bW.close();
            rW.close();
            
            System.out.println("O ficheiro foi carregado com " + errors + " erros !\n");
            
        } catch (IOException e) {
            System.out.println("Não foi possivel abrir o ficheiro: "+ FICHEIRO_ZOOSMILIVRES+"\n");
            errors++;
        }
    }
    
    private static void carregarObitus(){
        
        if(!Zoo.getAllObitos().isEmpty())
            Zoo.getAllObitos().clear();
        
        System.out.println("A carregar o ficheiro: " + FICHEIRO_ZOOOBITUS);
        int errors=0;
        try {
            
            FileReader rW = new FileReader(FICHEIRO_ZOOOBITUS);
            BufferedReader bW = new BufferedReader(rW);
            String linha = bW.readLine();
            
            FormatedString fstr;
            Animal animal;
            while(linha!=null) {
                
                try {
                    fstr = new FormatedString(linha);
                    animal = new Animal(fstr);
                    Zoo.getAllObitos().add(animal);
                   
                }catch(RepresentacaoInvalidaDoTipo e){
                    System.out.println(e.getMessage());
                    errors++;
                }
                
                linha = bW.readLine();
            }
            bW.close();
            rW.close();
            
            System.out.println("O ficheiro foi carregado com " + errors + " erros !\n");
            
        } catch (IOException e) {
            System.out.println("Não foi possivel abrir o ficheiro: "+ FICHEIRO_ZOOOBITUS+"\n");
            errors++;
        }
    }
    
    private static void carregarEmpregados(){
        
        if (!Zoo.getAllEmpregados().isEmpty()) 
            Zoo.getAllEmpregados().clear();
        
        System.out.println("A carregar o ficheiro: " + FICHEIRO_ZOOEMPREGADOS);
        int errors=0;
        try {
            
            FileReader rW = new FileReader(FICHEIRO_ZOOEMPREGADOS);
            BufferedReader bW = new BufferedReader(rW);
            String linha = bW.readLine();
            
            FormatedString fstr;
            Empregado empregado;
            while(linha!=null) {
                
                try {
                    fstr = new FormatedString(linha);
                    
                    if(fstr.getTipo().equals(Tratador.class.getSimpleName()))
                        empregado = new Tratador(fstr);
                    else if(fstr.getTipo().equals(Zelador.class.getSimpleName()))
                        empregado = new Zelador(fstr);
                    else if (fstr.getTipo().equals(Veterinario.class.getSimpleName())) 
                        empregado = new Veterinario(fstr);
                    else
                        throw new RepresentacaoInvalidaDoTipo(fstr + "não representa nehum tipo de empregado.");
                            
                    Zoo.getAllEmpregados().add(empregado);
                   
                }catch(RepresentacaoInvalidaDoTipo e){
                    System.out.println(e.getMessage());
                    errors++;
                }
                
                linha = bW.readLine();
            }
            bW.close();
            rW.close();
            
            System.out.println("O ficheiro foi carregado com " + errors + " erros !\n");
            
        } catch (IOException e) {
            System.out.println("Não foi possivel abrir o ficheiro: "+ FICHEIRO_ZOOEMPREGADOS+"\n");
            errors++;
        }
    }
}
