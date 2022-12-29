/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Francisco MSI
 */
public abstract class Menu {
    
    private Menu ultimoMeno;
    private static Scanner scanner = new Scanner(System.in);

    public Menu(Menu menu) {
        ultimoMeno=menu;
    }
    
    public abstract void mostrarOpcoes();
    public abstract void executarOpcaoPedida();
    public abstract void executarOpcao(int optn); 
    
    public void mostrarOpcoes(String title , String optn){
        
        System.out.println(title);
        System.out.println(" Opções:" );
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println(optn);
        System.out.println("------------------------------------------------------------------------------------------");
    }
    
    public int pedirOpcao(int maxOptn){
        
        System.out.println("Menu -> " + "Escolha uma opção !");
        System.out.print("<-:");
        
        int optn = -1;
        while(optn == -1){
            optn = validarNumero( 0, maxOptn,getScanner().nextLine());
        }
        return optn;
    }
    
    public static Scanner getScanner() {
        return scanner;
    }
    
    public Menu getUltimoMeno() {
        return ultimoMeno;
    }

    public void setUltimoMeno(Menu ultimoMeno) {
        this.ultimoMeno = ultimoMeno;
    }
        
    public void voltarAtraz(){
        if (this.ultimoMeno!= null){
            this.ultimoMeno.mostrarOpcoes();
            this.ultimoMeno.executarOpcaoPedida();
        }else
            System.out.println("A sair !");
    }
    
    public double pedirNumero(String menssagem,double min,double max){
        
        System.out.println("Menu -> " + menssagem );
        System.out.print("<-:");
        
        double optn = -1;
        while(optn == -1){
            optn = validarNumero( min, max,getScanner().nextLine());
        }
        return optn;
        
    }
    
    public int pedirNumero(String menssagem,int min,int max){
        
        System.out.println("Menu -> " + menssagem );
        System.out.print("<-:");
        
        int optn = -1;
        while(optn == -1){
            optn = validarNumero( min, max,getScanner().nextLine());
        }
        return optn;
        
    }
    
    private double validarNumero(double limitInf ,double limitSup ,String str_number){
    
        try {

            double valor = Double.parseDouble(str_number);
            
            if (limitSup <= 0) {
                if (valor >= limitInf ) {
                    return valor;
                } else {
                    throw new NumberFormatException("Menu -> " + "Numero fora dos limites permitidos !");
                }
            }else{
                if (valor >= limitInf && valor <= limitSup) {
                    return valor;
                } else {
                    throw new NumberFormatException("Menu -> " +"Numero fora dos limites permitidos !");
                }
            }
            
        } catch (NumberFormatException expNumber) {
            
            if (!expNumber.getMessage().contains("For") ) {
                System.out.println(expNumber.getMessage());
            }

            System.out.println("Menu -> " + "Tente de novo.");
            System.out.print("<-:");
            return -1;
        }

    }
    
    private int validarNumero(int limitInf ,int limitSup ,String str_number){
    
        try {

            int valor = Integer.parseInt(str_number);
            
            if (limitSup <= 0) {
                if (valor >= limitInf ) {
                    return valor;
                } else {
                    throw new NumberFormatException("Menu -> " + "Numero fora dos limites permitidos !");
                }
            }else{
                if (valor >= limitInf && valor <= limitSup) {
                    return valor;
                } else {
                    throw new NumberFormatException("Menu -> " + "Numero fora dos limites permitidos !");
                }
            }
            
        } catch (NumberFormatException expNumber) {
            
            if (!expNumber.getMessage().contains("For") ) {
                System.out.println(expNumber.getMessage());
            }

            System.out.println("Menu -> " + "Tente de novo.");
            System.out.print("<-:");
            return -1;
        }

    }   
    
    public String pedirNome(String message){
        System.out.println("Menu -> " + message);
        System.out.print("<-:");
        
        String nome = "";
        while(nome == null || nome.equals("")){
            nome=this.getScanner().nextLine();
        }
        return nome;
    }
    
    public GeneEspecie pedirGeneEspecie(){
        
        System.out.println("Menu -> " + "Escolha um dos Gense de Especie seguintes:" );
        int contador = 0;
        for(GeneEspecie s : GeneEspecie.getAllInstances()){
            System.out.println(" ("+ contador +") " + s);
            contador++;
        }
        
        if (GeneEspecie.getAllInstances().isEmpty()) {
            return null;
        }else
            return GeneEspecie.getAllInstances().get(this.pedirOpcao(contador-1));
        
    }
    
    public boolean pedirBooleano(String message){
        
        System.out.println(message+"\n<-:");
        System.out.println(" (0) -> Não");
        System.out.println(" (1) -> Sim");
        
        return this.pedirOpcao(1) == 1; 
    }
    
    public String pedirValorStringGeneEspecie(){
        String temp="";
        boolean valido=false;

        while(valido==false){
            temp=pedirNome("Introduza um novo Valor para o GeneEspecie");
            valido=true;
            for (GeneEspecie gene : GeneEspecie.getAllInstances()) {
                if(gene.getValor().toLowerCase().equals(temp.toLowerCase())){
                    valido=false;
                    System.out.println("O Valor Introduzido já existe !");
                    break;
                }
            }
        }
        return temp;
    }
    
