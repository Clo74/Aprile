/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


document.getElementById("astronave1").style.left = (Math.random() * 100) + "px";
document.getElementById("astronave1").style.top = (Math.random() * 100) + "px";
document.getElementById("astronave2").style.left = (Math.random() * 100) + "px";
document.getElementById("astronave2").style.top = (Math.random() * 100) + "px";
document.getElementById("astronave3").style.left = (Math.random() * 100) + "px";
document.getElementById("astronave3").style.top = (Math.random() * 100) + "px";
document.getElementById("sentinella").style.top = "0px";
document.getElementById("sentinella").style.left = "0px";

var oggDaMuovere = "";
var lisColori = ["red", "blue", "green", "yellow", "brown"];
var indiceColori = 0;
var direzione = "dx";

//prendo l'elemento che risponde a .nord (qui dentro scrivo come nei css) #kdjk .fff.ff
document.querySelector("#astronave1").onclick = function () {

    document.querySelector("#astronave1").style.border = "solid 1px red";
    oddDaMuovere = document.querySelector("#astronave1");
    document.querySelector("#astronave2").style.border = "solid 1px black";
    document.querySelector("#astronave3").style.border = "solid 1px black";
};

document.querySelector("#astronave2").onclick = function () {
    document.querySelector("#astronave2").style.border = "solid 1px red";
    oddDaMuovere = document.querySelector("#astronave2");
    document.querySelector("#astronave1").style.border = "solid 1px black";
    document.querySelector("#astronave3").style.border = "solid 1px black";
};

document.querySelector("#astronave3").onclick = function () {
    document.querySelector("#astronave3").style.border = "solid 1px red";
    oddDaMuovere = document.querySelector("#astronave3");
    document.querySelector("#astronave1").style.border = "solid 1px black";
    document.querySelector("#astronave2").style.border = "solid 1px black";
};

document.querySelector(".nord").onclick = function () {

    muovi(oddDaMuovere, -5, 0);
};
document.querySelector(".sud").onclick = function () {
    muovi(oddDaMuovere, +5, 0);
};
document.querySelector(".est").onclick = function () {
    muovi(oddDaMuovere, 0, +5);
};
document.querySelector(".ovest").onclick = function () {
    muovi(oddDaMuovere, 0, -5);
};

document.querySelector(".pOk").onclick = function () {
//  document.querySelector("#campoAst").style.backgroundColor = lisColori[indiceColori];
//  indiceColori ++;
//  if (indiceColori > 4 ) {
//      indiceColori = 0;
//  }
    //sfrutto il fatto che chiedendo il resto di una divisione tra un numero e un secondo è sempre compreso tra 0 i il secondo numero
    document.querySelector("#campoAst").style.backgroundColor = lisColori[indiceColori++ % lisColori.length];
};

function muovi(oggetto, posTop, posLeft) {
    let y = parseFloat(oggetto.style.top);
    let x = parseFloat(oggetto.style.left);
    y += posTop;
    x += posLeft;

    if (y > 240)
        y = 240;
    if (y < 10)
        y = 10;
    if (x < 10)
        x = 10;


    oggetto.style.top = y + "px";
    oggetto.style.left = x + "px";
    //oggetto.style.border = "dotted 1px blue";    

}

document.querySelector("#astronave1").click();

if (direzione=="dx"&& document.getElementById("sentinella").style.left>= 500) 
    direzione="sx";

setInterval(function(){ muovi(document.getElementById("sentinella"),0,2);}, 100);
