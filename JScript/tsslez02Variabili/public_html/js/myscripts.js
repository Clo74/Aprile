/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var numNum1;
var numNum2;
var numRis;
var numTot = 0;
var okNum;

function isVuota(txtVerif) {

    if (txtVerif.length == 0) {
        return true;
    } else {
        return false;
    }
}

function verDati() {
    //verifico i dati dall'utente e ritorno vero se sono numeri 
    if (isNaN(numNum1) || isNaN(numNum2) || isVuota(numNum1) || isVuota(numNum2)) {
        return false;
    } else {

        return true;

    }

}

function inputDati() {
    numNum1 = document.getElementById("in_num1").value;
    numNum2 = document.getElementById("in_num2").value;

    okNum = verDati();
    // se i dati sono numeri 
    if (okNum == true) {
        //trasformo in numeri quello che prendo da video
        numNum1 = parseFloat(numNum1);
        numNum2 = parseFloat(numNum2);
    } else {
        alert("Inserire solo dati numerici!!!")
    }


}
function outputDati() {
    document.getElementById("div_risult").innerHTML = numRis;
    document.getElementById("sp_Mont").innerHTML = numTot;

    //document.getElementById("in_num1").value = "0";
    //document.getElementById("in_num2").value = "0";

}

function calcola(txtOperatore) {
    inputDati();

    if (okNum) {

        if (txtOperatore == "+")
            numRis = numNum1 + numNum2;
        if (txtOperatore == "-")
            numRis = numNum1 - numNum2;
        if (txtOperatore == "*")
            numRis = numNum1 * numNum2;
        if (txtOperatore == "/")
            numRis = numNum1 / numNum2;
        if (txtOperatore == "radice")
            numRis = Math.sqrt(numNum1);

        numTot = numTot + numRis;
        outputDati();
    }


}