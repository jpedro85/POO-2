/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public final class MenuGeral extends Menu {

    private final int MAXOPTN = 12;

    public MenuGeral() {
        super(null);
    }

    @Override
    public void mostrarOpcoes() {
        String optn="";
        optn =  """
                    (1) -> Simulador 
                    (2) -> Gerir Base De dados 
                    (3) -> Gerir Animais 
                    (4) -> Gerir Instalacoes
                    (5) -> Gerir Funcionarios
                    (6) -> Gerir Capital
                    (7) -> Gerir Eventos(JUmanji e ano chines)
                    (8) -> Historico
                    (9) -> Historico do Tipo
                   (10) -> Caregar Zoo
                   (11) -> Gravar Zoo
                   (12) -> Listar Retrato De Familia

                    (0) -> Sair""";
        this.mostrarOpcoes("======================================= Menu Geral =======================================",optn);

    }
    
    @Override
    public void executarOpcaoPedida(){
        this.executarOpcao(super.pedirOpcao(MAXOPTN));
    }
    
    @Override
    public void executarOpcao(int optn){
        
        switch(optn){
            
            case 0:
                this.voltarAtraz();
                break;
            case 1:
                MenuSimulador m0 = new  MenuSimulador(this);
                m0.mostrarOpcoes();
                m0.executarOpcaoPedida();
                break;
            case 2:
                MenuGerirBaseDeDados m1 =new MenuGerirBaseDeDados(this);
                m1.mostrarOpcoes();
                m1.executarOpcaoPedida();
                break;
            case 3:
                MenuAnimal m2=new MenuAnimal(this);
                m2.mostrarOpcoes();
                m2.executarOpcaoPedida();
                break;
            case 4:
                MenuInstalacao m3 = new MenuInstalacao(this);
                m3.mostrarOpcoes();
                m3.executarOpcaoPedida();
                break;
            case 5:
                MenuEmpregado m4 = new MenuEmpregado(this);
                m4.mostrarOpcoes();
                m4.executarOpcaoPedida();
                break;
            case 6:
                MenuCapital m6 = new MenuCapital(this);
                m6.mostrarOpcoes();
                m6.executarOpcaoPedida();
                break;
            case 7:
                MenuEventos m7 = new MenuEventos(this);
                m7.mostrarOpcoes();
                m7.executarOpcaoPedida();
                break;
            case 8:
                historico();
                this.pedirContinuar();
                break;
            case 9:
                historicoDoTipo();
                break;
            case 10:
                Carregador.carregarZoo();
                Carregador.carregarFicheiros();
                this.pedirContinuar();
                break;
            case 11:
                Gravador.gravarZoo();
                Gravador.gravarBaseDados();
                this.pedirContinuar();
                break;
            case 12:
                this.listarRetratoFamilia();
                break;
        }
        
    }
    
     private void listarRetratoFamilia(){
        
        this.historico();
        System.out.println("-----------------------------------------------------------------------------------------------");
        
        System.out.println("\nInstalações: \n");
        if(Zoo.getAllInstalacoes().isEmpty()){
            System.out.println("Não existe Instalações.");
 
        }
        else{
            for (Instalacao inst:Zoo.getAllInstalacoes()) {
                System.out.println("\t"+inst+"\n");
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
        
        System.out.println("\nAnimais: \n");
        this.listarAnimais(false);
        System.out.println("-----------------------------------------------------------------------------------------------");
        
        System.out.println("\nEmpregados: \n");
        if(Zoo.getAllEmpregados().isEmpty()){
            System.out.println("Não existe Empregados.");
 
        }
        else{
            for (Empregado emp:Zoo.getAllEmpregados()) {
                System.out.println("\t"+emp+"\n");
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
        
        this.pedirContinuar();
    }
    
    private void historico(){
        if(Historico.getAcontecimentos().isEmpty()){
            System.out.println("Não existe acontecimentos no histórico.");
 
        }
        else{
            System.out.println("Historico:");
            for (Historico.Acontecimento acontecimento:Historico.getAcontecimentos()) {
                System.out.println("\t"+acontecimento);
            }
        }
    }
    
    private void historicoDoTipo(){
        if(Historico.getAcontecimentos().isEmpty()){
            System.out.println("Não existe acontecimentos no histórico.");
        }
        else{
            System.out.println("Historico:");
            Acontecimentos acont = this.pedirAcontecimento();
            boolean tem = false;
            for (Historico.Acontecimento acontecimento:Historico.getAcontecimentos()) {
                if(acontecimento.getTipo()==acont){
                    System.out.println("\t"+acontecimento);
                    tem=true;
                }
            }
            
            if (!tem) {
                System.out.println("Não existe acontecimentos no histórico do Tipo: " + acont );
            }
            
        }
        this.pedirContinuar();
    }
}
