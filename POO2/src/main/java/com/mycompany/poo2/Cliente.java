/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo2;

/**
 *
 * @author Pedro
 */
public class Cliente extends Pessoa {
    
    private static int numeroClientes = 0;
    private int numeroVisitas;
    private double saldo;
    private int generosidade;
    private int interece;
    
    public Cliente(FormatedString fstr) throws RepresentacaoInvalidaDoTipo {
        
        super(fstr, "Cliente");
        
        try{
        
            this.generosidade = Integer.parseInt(fstr.getAtributo("Generosidade","Cliente"));
            this.interece = Integer.parseInt(fstr.getAtributo("Interece","Cliente"));
            this.numeroVisitas = Integer.parseInt(fstr.getAtributo("NumeroVisitas","Cliente"));
            this.saldo = Double.parseDouble(fstr.getAtributo("Saldo","Cliente"));
        
        }catch(NumberFormatException exp){
            throw new RepresentacaoInvalidaDoTipo("Numero mal formatado na FormatedString: \n" + fstr );
        }
        
        numeroClientes++;
    }
    
    public Cliente(String nome, int nif, int idade, double saldo, int generosidade, int interece) {
        super(nome, nif, idade);
        this.saldo = saldo;
        this.generosidade = generosidade;
        this.interece = interece;
        numeroClientes++;
    }
    
    public static int getNumeroClientes() {
        return numeroClientes;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public int getGenerosidade() {
        return generosidade;
    }
    
    public int getInterece() {
        return interece;
    }
    
    public static int getQuantidade() {
        return numeroClientes;
    }
    
    @Override
    public void eleminar() {
        super.eleminar();
        numeroClientes--;
    }
    
    public int getNumeroVisitas() {
        return numeroVisitas;
    }
    
    public boolean pagar(double preco) {
        this.saldo -= preco;
        return saldo > 0;
    }
    
    public double oferecerDinheiro(Animal animal){
        
        if ( animal.getAtratividade() >= this.getInterece() && Gerador.gerarProbabilidade() <= this.getGenerosidade()) {
            double oferecer = Gerador.gerarNumero(0.0, 200.0);
            
            if (this.saldo - oferecer >= 0) {
                this.saldo -= oferecer;
                return oferecer;
            }else{
                oferecer = this.saldo;
                this.saldo =0;
            }
            
            return oferecer;

        }
        return 0.0;
    }

    @Override
    public FormatedString toFormatedString() {
        
        FormatedString fstr = new FormatedString(getClass().getSimpleName(), 7);
        fstr.addAtributo("Nome", this.getNome());
        fstr.addAtributo("Nif", this.getNif());
        fstr.addAtributo("Idade", this.getIdade());
        fstr.addAtributo("Saldo", this.getSaldo());
        fstr.addAtributo("Generosidade", this.getGenerosidade());
        fstr.addAtributo("Interece", this.getInterece());
        fstr.addAtributo("NumeroVisitas", this.getNumeroVisitas());
        return fstr;
    }
    
    @Override
    public String toString() {
        return "O Cliente tem:\n\t"+super.toString()+" Saldo:"+this.saldo+" Generosidade:"+this.generosidade+" Interece:"+this.interece;
    }
    
}
