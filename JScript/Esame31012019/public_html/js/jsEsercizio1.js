/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var elProdotti = [];
var numProd = 0;
var numTot = 0;
var numMedia = 0;
var numMin = 0;
var numMax = 0;


function scriviFrase() {
    let nomeCogn = "";
    let d = new Date();
    let ris = "";
    let dd = "";
    let mm = "";
    let aa = "";

    nomeCogn = document.getElementById("nomeCognome").value;
    dd = d.getDate();
    mm = d.getMonth() + 1;
    aa = d.getFullYear();


    ris = "Oggi è il " + dd + "/" + mm + "/" + aa + " ciao " + nomeCogn + " Buona Giornata !!";

    document.getElementById("fraseEs1").innerHTML = ris;


}

function spostaDx() {
    let nomeApp = "";
    let nome1 = "";
    let nome2 = "";
    let nome3 = "";

    nome1 = document.getElementById("nome1").value;
    nome2 = document.getElementById("nome2").value;
    nome3 = document.getElementById("nome3").value;

    nomeApp = nome1;
    nome1 = nome3;
    nome3 = nome2;
    nome2 = nomeApp;

    document.getElementById("nome1").value = nome1;
    document.getElementById("nome2").value = nome2;
    document.getElementById("nome3").value = nome3;


}

function addProdotto() {
    let txtApp = "";
    let numCosto = 0;

    txtApp = document.getElementById("prodotto").value;
    numCosto = document.getElementById("costo").value*1;
    txtApp += " -- " + numCosto;
    
    //tengo il conto totale
    numTot += numCosto;
    //tengo il conto del numero di prodotti
    numProd += 1;
    //calcolo la media
    numMedia= numTot/numProd;
    
    if (numMin == 0){
        numMin = numCosto;
    }
    
    if(numMin>numCosto){
        numMin = numCosto;
    }
    if(numMax<numCosto) {
        numMax=numCosto;
    }
    
    elProdotti.push(txtApp);
    txtApp= arrayBR() + "-------------- <br> Totale: " + numTot + " <br> Media: " + numMedia + " <br> Minimo: " + numMin + " <br> Massimo: "  + numMax;
    
    document.getElementById("elProdotti").innerHTML =  txtApp;
    
}

function arrayBR(){
    //leggo l'array e ritorno il testo
    let txtApp = "";
    
    for (let i = 0; i < elProdotti.length; i++) {
        txtApp  += elProdotti[i] + " <br>";
    }
    
    return txtApp;
}