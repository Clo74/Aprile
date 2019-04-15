/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;

/**
 *
 * @author tss
 */
public class InitProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Auto auto = new Auto("Honda",2015,1200,4,Auto.Alimentazione.BENZINA);
        
        Moto moto = new Moto(Moto.Tempi.DUET,"TRIUMPH",2018,800);
        
        Furgone furgone = new Furgone(15, "FIAT", 2001,1000);
     
        System.out.println(moto.toString());
        System.out.println("==================");
        
        Garage garage = new Garage();
    
        garage.posteggia(auto);
        
        garage.posteggia(moto);
        
        garage.posteggia(furgone);
        
        System.out.println(garage.toString());
        System.out.println("==================");
        
        Veicolo veicUscito = garage.esci(0);
        
        System.out.println(garage.toString());
    }
    
}
