/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jesempi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author tss
 */
public class Collezioni3 {
    public static void main(String[] args) {
        // MAPPE insiemi di coppie chiave valore
        
        Map<String,Integer> rubrica = new HashMap<>();
        
        rubrica.put("Giovanni", 33556687);
        rubrica.put("Laura", 335578997);
        //non posso duplicare chiavi  quindi se assegno con chiave uguale lui sovrascrive
        //devo usare putIfAbsent se non voglio che sovrascriva se esiste
        rubrica.putIfAbsent("Laura", 11111111);
        
        System.out.println(rubrica.get("Laura"));
        
        /*come scorrere una mappa
        non ho direttamente il metodo iterator
        ma posso farmi restituire una lista di chiavi dal metodo keyset e su questo fare iterator
        poi con 
         */
        Iterator<String> iterator = rubrica.keySet().iterator();
        while(iterator.hasNext()) {
            String chiave = iterator.next();
            System.out.println(chiave + "----" + rubrica.get(chiave));
        }
        
    }
}
