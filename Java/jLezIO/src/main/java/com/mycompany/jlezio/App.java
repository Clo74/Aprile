/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jlezio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {
        try (FileReader fr = new FileReader("/home/tss/Claudia/esempio.txt")) {
            int carattere;
            while ((carattere = fr.read()) != -1) {
                System.out.print((char) carattere);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Errore nella lettura del file");
        } catch (IOException ex) {
            System.out.println("Errore generico di I/O");
        }
    }
}
