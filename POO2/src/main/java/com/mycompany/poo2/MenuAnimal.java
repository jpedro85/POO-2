/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Pedro
 */
public final class MenuAnimal extends Menu {

    private final int MAXOPTN = 9;

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
                (7) -> Adequerir com GeneEspecifico
                (8) -> Vender 
                (9) -> Realocar
                
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
                this.pedirContinuar();
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
            case 7 :
                this.adequirirAnimalComGeneEspecifico();
                break;
            case 8:
                this.venderAnimal();
                break;
            case 9:
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
        System.out.println("O Animal: " + animalGerado + "\nFoi comprado !");
        Historico.adicionarAcontecimento(Acontecimentos.DESPESA, "O Animal: " + animalGerado.getNomeArtistico() + " id: "+ animalGerado.getId() + " Foi comprado", Simulador.getDiaCorrente(),Simulador.getMesCorrente(),Simulador.getAnoCorrente(),Gerador.gerarValorAnimal(animalGerado) );
        
        this.pedirContinuar();
    }
    
    private void adequirirAnimalComGeneEspecifico(){
        
        ArrayList<Animal> animais = new ArrayList<>(3);
        
        GeneEspecifico gene = this.pedirGeneEspecifico();
        int contador =0;
        Animal animalGerado;
        for (; contador < 3; contador++) {
            animalGerado = Gerador.gerarAnimal(gene);
            animais.add(animalGerado);
            System.out.println("(" + contador + ") -> " + animalGerado + "\n preco: " + Gerador.gerarValorAnimal(animalGerado) + "\n");
        }
        
        animalGerado = animais.get(this.pedirOpcao(contador-1) );
        Zoo.getAllNascimentos().add(animalGerado);
        System.out.println("O Animal: " + animalGerado + "\nFoi comprado !");
        Historico.adicionarAcontecimento(Acontecimentos.DESPESA, "O Animal: " + animalGerado.getNomeArtistico() + " id: "+ animalGerado.getId() + " Foi comprado", Simulador.getDiaCorrente(),Simulador.getMesCorrente(),Simulador.getAnoCorrente(),Gerador.gerarValorAnimal(animalGerado) );
        
        this.pedirContinuar();
    }
    
    private void listaAnimaisAux(ArrayList<Animal> array,String mesg,Gene gene){
        
        if (array.isEmpty()) {
            System.out.println("O Zoo não tem Animais nos " + mesg + "!");

        } else {
            
            System.out.println("\n"+ mesg + ":\n");
            
            for (Animal animal : array) {
                if (animal.getGenoma().contemGene(gene)) {
                    System.out.println(animal + "\n");
                }

            }

        }
    }
    
    private void listarAnimaisComGene(){
        
        Gene gene = this.pedirGene();
        
        if(gene!=null){
                            
            listaAnimaisAux(Zoo.getAllObitos(),"Obitus",gene);
                       
            if (Zoo.getAllSemiLivres().isEmpty()) {
                System.out.println("O Zoo não tem Animais nos Smilivres!");

            } else {
                
                System.out.println("\nSmilivres:\n");
                
                for (Map.Entry<Animal,Instalacao> entry : Zoo.getAllSemiLivres().entrySet()) {
                    if (entry.getKey().getGenoma().contemGene(gene)) {
                        System.out.println(entry.getKey() + "\n");
                    }

                }

            }
            

            if (Zoo.getAllInstalacoes().isEmpty()) {
                System.out.println("O Zoo não tem Instalações!");
                this.pedirContinuar();
            } else {

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
                    System.out.println("Não tem Animais !");
                }

                this.pedirContinuar();

            }
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
                    System.out.println("O Animal " + abater + "\nFoi Abatido.");
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
                System.out.println("O Animal " + abater + "\nFoi Abatido.");
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
                    
                    System.out.println("O Animal " + libertar + "\nFoi libertado.");
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
                
                System.out.println("O Animal " + libertar + "\nFoi libertado.");
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
                
                if(!instalacao.getAnimaisDoentes().isEmpty())
                    contador--;
                
                for (Animal animal : instalacao.getAnimaisSaudaveis()) {

                    System.out.println(" (" + contador + ") " + animal);
                    contador++;
                }
                
                if(!instalacao.getAnimaisSaudaveis().isEmpty())
                    contador--;
               
                optn = this.pedirOpcao(contador);

                if (optn < instalacao.getAnimaisDoentes().size()) {
                    vender = instalacao.getAnimaisDoentes().get(optn);
                    instalacao.getAnimaisDoentes().remove(optn);
                } else {

                    if (!instalacao.getAnimaisDoentes().isEmpty()) {
                        vender = instalacao.getAnimaisSaudaveis().get(optn - instalacao.getAnimaisDoentes().size() - 1);
                        instalacao.getAnimaisSaudaveis().remove(optn - instalacao.getAnimaisDoentes().size() - 1);
                    }else{
                        vender = instalacao.getAnimaisSaudaveis().get(optn );
                        instalacao.getAnimaisSaudaveis().remove(optn);
                    }
                }


                System.out.println("O Animal " + vender + "\nFoi Vendido.");
                Historico.adicionarAcontecimento(Acontecimentos.LUCRO,"O Animal " + vender.getNomeArtistico() + " id: " + vender.getId() + " foi Vendido por " + Gerador.gerarValorAnimal(vender)  , Simulador.getDiaCorrente(),Simulador.getMesCorrente(),Simulador.getAnoCorrente(),Gerador.gerarValorAnimal(vender));

                
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
                Zoo.getAllNascimentos().remove(vender);
                
                System.out.println("O Animal " + vender + "\nFoi vendido.");
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

            if (instalacao != null && instalacao.getOcupacao() != 0 ) {

                int contador = 0;
                for (Animal animal : instalacao.getAnimaisDoentes()) {
                    System.out.println(" (" + contador + ") " + animal);
                    contador++;
                }
                if(!instalacao.getAnimaisDoentes().isEmpty())
                    contador--;
                
                for (Animal animal : instalacao.getAnimaisSaudaveis()) {

                    System.out.println(" (" + contador + ") " + animal);
                    contador++;
                }
                if(!instalacao.getAnimaisSaudaveis().isEmpty())
                    contador--;

                optn = this.pedirOpcao(contador);

                if (optn < instalacao.getAnimaisDoentes().size()) {
                    realocar = instalacao.getAnimaisDoentes().get(optn);
                    instalacao.getAnimaisDoentes().remove(optn);
                } else {
                    
                    if (!instalacao.getAnimaisDoentes().isEmpty()) {
                        realocar = instalacao.getAnimaisSaudaveis().get(optn - instalacao.getAnimaisDoentes().size() - 1);
                        instalacao.getAnimaisSaudaveis().remove(optn - instalacao.getAnimaisDoentes().size() - 1);
                    }else{
                        realocar = instalacao.getAnimaisSaudaveis().get(optn );
                        instalacao.getAnimaisSaudaveis().remove(optn );
                    }
                    
                    
                }

                Instalacao instRealocar = this.pedirInstalacao();

                if (instRealocar.getVacancia() == 0) {

                    if(realocar.estaDoente()){
                        Zoo.getAllNascimentos().add(instRealocar.getAnimaisDoentes().get(0) );
                        instRealocar.getAnimaisDoentes().set(Gerador.gerarNumero(0, instRealocar.getCapacidade()-1), realocar);
                    }else{
                        Zoo.getAllNascimentos().add(instRealocar.getAnimaisSaudaveis().get(0));
                        instRealocar.getAnimaisSaudaveis().set(Gerador.gerarNumero(0, instRealocar.getCapacidade()-1), realocar);
                    }
                }else{

                    if(realocar.estaDoente())
                        instRealocar.getAnimaisDoentes().add( realocar);
                    else
                        instRealocar.getAnimaisSaudaveis().add(realocar);

                }

                System.out.println("O Animal " + realocar + "\nFoi ralocado para " + instRealocar.getNome() );
                Historico.adicionarAcontecimento(Acontecimentos.INFO,"O Animal " + realocar.getNomeArtistico() + " id: " + realocar.getId() + " foi realocado para " + instRealocar.getNome()  , Simulador.getDiaCorrente(),Simulador.getMesCorrente(),Simulador.getAnoCorrente());

                
                
                this.pedirContinuar();
            }else{
                System.out.println("A Instalação : " + instalacao.getNome() + " não tem animais." );
                this.pedirContinuar();
            }
            
        } else {

            int contador = 0;

            for (Animal animal : Zoo.getAllNascimentos()) {
                System.out.println(" (" + contador + ") " + animal);
                contador++;
            }

            if (contador == 0) {

                System.out.println("não tem animais nos nascidos!");
                this.pedirContinuar();
                
            } else {
                
                realocar = Zoo.getAllNascimentos().get(this.pedirOpcao(contador - 1));
                Zoo.getAllNascimentos().remove(realocar);
                
                Instalacao instRealocar = this.pedirInstalacao();
                    
                if (instRealocar != null) {
                  
                    if (instRealocar.getVacancia() == 0) {

                        if(realocar.estaDoente()){
                            Zoo.getAllNascimentos().add(instRealocar.getAnimaisDoentes().get(0));
                            instRealocar.getAnimaisDoentes().set(Gerador.gerarNumero(0, instRealocar.getCapacidade()-1), realocar);
                        }else{
                            Zoo.getAllNascimentos().add(instRealocar.getAnimaisSaudaveis().get(0));
                            instRealocar.getAnimaisSaudaveis().set(Gerador.gerarNumero(0, instRealocar.getCapacidade()-1), realocar);
                        }

                    } else {

                        if (realocar.estaDoente()) {
                            instRealocar.getAnimaisDoentes().add(realocar);
                        } else {
                            instRealocar.getAnimaisSaudaveis().add(realocar);
                        }

                    }

                    System.out.println("O Animal " + realocar + "\nFoi ralocado para " + instRealocar.getNome());
                    Historico.adicionarAcontecimento(Acontecimentos.INFO, "O Animal " + realocar.getNomeArtistico() + " id: " + realocar.getId() + " foi realocado para " + instRealocar.getNome(), Simulador.getDiaCorrente(), Simulador.getMesCorrente(), Simulador.getAnoCorrente());
                    
                    this.pedirContinuar();
                    
                }
            }
        }
            
   
        
    }


    @Override
    public void executarOpcaoPedida() {
        this.executarOpcao(this.pedirOpcao(MAXOPTN));
    }

}
