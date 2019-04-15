/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function scrivHello() {
    let nome = "";
    let cognome = "";
    
    nome = document.getElementById("in_nome").value;
    cognome = document.getElementById("in_cogn").value;
    
    document.getElementById("sp_hello").innerHTML = "HELLO " + nome + " " + cognome;
    
    
}

