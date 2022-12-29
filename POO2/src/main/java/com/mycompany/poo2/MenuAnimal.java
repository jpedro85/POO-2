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
                (4) -> Listar Retrato De Familia
                (5) -> Abater 
                (6) -> Libertar
                (7) -> Adequirir
                (8) -> Vender 
                (9) -> Realocar
                
                (0) -> Voltar Atraz""";
        this.mostrarOpcoes("=================================== Menu Gerir Animais ===================================", optn);
    }

    @Override
    public void executarOpcao(int optn) {
        switch (optn) {
            case 0 -> {
                this.voltarAtraz();
            }
            case 1 -> {

                if (imprimirAnimais()) {
                    boolean valido = false;
                    System.out.println("Escolha o Id do Animal que quer abater");
                    System.out.print("<-:");
                    while (!valido) {
                        valido = validarAbate(getScanner().nextLine());
                    }
                } else {
                    this.voltarAtraz();
                }
            }
            case 2 -> {

                if (imprimirAnimais()) {
                    boolean valido = false;
                    System.out.println("Escolha o Id do Animal que quer Libertar");
                    System.out.print("<-:");
                    while (!valido) {
                        valido = validarLibertar(getScanner().nextLine());
                    }
                }
            }
            case 3 -> {
                ArrayList<Animal> animaisAdquerir = new ArrayList<>(3);

                for (int i = 0; i < 3; i++) {
                    animaisAdquerir.add(Gerador.gerarAnimal());
                }

                optn = 1;
                for (Animal animal : animaisAdquerir) {
                    System.out.println("(" + optn + ") -> " + animal);
                    optn++;
                }
                System.out.println("(0) -> Voltar Atras");
                switch (this.pedirOpcao(3)) {
                    case 0 ->
                        this.voltarAtraz();
                    case 1 ->
                        Zoo.getAllNascimentos().add(animaisAdquerir.get(0));
                    case 2 ->
                        Zoo.getAllNascimentos().add(animaisAdquerir.get(1));
                    case 3 ->
                        Zoo.getAllNascimentos().add(animaisAdquerir.get(2));
                }
            }
            case 4 -> {
                if (imprimirAnimais()) {
                    boolean valido = false;
                    System.out.println("Escolha o Id do Animal que quer Vender");
                    System.out.print("<-:");
                    while (!valido) {
                        valido = validarVender(getScanner().nextLine());
                    }
                }
            }
            case 5 -> {
                if (imprimirAnimais()) {
                    boolean valido = false;
                    System.out.println("Escolha o Id do Animal que quer Realocar");
                    System.out.print("<-:");
                    while (!valido) {
                        valido = validarRealocar(getScanner().nextLine());
                    }
                }
            }
        }
    }

    private boolean validarAbate(String input) {

        try {

            int idEscolhido = Integer.parseInt(input);

            for (Instalacao allInstalacoe : Zoo.getAllInstalacoes()) {

                for (Animal animaisTodo : allInstalacoe.getAnimaisTodos()) {

                    if (animaisTodo.getId() == idEscolhido) {

                        animaisTodo.morre(true);

                        if (animaisTodo.estaDoente()) {

                            allInstalacoe.getAnimaisDoentes().remove(animaisTodo);
                            Zoo.getAllObitos().add(animaisTodo);
                            Historico.adicionarAcontecimento(Acontecimentos.OBITO, "O Animal " + animaisTodo + " foi abatido!", Simulador.getDiaCorrente(), Simulador.getMesCorrente(), Simulador.getAnoCorrente());
                        } else {

                            allInstalacoe.getAnimaisSaudaveis().remove(animaisTodo);
                            Zoo.getAllObitos().add(animaisTodo);
                            Historico.adicionarAcontecimento(Acontecimentos.OBITO, "O Animal " + animaisTodo + " foi abatido!", Simulador.getDiaCorrente(), Simulador.getMesCorrente(), Simulador.getAnoCorrente());
                        }

                        System.out.println("Animal abatido com Sucesso");
                        return true;
                    }
                }
            }
            for (Animal allNascimento : Zoo.getAllNascimentos()) {

                if (allNascimento.getId() == idEscolhido) {

                    allNascimento.morre(true);
                    Zoo.getAllNascimentos().remove(allNascimento);
                    Zoo.getAllObitos().add(allNascimento);
                    Historico.adicionarAcontecimento(Acontecimentos.OBITO, "O Animal " + allNascimento + " foi abatido!", Simulador.getDiaCorrente(), Simulador.getMesCorrente(), Simulador.getAnoCorrente());
                    System.out.println("Animal abatido com Sucesso");
                    return true;
                }
            }
            throw new NumberFormatException("Id não valido!");

        } catch (NumberFormatException expNumber) {
            System.out.println(expNumber.getMessage());
            System.out.println("Tente de novo.");
            System.out.print("<-:");
            return false;
        }
    }

    private boolean validarLibertar(String input) {

        try {

            int idEscolhido = Integer.parseInt(input);

            for (Instalacao allInstalacoe : Zoo.getAllInstalacoes()) {

                for (Animal animaisTodo : allInstalacoe.getAnimaisTodos()) {

                    if (animaisTodo.getId() == idEscolhido) {

                        if (animaisTodo.estaDoente()) {

                            allInstalacoe.getAnimaisDoentes().remove(animaisTodo);
                            Historico.adicionarAcontecimento(Acontecimentos.INFO, "O Animal " + animaisTodo + " foi libertado!", Simulador.getDiaCorrente(), Simulador.getMesCorrente(), Simulador.getAnoCorrente());
                        } else {

                            allInstalacoe.getAnimaisSaudaveis().remove(animaisTodo);
                            Historico.adicionarAcontecimento(Acontecimentos.INFO, "O Animal " + animaisTodo + " foi libertado!", Simulador.getDiaCorrente(), Simulador.getMesCorrente(), Simulador.getAnoCorrente());
                        }

                        System.out.println("Animal libertado com Sucesso");
                        return true;
                    }
                }
            }
            for (Animal allNascimento : Zoo.getAllNascimentos()) {

                if (allNascimento.getId() == idEscolhido) {
                    Zoo.getAllNascimentos().remove(allNascimento);
                    Historico.adicionarAcontecimento(Acontecimentos.INFO, "O Animal " + allNascimento + " foi libertado!", Simulador.getDiaCorrente(), Simulador.getMesCorrente(), Simulador.getAnoCorrente());
                    System.out.println("Animal libertado com Sucesso");
                    return true;
                }
            }
            throw new NumberFormatException("Id não valido!");

        } catch (NumberFormatException expNumber) {

            System.out.println(expNumber.getMessage());
            System.out.println("Tente de novo.");
            System.out.print("<-:");
            return false;
        }
    }

    private boolean validarVender(String input) {

        try {

            int idEscolhido = Integer.parseInt(input);

            for (Instalacao allInstalacoe : Zoo.getAllInstalacoes()) {

                for (Animal animaisTodo : allInstalacoe.getAnimaisTodos()) {

                    if (animaisTodo.getId() == idEscolhido) {

                        if (animaisTodo.estaDoente()) {

                            allInstalacoe.getAnimaisDoentes().remove(animaisTodo);
                            Historico.adicionarAcontecimento(Acontecimentos.LUCRO, "O Animal " + animaisTodo + " foi Vendido!", Simulador.getDiaCorrente(), Simulador.getMesCorrente(), Simulador.getAnoCorrente(), Gerador.gerarValorAnimal(animaisTodo));
                        } else {

                            allInstalacoe.getAnimaisSaudaveis().remove(animaisTodo);
                            Historico.adicionarAcontecimento(Acontecimentos.LUCRO, "O Animal " + animaisTodo + " foi Vendido!", Simulador.getDiaCorrente(), Simulador.getMesCorrente(), Simulador.getAnoCorrente(), Gerador.gerarValorAnimal(animaisTodo));
                        }

                        System.out.println("Animal vendido com Sucesso");
                        return true;
                    }
                }
            }
            for (Animal allNascimento : Zoo.getAllNascimentos()) {

                if (allNascimento.getId() == idEscolhido) {
                    Zoo.getAllNascimentos().remove(allNascimento);
                    Historico.adicionarAcontecimento(Acontecimentos.LUCRO, "O Animal " + allNascimento + " foi libertado!", Simulador.getDiaCorrente(), Simulador.getMesCorrente(), Simulador.getAnoCorrente(), Gerador.gerarValorAnimal(allNascimento));
                    System.out.println("Animal Vendido com Sucesso");
                    return true;
                }
            }
            throw new NumberFormatException("Id não valido!");

        } catch (NumberFormatException expNumber) {

            System.out.println(expNumber.getMessage());
            System.out.println("Tente de novo.");
            System.out.print("<-:");
            return false;
        }
    }

    private boolean validarRealocar(String input) {

        try {

            int idEscolhido = Integer.parseInt(input);

            for (Instalacao allInstalacoe : Zoo.getAllInstalacoes()) {

                for (Animal animaisTodo : allInstalacoe.getAnimaisTodos()) {

                    if (animaisTodo.getId() == idEscolhido) {
                        boolean valido = false;
                        System.out.println("Escolha o Id da Instalacao que quer realocar para");
                        System.out.print("<-:");
                        while (!valido) {
                            valido = validarInstalacao(getScanner().nextLine(), animaisTodo);
                        }
                        return true;
                    }
                }
            }
            for (Animal allNascimento : Zoo.getAllNascimentos()) {

                if (allNascimento.getId() == idEscolhido) {
                    boolean valido = false;
                    System.out.println("Escolha o Id da Instalacao que quer realocar para");
                    System.out.print("<-:");
                    while (!valido) {
                        valido = validarInstalacao(getScanner().nextLine(), allNascimento);
                    }
                    return true;
                }
            }
            throw new NumberFormatException("Id não valido!");

        } catch (NumberFormatException expNumber) {

            System.out.println(expNumber.getMessage());
            System.out.println("Tente de novo.");
            System.out.print("<-:");
            return false;
        }
    }

    private boolean imprimirAnimais() {

        if (Zoo.getAllInstalacoes() != null && !Zoo.getAllInstalacoes().isEmpty()) {

            for (Instalacao allInstalacoe : Zoo.getAllInstalacoes()) {

                System.out.println(allInstalacoe.getNome() + " Id:" + allInstalacoe.getId());

                if (!allInstalacoe.getAnimaisTodos().isEmpty()) {

                    for (Animal animaisTodo : allInstalacoe.getAnimaisTodos()) {

                        System.out.println(animaisTodo);
                    }
                } else {

                    System.out.println("Instalaçao nao possui animais!");
                }
            }
            if (Zoo.getAllNascimentos() != null && !Zoo.getAllNascimentos().isEmpty()) {

                for (Animal allNascimento : Zoo.getAllNascimentos()) {

                    System.out.println(allNascimento);
                }
            }
            return true;

        } else {

            System.out.println("Nao existe instalaçoes!");
            return false;
        }
    }

    private boolean validarInstalacao(String input, Animal animal) {

        try {

            int idEscolhido = Integer.parseInt(input);

            for (Instalacao allInstalacoe : Zoo.getAllInstalacoes()) {

                if (allInstalacoe.getId() == idEscolhido) {
                    if (allInstalacoe.estaCheia()) {
                        for (Animal animaisTodo : allInstalacoe.getAnimaisTodos()) {
                            System.out.println(animaisTodo);
                        }
                        boolean valido = false;
                        System.out.println("Escolha o Animal que quer trocar por");
                        System.out.print("<-:");
                        while (!valido) {
                            valido = validarAnimal(getScanner().nextLine(), animal, allInstalacoe);
                        }
                        return true;
                    } else {
                        if (animal.estaDoente()) {
                            allInstalacoe.getAnimaisDoentes().add(animal);
                        } else {
                            allInstalacoe.getAnimaisSaudaveis().add(animal);
                        }
                    }
                }
            }

            throw new NumberFormatException("Id não valido!");

        } catch (NumberFormatException expNumber) {

            System.out.println(expNumber.getMessage());
            System.out.println("Tente de novo.");
            System.out.print("<-:");
            return false;
        }
    }

    private boolean validarAnimal(String input, Animal animal, Instalacao instalacao) {

        try {

            int idEscolhido = Integer.parseInt(input);

            for (Animal animaisTodo : instalacao.getAnimaisTodos()) {

                if (animaisTodo.getId() == idEscolhido) {

                    if (animaisTodo.estaDoente()) {
                        instalacao.getAnimaisDoentes().remove(animaisTodo);
                        if (animal.estaDoente()) {
                            instalacao.getAnimaisDoentes().add(animal);
                        } else {

                            instalacao.getAnimaisSaudaveis().add(animal);
                        }

                        return true;
                    } else {
                        instalacao.getAnimaisSaudaveis().remove(animaisTodo);
                        if (animal.estaDoente()) {
                            instalacao.getAnimaisDoentes().add(animal);
                        } else {

                            instalacao.getAnimaisSaudaveis().add(animal);
                        }
                        return true;
                    }
                }
            }

            throw new NumberFormatException("Id não valido!");

        } catch (NumberFormatException expNumber) {

            System.out.println(expNumber.getMessage());
            System.out.println("Tente de novo.");
            System.out.print("<-:");
            return false;
        }
    }

    @Override
    public void executarOpcaoPedida() {

        this.mostrarOpcoes();
        this.executarOpcao(this.pedirOpcao(MAXOPTN));
    }

}
