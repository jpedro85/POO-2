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
public final class MenuAnimal extends Menu {

    private final int MAXOPTN = 8;

    public MenuAnimal(Menu menu) {
        super(menu);
    }

    @Override
    public void mostrarOpcoes() {
        String optn = "";
        optn = """
                (1) -> Listar Animais
                (2) -> Listar Animais Mutados
                (3) -> Listar Animais Com O Gene
                (4) -> Abater 
                (5) -> Libertar
                (6) -> Adequirir
                (7) -> Vender 
                (8) -> Realocar
                
                (0) -> Voltar Atraz""";
        this.mostrarOpcoes("=================================== Menu Gerir Animais ===================================", optn);
    }

    @Override
    public void executarOpcao(int optn) {
        switch (optn) {
            case 0:
                this.voltarAtraz();
                break;
            case 1:
                this.listarAnimais(false);
                this.pedirContinuar();
                break;
            case 2:
                this.listarAnimais(true);
                break;
            case 3:
                this.listarAnimaisComGene();
                break;
            case 4 :
                this.abaterAnimal();
                break;
            case 5 :
                this.libertarAnimal();
                break;
            case 6 :
                this.adequirirAnimal();
                break;
            case 7:
                this.venderAnimal();
                break;
            case 8:
                this.realocarAnimal();
                break;
        }
    }
     
    private void adequirirAnimal(){
        
        ArrayList<Animal> animais = new ArrayList<>(3);
        
        int contador =0;
        Animal animalGerado;
        for (; contador < 3; contador++) {
            animalGerado = Gerador.gerarAnimal();
            animais.add(animalGerado);
            System.out.println("(" + contador + ") -> " + animalGerado + "\n preco: " + Gerador.gerarValorAnimal(animalGerado) + "\n");
        }
        
        animalGerado = animais.get(this.pedirOpcao(contador-1) );
        Zoo.getAllNascimentos().add(animalGerado);
        System.out.println("O Animal: " + animalGerado + "Foi comprado !");
        Historico.adicionarAcontecimento(Acontecimentos.DESPESA, "O Animal: " + animalGerado.getNomeArtistico() + " id: "+ animalGerado.getId() + " Foi comprado", Simulador.getDiaCorrente(),Simulador.getMesCorrente(),Simulador.getAnoCorrente());
        
        this.pedirContinuar();
    }
    
    private void listarAnimaisComGene(){
        
        if (Zoo.getAllInstalacoes().isEmpty()) {
            System.out.println("O Zoo não tem Animis !");
            this.pedirContinuar();
        } else {
            
            Gene gene = this.pedirGene();
           
            if (gene != null) {
                boolean temAnimais = false;
                for (Instalacao instalacao : Zoo.getAllInstalacoes()) {

                    if (instalacao.getOcupacao() != 0) {

                        temAnimais = true;

                        for (Animal animal : instalacao.getAnimaisTodos()) {
                            if (animal.getGenoma().contemGene(gene)) {
                                System.out.println(animal + "\n");
                            }

                        }
                    }

                }

                if (!temAnimais) {
                    System.out.println("O Zoo não tem Animis !");
                }

            }
            
            this.pedirContinuar();
            
        }
        
    }
    
    public void abaterAnimal(){
        
        System.out.println(" (0) Escolher Animal das Instalações.");
        System.out.println(" (1) Escolher Animal dos Nascimentos.");
        Animal abater;
        int optn  = this.pedirOpcao(1);
        
        if (optn == 0) {

            Instalacao instalacao = this.pedirInstalacao();

            if (instalacao != null) {

                int contador = 0;

                for (Animal animal : instalacao.getAnimaisDoentes()) {
                    System.out.println(" (" + contador + ") " + animal);
                    contador++;
                }

                for (Animal animal : instalacao.getAnimaisSaudaveis()) {

                    System.out.println(" (" + contador + ") " + animal);
                    contador++;
                }

                if (contador == 0) {
                    System.out.println("A instalação " + instalacao.getNome() + "não tem animais !");

                } else {

                    optn = this.pedirOpcao(contador - 2);

                    if (optn < instalacao.getAnimaisDoentes().size()) {
                        abater = instalacao.getAnimaisDoentes().get(optn);
                        instalacao.getAnimaisDoentes().remove(optn);
                    } else {
                        abater = instalacao.getAnimaisSaudaveis().get(optn - instalacao.getAnimaisDoentes().size() - 1);
                        instalacao.getAnimaisSaudaveis().remove(optn - instalacao.getAnimaisDoentes().size() - 1);
                    }
                    
                    Zoo.getAllObitos().add(abater);
                    System.out.println("O Animal " + abater + " foi Abatido.");
                    Historico.adicionarAcontecimento(Acontecimentos.OBITO,"O Animal " + abater.getNomeArtistico() + " id: " + abater.getId() + " foi Abatido.", Simulador.getDiaCorrente(),Simulador.getMesCorrente(),Simulador.getAnoCorrente());

                }
            }
            
        } else {

            int contador = 0;

            for (Animal animal : Zoo.getAllNascimentos()) {
                System.out.println(" (" + contador + ") " + animal);
                contador++;
            }

            if (contador == 0) {

                System.out.println("não tem animais nos nascidos!");

            } else {

                abater = Zoo.getAllNascimentos().get(this.pedirOpcao(contador - 1));
               
                Zoo.getAllObitos().add(abater);
                Zoo.getAllNascimentos().remove(abater);
                System.out.println("O Animal " + abater + " foi Abatido.");
                Historico.adicionarAcontecimento(Acontecimentos.OBITO,"O Animal " + abater.getNomeArtistico() + " id: " + abater.getId() + " foi Abatido.", Simulador.getDiaCorrente(),Simulador.getMesCorrente(),Simulador.getAnoCorrente());

            }
        }
            
        this.pedirContinuar();
        
    }
    
