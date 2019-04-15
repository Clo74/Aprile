/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tss
 */

@WebServlet("/hello")
public class Messages extends HttpServlet{

    /*quando estendo una classe a httservlet il compilatore cerca a quale link corrisponde con @webServlet*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*il metodo doGet riceve una richiesta contenuta in variabile req
        e risponde interagendo con l'oggetto resp*/
        System.out.println("ho ricevuto una richiesta...");
        System.out.println(req.getParameter("id"));
        
        /*creo una variabile getWriter che ha dei metodi tra cui println*/
        PrintWriter wr = resp.getWriter();
        wr.println("<h1>Hello from service..ciao</h1>");
    }

    
}
