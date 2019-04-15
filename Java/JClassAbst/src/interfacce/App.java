/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacce;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author tss
 */
public class App {
    public static void main(String[] args) {
        Persona[] arrPers = {new Persona("Mario","Rossi"), new Persona("Sandro","Botticelli"),new Persona("Giovanna","Verdi")};
        /*
        ARRAY
        */
        System.out.println("------------ARRAY---------------");

        System.out.println(Arrays.toString(arrPers));
        Arrays.sort(arrPers);
        
        System.out.println("------ordinato");
        System.out.println(Arrays.toString(arrPers));
        System.out.println("------------------------------");
        Moto[] arrMoto = {new Moto(700), new Moto(500),new Moto(150)};
        
        System.out.println(Arrays.toString(arrMoto));
        Arrays.sort(arrMoto);
        
        System.out.println("------ordinato");
        System.out.println(Arrays.toString(arrMoto));  
        /*
        LISTE
        */
        System.out.println("------------LISTE---------------");
        
         List<Persona> listPers = Arrays.asList(new Persona("Mario","Rossi"), new Persona("Sandro","Botticelli"),new Persona("Giovanna","Verdi"));
         Collections.sort(listPers);
         System.out.println(listPers);
         
        /*
        STREAM
        */
        System.out.println("------------STREAM---------------");
        
        Stream.of(new Persona("Mario","Rossi"), new Persona("Sandro","Botticelli"),new Persona("Giovanna","Verdi") )
                .sorted()
                .forEach(p->System.out.println(p));
    }
}

class Moto implements Comparable<Moto>{

    private final int cilindrata;

    public Moto(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    @Override
    public String toString() {
        return "cilindrata -> " + cilindrata;
    }

    @Override
    public int compareTo(Moto o) {
        return this.cilindrata-o.getCilindrata();
    }

}

class Persona implements Comparable<Persona>{

    private final String nome, cognome;

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void vaiALavorare() {
        System.out.println("ok...ci vado");
    }

    @Override
    public String toString() {
        return String.format("nome-> %s , cognome-> %s", this.nome, this.cognome);
    }

    @Override
    public int compareTo(Persona o) {
        return this.cognome.compareTo(o.getCognome());
    }

}