     public void libertarAnimal(){
        
        System.out.println(" (0) Escolher Animal das Instalações.");
        System.out.println(" (1) Escolher Animal dos Nascimentos.");
        Animal libertar;
        int optn  = this.pedirOpcao(1);
        
        if (optn == 0) {

            Instalacao instalacao = this.pedirInstalacao();

            if (instalacao != null) {

                int contador = 0;

                for (Animal animal : instalacao.getAnimaisDoentes()) {
                    System.out.println(" (" + contador + ") " + animal);
                    contador++;
                }

                for (Animal animal : instalacao.getAnimaisSaudaveis()) {

                    System.out.println(" (" + contador + ") " + animal);
                    contador++;
                }

                if (contador == 0) {
                    System.out.println("A instalação " + instalacao.getNome() + "não tem animais !");

                } else {

                    optn = this.pedirOpcao(contador - 2);

                    if (optn < instalacao.getAnimaisDoentes().size()) {
                        libertar = instalacao.getAnimaisDoentes().get(optn);
                        instalacao.getAnimaisDoentes().remove(optn);
                    } else {
                        libertar = instalacao.getAnimaisSaudaveis().get(optn - instalacao.getAnimaisDoentes().size() - 1);
                        instalacao.getAnimaisSaudaveis().remove(optn - instalacao.getAnimaisDoentes().size() - 1);
                    }
                    
                    System.out.println("O Animal " + libertar + " foi libertado.");
                    Historico.adicionarAcontecimento(Acontecimentos.LIBERTADO,"O Animal " + libertar.getNomeArtistico() + " id: " + libertar.getId() + " foi Libertado.", Simulador.getDiaCorrente(),Simulador.getMesCorrente(),Simulador.getAnoCorrente());

                }
            }
            
        } else {

            int contador = 0;

            for (Animal animal : Zoo.getAllNascimentos()) {
                System.out.println(" (" + contador + ") " + animal);
                contador++;
            }

            if (contador == 0) {

                System.out.println("não tem animais nos nascidos!");

            } else {

                libertar = Zoo.getAllNascimentos().get(this.pedirOpcao(contador - 1));
                Zoo.getAllNascimentos().remove(libertar);
                
                System.out.println("O Animal " + libertar + " foi libertado.");
                Historico.adicionarAcontecimento(Acontecimentos.LIBERTADO,"O Animal " + libertar.getNomeArtistico() + " id: " + libertar.getId() + " foi Libertado.", Simulador.getDiaCorrente(),Simulador.getMesCorrente(),Simulador.getAnoCorrente());

            }
        }
            
        this.pedirContinuar();
        
    }

    private void venderAnimal(){
        
        System.out.println(" (0) Escolher Animal das Instalações.");
        System.out.println(" (1) Escolher Animal dos Nascimentos.");
        Animal vender;
        int optn  = this.pedirOpcao(1);
        
        if (optn == 0) {

            Instalacao instalacao = this.pedirInstalacao();

            if (instalacao != null) {

                int contador = 0;

                for (Animal animal : instalacao.getAnimaisDoentes()) {
                    System.out.println(" (" + contador + ") " + animal);
                    contador++;
                }

                for (Animal animal : instalacao.getAnimaisSaudaveis()) {

                    System.out.println(" (" + contador + ") " + animal);
                    contador++;
                }

                if (contador == 0) {
                    System.out.println("A instalação " + instalacao.getNome() + "não tem animais !");

                } else {

                    optn = this.pedirOpcao(contador - 2);

                    if (optn < instalacao.getAnimaisDoentes().size()) {
                        vender = instalacao.getAnimaisDoentes().get(optn);
                        instalacao.getAnimaisDoentes().remove(optn);
                    } else {
                        vender = instalacao.getAnimaisSaudaveis().get(optn - instalacao.getAnimaisDoentes().size() - 1);
                        instalacao.getAnimaisSaudaveis().remove(optn - instalacao.getAnimaisDoentes().size() - 1);
                    }
                    

                    System.out.println("O Animal " + vender + " foi vendido.");
                    Historico.adicionarAcontecimento(Acontecimentos.LUCRO,"O Animal " + vender.getNomeArtistico() + " id: " + vender.getId() + " foi Vendido por " + Gerador.gerarValorAnimal(vender)  , Simulador.getDiaCorrente(),Simulador.getMesCorrente(),Simulador.getAnoCorrente(),Gerador.gerarValorAnimal(vender));

                }
            }
            
        } else {

            int contador = 0;

            for (Animal animal : Zoo.getAllNascimentos()) {
                System.out.println(" (" + contador + ") " + animal);
                contador++;
            }

            if (contador == 0) {

                System.out.println("não tem animais nos nascidos!");

            } else {

                vender = Zoo.getAllNascimentos().get(this.pedirOpcao(contador - 1));
               
                System.out.println("O Animal " + vender + " foi vendido.");
                Historico.adicionarAcontecimento(Acontecimentos.LUCRO,"O Animal " + vender.getNomeArtistico() + " id: " + vender.getId() + " foi Vendido por " + Gerador.gerarValorAnimal(vender)  , Simulador.getDiaCorrente(),Simulador.getMesCorrente(),Simulador.getAnoCorrente(),Gerador.gerarValorAnimal(vender));

            }
        }
            
        this.pedirContinuar();
        
    }
    
