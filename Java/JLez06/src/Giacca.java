/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tss
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JLez06;

/**
 *
 * @author tss
 */
public class Giacca {
    // public lo posso omettere perchè di default è public
    public int numeroTasche =4;
    
    private boolean cappuccio=true;
    
    boolean zipAperta=true;
    
    public void chiudiZip(){
        zipAperta=false;
    }
    
    // costruttore. Se manca viene preso di default
//    deve esser
    public Giacca(){
        System.out.println("Ho costruito una nuova giacca...");
    }
    
    public String stato(){
        return String.format("La giacca ha %s tasche, cappuccio-->%s, zipAperta-->%s", numeroTasche,cappuccio,zipAperta);
    }
    
    
}
