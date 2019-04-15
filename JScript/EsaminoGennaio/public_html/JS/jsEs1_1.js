/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var nome = "";
var cognome = "";

function scrivHello() {
    
    nome = document.getElementById("in_nome").value;
    cognome = document.getElementById("in_cogn").value;
    
    if (nome == "" || cognome == "") {
        window.alert("Inserisci il tuo nome e cognome");
    } else {
        document.getElementById("sp_hello").innerHTML = "HELLO " + nome + " " + cognome;
        document.getElementById("div_voto").style.display = "block";
    }
    
}

function scrivProm() {
    let intVoto = 0;
    let intVotoMin = 0;
    
    intVoto = document.getElementById("in_voto").value;
    intVotoMin = document.getElementById("in_suff").value;
    
    if (intVoto == "" || intVotoMin == "") {
        window.alert("Inserisci il voto ottenuto e il voto minimo necessario per la promozione");
    } else {
            intVoto = intVoto * 1;
            intVotoMin = intVotoMin * 1;
            if (intVoto >= intVotoMin) {
                document.getElementById("sp_prom").innerHTML = nome + " " + cognome + " " + "COMPLIMENTI SEI PROMOSSO!";
                document.getElementById("sp_prom").style = "color:black";
            } else {
                document.getElementById("sp_prom").innerHTML = nome + " " + cognome + " " + "MI SPIACE SEI BOCCIATO!";
                document.getElementById("sp_prom").style = "color:red";
            }
    
    }
}

