/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocoDadiOO;

import java.util.Random;

/**
 *
 * @author tss
 */
public class Dado {
    public Dado() {
        
    }
    public int lancia(){
        Random r = new Random();
        
        int val = r.nextInt(5) + 1;
        
        return val;
    }
    
}