     private void realocarAnimal(){
        
        System.out.println(" (0) Escolher Animal das Instalações.");
        System.out.println(" (1) Escolher Animal dos Nascimentos.");
        Animal realocar;
        int optn  = this.pedirOpcao(1);
        
        if (optn == 0) {

            Instalacao instalacao = this.pedirInstalacao();

            if (instalacao != null) {

                int contador = 0;

                for (Animal animal : instalacao.getAnimaisDoentes()) {
                    System.out.println(" (" + contador + ") " + animal);
                    contador++;
                }

                for (Animal animal : instalacao.getAnimaisSaudaveis()) {

                    System.out.println(" (" + contador + ") " + animal);
                    contador++;
                }

                if (contador == 0) {
                    System.out.println("A instalação " + instalacao.getNome() + "não tem animais !");

                } else {

                    optn = this.pedirOpcao(contador - 2);

                    if (optn < instalacao.getAnimaisDoentes().size()) {
                        realocar = instalacao.getAnimaisDoentes().get(optn);
                        instalacao.getAnimaisDoentes().remove(optn);
                    } else {
                        realocar = instalacao.getAnimaisSaudaveis().get(optn - instalacao.getAnimaisDoentes().size() - 1);
                        instalacao.getAnimaisSaudaveis().remove(optn - instalacao.getAnimaisDoentes().size() - 1);
                    }
                    
                    Instalacao instRealocar = this.pedirInstalacao();
                    
                    if (instRealocar.getVacancia() == 0) {

                        if(realocar.estaDoente())
                            instRealocar.getAnimaisDoentes().set(Gerador.gerarNumero(0, instRealocar.getCapacidade()-1), realocar);
                        else
                            instRealocar.getAnimaisSaudaveis().set(Gerador.gerarNumero(0, instRealocar.getCapacidade()-1), realocar);

                    }else{

                        if(realocar.estaDoente())
                            instRealocar.getAnimaisDoentes().add( realocar);
                        else
                            instRealocar.getAnimaisSaudaveis().add(realocar);

                    }

                    System.out.println("O Animal " + realocar + " foi ralocado para" + instRealocar.getNome() );
                    Historico.adicionarAcontecimento(Acontecimentos.INFO,"O Animal " + realocar.getNomeArtistico() + " id: " + realocar.getId() + " foi realocado para " + instRealocar.getNome()  , Simulador.getDiaCorrente(),Simulador.getMesCorrente(),Simulador.getAnoCorrente());

                }
            }
            
        } else {

            int contador = 0;

            for (Animal animal : Zoo.getAllNascimentos()) {
                System.out.println(" (" + contador + ") " + animal);
                contador++;
            }

            if (contador == 0) {

                System.out.println("não tem animais nos nascidos!");

            } else {

                realocar = Zoo.getAllNascimentos().get(this.pedirOpcao(contador - 1));
               
                Instalacao instRealocar = this.pedirInstalacao();
                    
                if (instRealocar.getVacancia() == 0) {

                    if(realocar.estaDoente())
                        instRealocar.getAnimaisDoentes().set(Gerador.gerarNumero(0, instRealocar.getCapacidade()-1), realocar);
                    else
                        instRealocar.getAnimaisSaudaveis().set(Gerador.gerarNumero(0, instRealocar.getCapacidade()-1), realocar);

                }else{

                    if(realocar.estaDoente())
                        instRealocar.getAnimaisDoentes().add( realocar);
                    else
                        instRealocar.getAnimaisSaudaveis().add(realocar);

                }

                System.out.println("O Animal " + realocar + " foi ralocado para" + instRealocar.getNome() );
                Historico.adicionarAcontecimento(Acontecimentos.INFO,"O Animal " + realocar.getNomeArtistico() + " id: " + realocar.getId() + " foi realocado para " + instRealocar.getNome()  , Simulador.getDiaCorrente(),Simulador.getMesCorrente(),Simulador.getAnoCorrente());

            }
        }
            
        this.pedirContinuar();
        
    }


    @Override
    public void executarOpcaoPedida() {
        this.executarOpcao(this.pedirOpcao(MAXOPTN));
    }

}
