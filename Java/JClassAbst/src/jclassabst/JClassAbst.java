/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jclassabst;

/**
 *
 * @author tss
 */
public class JClassAbst {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Quadrato quadrato = new Quadrato(10);
        System.out.println(quadrato.toString());
        System.out.println("perimetro -->" + quadrato.perimetro());
        System.out.println("area -->" + quadrato.area());
    }
    
    
}

abstract class Poligono {
    //se dichiaro protected posso accedere alle variabili dai figli che este
    
    protected final int numeroLati;
    public Poligono (int lati) {
        this.numeroLati = lati;
    }
    public final int getNumeroLati() {
        return numeroLati;
    }
    @Override
    public String toString() {
            return "lati --> " +  numeroLati;
    }
    public abstract long perimetro();
    public abstract double area();
}

class Quadrato extends Poligono {
    private int lato;
    
    public Quadrato (int lato) {
        super(4);
        this.lato = lato;
    }

    @Override
    public long perimetro() {
        return lato * this.getNumeroLati();
    }

    @Override
    public double area() {
        return Math.pow(lato, 2);
    }
    
    @Override
    public String toString(){
        return String.format("Sono un quadrato \n %s \n lato -> %s", super.toString(), this.lato);
    }
}