    public String pedirValorStringGeneEspecifico(){
        
        String temp="";
        boolean valido=false;
        
        while(valido==false){
            temp=pedirNome("Introduza um novo Valor para o GeneEspecifico");
            valido=true;
            for (GeneEspecifico gene : GeneEspecifico.getAllInstances()) {
                
                if(gene.getValor().toLowerCase().equals(temp.toLowerCase())){
                    valido=false;
                    System.out.println("O Valor Introduzido já existe !");
                    break;
                }
            }
        }
        return temp;
    }
      
    public Meses pedirMes(){
        
        System.out.println("Menu -> " + "Escolha um mês :" );
        int contador = 0;
        for(Meses s:Meses.values()){
            System.out.println(" ("+ contador +") " + s);
            contador++;
        }
        return Meses.values()[this.pedirOpcao(contador-1)];
        
    }
    
    public CararcteristicasEspecificas pedirTipoCaracteristica(){
        
        System.out.println("Menu -> " + "Escolha um dos tipos dos seguintes:" );
        int contador = 0;
        for(CararcteristicasEspecificas s:CararcteristicasEspecificas.values()){
            System.out.println(" ("+ contador +") " + s);
            contador++;
        }
        return CararcteristicasEspecificas.values()[this.pedirOpcao(contador-1)];
    }
    
    public Sexo pedirSexo(){
        System.out.println("Menu -> " + "Escolha um dos Sexos seguintes:" );
        int contador = 0;
        for(Sexo s:Sexo.values()){
            System.out.println(" ("+ contador +") " + s);
            contador++;
        }
        return Sexo.values()[this.pedirOpcao(contador-1)];
    }
    
    public Dieta pedirDieta(){
        System.out.println("Menu -> " + "Escolha um dos Sexos seguintes:" );
        int contador = 0;
        for(Dieta s:Dieta.values()){
            System.out.println(" ("+ contador +") " + s);
            contador++;
        }
        return Dieta.values()[this.pedirOpcao(contador-1)];
    }
    
    public Ambiente pedirAmbiente(){
        System.out.println("Menu -> " + "Escolha um dos Ambientes seguintes:" );
        int contador = 0;
        for(Ambiente s:Ambiente.values()){
            System.out.println(" ("+ contador +") " + s);
            contador++;
        }
        return Ambiente.values()[this.pedirOpcao(contador-1)];
    }
    
    public AnoChines pedirAnoChines(){
        System.out.println("Menu -> " + "Escolha um dos Anos seguintes:" );
        int contador = 0;
        for(AnoChines s:AnoChines.values()){
            System.out.println(" ("+ contador +") " + s);
            contador++;
        }
        return AnoChines.values()[this.pedirOpcao(contador-1)];
    }
    
    public Acontecimentos pedirAcontecimento(){
        
        System.out.println("Menu -> " + "Escolha um Acontecimento" );
        int contador = 0;
        for(Acontecimentos s:Acontecimentos.values()){
            System.out.println(" ("+ contador +") " + s);
            contador++;
        }
        return Acontecimentos.values()[this.pedirOpcao(contador-1)];
        
    }
    
    public Empreiteira pedirEmpreiteira(Instalacao instalacao){
        
        System.out.println("Menu -> " + "Escolha uma Empreiteira" );
        ArrayList<Empreiteira> empreiteiras = new ArrayList<>(3);
         
        int optn = 0;
        while(true){
           
            int i = 1;
            Empreiteira gerada;
            for (; i < 4; i++) {
                gerada = Gerador.gerarEmpreiteira(instalacao);
                empreiteiras.add(gerada);
                System.out.println(" ("+ i +") " + gerada );
            }
            System.out.println(" (0) nenhum (Novo Concurso)");
            
            optn = this.pedirOpcao(3);
            
            if(optn != 0)
                return empreiteiras.get(optn-1);
        
        }
        
    }
    
    public Instalacao pedirInstalacao(){
        
        System.out.println("Menu -> " + "Escolha uma Istalação" );
        
        String temanimais = "(terão de ser realocados ou serão libertados)";
        
        if (Zoo.getAllInstalacoes().isEmpty()) {
            
            System.out.println("O Zoo não tem Instalações !");
            this.pedirContinuar();
            
            return null;
        }else{
            
            int contador = 0;
            for(Instalacao s: Zoo.getAllInstalacoes()){

                if (s.getOcupacao()!= 0) 
                    temanimais = " Animais: " + s.getOcupacao() + temanimais;
                else
                    temanimais = " Não tem animais";

                System.out.println(" ("+ contador +") -> " + s.getNome() + " Id: " + s.getId() + "Ambiente:" + s.getAmbiente() + temanimais);
                contador++;
            }        

            return Zoo.getAllInstalacoes().get(this.pedirOpcao(contador-1));
        }
    }
    
    
    public Empregado pedirEmprepago(){

       System.out.println("Menu -> " + "Escolha um Empregado" );

       if (Zoo.getAllEmpregados().isEmpty()) {

           System.out.println("O Zoo não tem Empregados !");
           this.pedirContinuar();

           return null;
       }else{

           int contador = 0;
           for(Empregado s: Zoo.getAllEmpregados()){

               System.out.println(" ("+ contador +") -> " + s);
               contador++;
           }        

           return Zoo.getAllEmpregados().get(this.pedirOpcao(contador-1));
       }
   }
    
    public void pedirContinuar(){
        
        System.out.println("-> " + "Presione uma tecla para continuar !" );
        
        getScanner().nextLine();
        this.mostrarOpcoes();
        this.executarOpcaoPedida();
    }
}
