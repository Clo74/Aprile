/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jlezio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author tss
 */
public class App1 {

    public static void main(String[] args) {
        /*posso anche combinare il filereader che è specializzato a leggere un file
        poi assegno questo a bufferedreader in modo da leggere una riga alla volta*/
        try (
                FileReader fr = new FileReader("/home/tss/Claudia/esempio.txt");
                BufferedReader br = new BufferedReader(fr);
                ) {
            
            String riga;
            while ((riga = br.readLine()) != null) {
                System.out.println(riga);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Errore nella lettura del file");
        } catch (IOException ex) {
            System.out.println("Errore generico di I/O");
        }
    }
}
