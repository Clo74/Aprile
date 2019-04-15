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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author tss
 */
public class App2 {

    public static void main(String[] args) {
        try {
            /*Java ultime versioni
            usa java.nio.file
            classe principale paths che ha metodi statici
            e files (ha la chiusura automatica)
            
            */
            Path path = Paths.get("/home/tss/Claudia/esempio.txt");
            
            Files.readAllLines(path).
                    forEach(v -> System.out.println(v));
            String strApp = "prova di scrittura \n dentro un file";
            Files.write(path, strApp.getBytes(),StandardOpenOption.APPEND);
        } catch (IOException ex) {
            System.out.println("file non trovato");
        }
    }
}
