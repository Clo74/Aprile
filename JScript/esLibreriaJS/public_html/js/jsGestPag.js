/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var arrNomi = [];

function caricaArr(){
    let txtNome = "";
    let txtVoto = "";
    
    txtNome = document.getElementById("in_nome").value;
    txtVoto = document.getElementById("in_voto").value;
    
    //carico l'array
    arrNomi.push(txtNome);
    
    //visualizzo l'array
    //visArrElNum();
    
    //document.getElementById("div_ris").innerHTML = visArrTabella(arrNomi);
    document.getElementById("div_ris").innerHTML  = potenza((txtNome*1),(txtVoto*1));
}

function visArrElNum(arArray){
    //prepara l'array a forma di elenco numerato
    let txtTesto = "";
    txtTesto = "<ol> Elenco Alunni";

    for (var i = 0; i < arArray.length; i++) {
        txtTesto += "<li> " + arArray[i] + "</li>";
    }
    txtTesto += "</ol>";
    
    return txtTesto;
}

function visArrTabella(arArray){
    //prepara l'array a forma di elenco numerato
    let txtTesto = "";
    txtTesto = "<table border = '1'> <caption> Elenco ";

    for (var i = 0; i < arArray.length; i++) {
        txtTesto += "<tr> <td> " + arArray[i] +  "</td> </tr>" ;
    }
    txtTesto += "</table>";
    
    return txtTesto;
    
}

function visArrBR(arArray){
    //prepara l'array a forma di elenco numerato
    let txtTesto = "";

    for (var i = 0; i < arArray.length; i++) {
        txtTesto += "#" + (i+1) + " " + arArray[i] + " <br/>";
    }

    
    return txtTesto;
    
}

function cubo(flNumero) {
    let flRis = 0;
    
    flRis = flNumero * flNumero * flNumero;
    
    return flRis;
    
}

function potenza (flNumero, intPot){
    let flRis = 1;
    
    for (var i = 1; i <= intPot; i++) {
        flRis = flRis * flNumero;
    }
    return flRis;
    
}