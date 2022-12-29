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

    private final int MAXOPTN = 11;

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
                //m7.mostrarOpcoes();
                break;
            case 8:
                historico();
                break;
            case 9:
                historicoDoTipo(pedirAcontecimento());
                break;
            case 10:
                //carregar
                break;
            case 11:
                //gravar
                break;
        }
        
    }
    
    private void historico(){
        if(Historico.getAcontecimentos().isEmpty()){
            System.out.println("Não existe um Zoo carregado");
            this.mostrarOpcoes();
            this.executarOpcaoPedida();
        }
        else{
            System.out.println("Historico:");
            for (Historico.Acontecimento acontecimento:Historico.getAcontecimentos()) {
                System.out.println("\t"+acontecimento);
            }
            this.mostrarOpcoes();
            this.executarOpcaoPedida();
        }
    }
    
    private void historicoDoTipo(Acontecimentos a){
        if(Historico.getAcontecimentos().isEmpty()){
            System.out.println("Não existe um Zoo carregado");
            this.mostrarOpcoes();
            this.executarOpcaoPedida();
        }
        else{
            System.out.println("Historico:");
            for (Historico.Acontecimento acontecimento:Historico.getAcontecimentos()) {
                if(acontecimento.getTipo()==a)
                System.out.println("\t"+acontecimento);
            }
            this.mostrarOpcoes();
            this.executarOpcaoPedida();
        }
    }
}
