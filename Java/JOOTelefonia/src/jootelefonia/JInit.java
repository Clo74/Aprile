/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jootelefonia;

/**
 *
 * @author tss
 */
public class JInit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //creo una sim
        Sim sim1 = new Sim("3215688",15,0.15);
        sim1.insTelef("44444", 2);
        sim1.insTelef("121212", 3);
        sim1.insTelef("44444", 5);
        
        System.out.println(sim1.toString()); 
        System.out.println("---minuti totali chiamate: " + sim1.getMinTot());
        System.out.println("----------------------");
        
        System.out.println("Telefonate al nr 44444: " + sim1.telefVersoNr("44444"));

    }
    
}
