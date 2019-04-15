/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jlezio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
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
public class App4 {

    public static void main(String[] args) throws IOException {
        try {
            URL oracle = new URL("https://www.motardshop.it");
            URLConnection yc = oracle.openConnection();

            try (BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()))) {
                String inputLine;
                Path path = Paths.get("/home/tss/Claudia/pagina_html.html");
                if (Files.exists(path)) {
                    Files.delete(path);
                }
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                    Files.write(path, inputLine.getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);                    
                }
            }
        } catch (UnknownHostException ex) {
            System.out.println("problemi di connessione al sito");
            
        }

    }
}
