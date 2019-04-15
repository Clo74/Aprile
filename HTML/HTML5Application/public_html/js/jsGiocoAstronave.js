/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


document.getElementById("astronave").style.left = (Math.random() * 100) + "px";
document.getElementById("astronave").style.top = (Math.random() * 100) + "px";

var lisColori = ["red","blue","green","yellow","brown"];
var indiceColori = 0;
//prendo l'elemento che risponde a .nord (qui dentro scrivo come nei css) #kdjk .fff.ff
document.querySelector(".nord").onclick = function () {
    let y = parseFloat(document.getElementById("astronave").style.top);
    y -= 5;
    if (y<10) {
        y=10;
    }

    document.getElementById("astronave").style.top = y + "px";
    document.getElementById("astronave").style.border = "dotted 1px blue";    
    console.log("nord", y);

};
document.querySelector(".sud").onclick = function () {
    let y = parseFloat(document.getElementById("astronave").style.top);
    y += 5;
    //let hcampo = parseFloat(document.getElementById("campoAst").style.height);
    let hcampo = 250;
    if (y > (hcampo - 10)) {
        y = 240;
    }

    document.getElementById("astronave").style.top = y + "px";
    document.getElementById("astronave").style.border = "dotted 1px green";
    console.log("sud", y);

};
document.querySelector(".est").onclick = function () {
    let y = parseFloat(document.getElementById("astronave").style.left);
    y += 5;

    document.getElementById("astronave").style.left = y + "px";
    document.getElementById("astronave").style.border = "dotted 1px red";    
    console.log("est", y);

};
document.querySelector(".ovest").onclick = function () {
    let y = parseFloat(document.getElementById("astronave").style.left);
    y -= 5;
    if (y<10) {
        y=10;
    }    

    document.getElementById("astronave").style.left = y + "px";
    document.getElementById("astronave").style.border = "dotted 1px grey";    
    console.log("ovest", y);

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