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

    private final int MAXOPTN = 14;

    public MenuGeral(Menu menu) {
        super(menu);
    }

    @Override
    public void mostrarOpcoes() {
        String optn="";
        optn = """
                   (1) -> Simulador 
                   (2) -> Gerir Base De dados 
                   (3) -> Gerir Animais 
                   (4) -> Gerir Instalacoes
                   (5) -> Gerir Funcionarios
                   (6) -> Gerir Clientes
                   (7) -> Gerir Capital
                   (8) -> Gerir Eventos(JUmanji e ano chines)
                   (9) -> Historico
                   (10) ->Historico do Tipo
                   (11) -> Caregar Zoo
                   (12) -> Gravar Zoo
                 
                   (0) -> Sair""";
        this.mostrarOpcoes("======================================= Menu Geral =======================================",optn);
        this.pedirOpcao(13);
    }

    @Override
    public void excutarOpcaoPedida(){
        this.executarOpcao(super.pedirOpcao(MAXOPTN));
    }
    
    @Override
    public void executarOpcao(int optn){
        
        switch(optn){
            
            case 0:
                this.voltarAtraz();
                break;
            case 1:
                //simulador
                break;
            case 2:
                MenuGerirBaseDeDados m1 =new MenuGerirBaseDeDados(this);
                m1.mostrarOpcoes();
                break;
            case 3:
                MenuAnimal m2=new MenuAnimal(this);
                m2.mostrarOpcoes();
                break;
            case 4:
                MenuInstalacao m3=new MenuInstalacao(this);
                m3.mostrarOpcoes();
                break;
            case 5:
                //MenuFuncionarios m4=new MenuFuncionarios(this);
                //m4.mostrarOpcoes();
                break;
            case 6:
                //MenuClientes m5=new MenuClientes(this);
                //m5.mostrarOpcoes();
                break;
            case 7:
                MenuCapital m6=new MenuCapital(this);
                m6.mostrarOpcoes();
                break;
            case 8:
                //MenuEventos m7=new MenuEventos(this);
                //m7.mostrarOpcoes();
                break;
            case 9:
                historico();
                break;
            case 10:
                historicoDoTipo(pedirAcontecimento());
                break;
            case 11:
                //carregar
                break;
            case 12:
                //gravar
                break;
        }
        
    }
    
    private void historico(){
        if(Historico.getAcontecimentos().isEmpty()){
            System.out.println("Não existe um Zoo carregado");
        }
        else{
            System.out.println("Historico:");
            for (Historico.Acontecimento acontecimento:Historico.getAcontecimentos()) {
                System.out.println("\t"+acontecimento);
            }
        }
    }
    
    private void historicoDoTipo(Acontecimentos a){
        if(Historico.getAcontecimentos().isEmpty()){
            System.out.println("Não existe um Zoo carregado");
        }
        else{
            System.out.println("Historico:");
            for (Historico.Acontecimento acontecimento:Historico.getAcontecimentos()) {
                if(acontecimento.getTipo()==a)
                System.out.println("\t"+acontecimento);
            }
        }
    }
}
