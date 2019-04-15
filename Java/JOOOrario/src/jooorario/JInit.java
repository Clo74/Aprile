/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jooorario;

/**
 *
 * @author tss
 */
public class JInit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tempo t1 = new Tempo(23, 27, 32);
        System.out.println(t1.toString());
        Tempo t2 = new Tempo(4,5,16);
        System.out.println(t2.toString());
        
        t1.addOrari(t2);
        System.out.println(t1.toString());
        System.out.println("--------------------");
        
        
        t1 = new Tempo(10, 59, 59);
        System.out.println(t1.toString());
         t2 = new Tempo(4,5,16);
        System.out.println(t2.toString());
        
        t1.addOrari(t2);
        System.out.println(t1.toString());
        System.out.println("--------------------");

        
        t1 = new Tempo(0, 0, 0);
        System.out.println(t1.toString());
         t2 = new Tempo(4,5,16);
        System.out.println(t2.toString());
        
        t1.addOrari(t2);
        System.out.println(t1.toString());
        System.out.println("--------------------");
        
        t2 = new Tempo(23, 27, 32);
        t1.sottOrari(t2);
        System.out.println(t1.toString());
        System.out.println("--------------------");

        
    }
    
}
