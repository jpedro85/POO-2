/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Francisco MSI
 */
public class MenuEventos extends Menu{
    
     private static final int MAXOPTN = 2 ; 

    public MenuEventos(Menu menu) {
        super(menu);
    }
    
    @Override
    public void mostrarOpcoes(){
        
        String str_optn = """
                           (1) -> Jumangi
                           (2) -> Ano Chinês

                           (0) -> Voltar Atraz
                          """;
        super.mostrarOpcoes("======================================== Simulador =======================================",str_optn);

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
                jumangi();
                break;
            case 2:
                anoChines();
                break;
        }
    }
    
    private void jumangi(){
        
        if(Simulador.estaJumangi()){
            
            if (this.pedirBooleano("O Evento jumangi está Ativo pretende Dasativar ?")){
                Simulador.setJumangi(false);
                System.out.println("O Evento jumangi foi Desasivado !");
            }else
                System.out.println("O Evento jumangi mantido Ativado !");
            
        }else{
            if (this.pedirBooleano("O Evento jumangi está Desativado pretende Ativar ?")) {
                Simulador.setJumangi(true);
                System.out.println("O Evento jumangi foi Ativado !");
            }else
                System.out.println("O Evento jumangi mantido Desativo !");
        }
        
        this.pedirContinuar();
            
    }
    
    private void anoChines(){
        
        AnoChines ano = this.pedirAnoChines();
        
        boolean alterado = false;

        for (Animal animal : Zoo.getAllNascimentos()) {
            
            if(animal.getGenoma().getEspecie().getNome().toLowerCase().equals(ano.toString()) ){
                animal.aumentarAtratividadeBase(10);
                alterado = true;
            }
        }
        
        for (Instalacao instalacao : Zoo.getAllInstalacoes()) {
            
            for (Animal animal : instalacao.getAnimaisTodos()) {
                
                if(animal.getGenoma().getEspecie().getNome().toLowerCase().equals(ano.toString()) ){
                    animal.aumentarAtratividadeBase(10);
                    alterado = true;
                } 
            }
        }
        
        if (!alterado) 
            System.out.println("Não existem Animais da especie : " + ano + " !");
        else
            System.out.println("Concluido !");
        
        this.pedirContinuar();
    }
     
}
