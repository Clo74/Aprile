/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jclassabst;

import java.util.stream.IntStream;

/**
 *
 * @author tss
 */
public class App1 {

    public static void main(String[] args) {
        Square app = new Square("quadrato", 10);
        app.disegna();

    }
}

abstract class FiguraGeometrica {

    public abstract String nome();

    public abstract double perimetro();

    public abstract double area();

    public abstract void disegna();

}

interface IFiguraGeometrica {

    String nome();

    double perimetro();

    double area();

    void disegna();

}

class Square extends FiguraGeometrica {

    private final String nome;
    private final double lato;
    private static final int NUM_LATI = 4;
    private static final String NOME = "Quadrato";
    private static final String CAR = "#";

    public Square(double lato) {
        this(NOME, lato);
    }

    public Square(String nome, double lato) {
        this.nome = nome;
        this.lato = lato;
    }

    @Override
    public String nome() {
        return this.nome;
    }

    @Override
    public double perimetro() {
        return this.lato * this.NUM_LATI;
    }

    @Override
    public double area() {
        return Math.pow(this.lato, 2);
    }

    @Override
    public void disegna() {
        for (int i = 0; i < lato; i++) {
            if (i == 0 | i == lato - 1) {
                IntStream.range(0, (int) lato).forEach(j -> System.out.print(CAR + " "));
                System.out.println("");
            } else {
                System.out.print(CAR);
                IntStream.range(0, (int) lato - 2).forEach(j -> System.out.print("  "));
                System.out.print(" " + CAR);
                System.out.println("");

            }
        }

    }

}
class Rectangle implements IFiguraGeometrica {

    @Override
    public String nome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double perimetro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double area() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void disegna() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}