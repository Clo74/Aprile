/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banca;

import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tss
 */
public class JOOInit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ContoCorrente cc = new ContoCorrente(1, "Mario Rossi");
        
        //array di conti corrente
        ContoCorrente[] lsCC = new ContoCorrente[10];
        lsCC[0] = new ContoCorrente(1, "Mario Rossi");
        
         //creo una lista cioè un Array dinamico in cui non dichiaro quanti elementi ha
        List<ContoCorrente> lsConti = new ArrayList<>();
        lsConti.add(new ContoCorrente(1,"Mario Rossi"));
        
        cc.deposito(100);
        cc.deposito(25.3);
        cc.prelievo(50);
        stampaConto(cc);
        
        cc.estrattoConto(5).stream().forEach((t) ->  System.out.println("t"));
        //List<Double> estrattoConto = cc.estrattoConto();
    }

    private static void stampaConto(ContoCorrente cc) {
        System.out.println("------------------");
        System.out.println("Intestatario:\t" + cc.getIntestatario());
        System.out.println("numero conto:\t " + cc.getNumero());
        System.out.println("Saldo:\t\t " + cc.getSaldo());
        System.out.println("------------------");


    }
    
}
