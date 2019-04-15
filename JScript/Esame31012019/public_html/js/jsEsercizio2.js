/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var txtMonCorr = "0.1,0.2,0.5,1,2";
var flTotPort = 0;

function invTest() {
    let txtCorr1 = "Lorella";
    let txtCorr2 = "Michelle";
    let txtCorr3 = "Rita";
    let txtCorr4 = "Ettore";

    let txtRisp1 = "";
    let txtRisp2 = "";
    let txtRisp3 = "";
    let txtRisp4 = "";

    let numPunti = 0;
    let okCol1 = false;
    let okCol2 = false;
    let txtRisp = "";
    
    txtRisp1 = document.getElementById("domanda1").value;
    txtRisp2 = document.getElementById("domanda2").value;
    txtRisp3 = document.getElementById("domanda3").value;
    txtRisp4 = document.getElementById("domanda4").value;

    if (txtRisp1 == txtCorr1) {
        numPunti += 10;
        okCol1 = true;
    }
    if (txtRisp2 == txtCorr2) {
        numPunti += 10;
        okCol1 = true;
    }
    if (txtRisp3 == txtCorr3) {
        numPunti += 20;
        okCol2 = true;
    }
    if (txtRisp4 == txtCorr4) {
        numPunti += 30;
        okCol2 = true;
    }

    if (numPunti >= 40 && okCol1 == true && okCol2 == true) 
        txtRisp = "Bravo sei promosso hai totalizzato " + numPunti;
    else
        txtRisp = "Mi spiace sei bocciato hai totalizzato " + numPunti;
    
    document.getElementById("dvPromosso").innerHTML = txtRisp;
}

function insMoneta(){
    let flMoneta = "";
    
    flMoneta = document.getElementById("inMonete").value;
    
    if (!(txtMonCorr.indexOf(flMoneta) == -1)) {
        portafoglio(flMoneta,"+");
    }   else
    {
        alert("Moneta non valida!");
    }
    
}

function preMoneta() {
    let flMoneta = "";
    
    flMoneta = document.getElementById("inMonete").value*1;
    
    if (!(txtMonCorr.indexOf(flMoneta) == -1)) {
        portafoglio(flMoneta,"-");
    }   else
    {
        alert("Moneta non valida!");
    }
}

function portafoglio(moneta,operazione) {
    let txtRisp = "";
    let flAppPrel = 0;
    
    flTotPort = flTotPort*1;
    flAppPrel = flTotPort;
    
    moneta = parseFloat(moneta);
    if (operazione == "-") {
        flTotPort = flTotPort - moneta;
    } else {
        flTotPort = flTotPort + moneta;
    }
    flTotPort = flTotPort.toFixed(1);
    
    if (flTotPort<0) {
        flTotPort=0;
        alert("E' stato possibile prelevare solo" + flAppPrel);
    }
    txtRisp= flTotPort + " euro";
    
    document.getElementById("dvPortafoglio").innerHTML = txtRisp;
    
}
