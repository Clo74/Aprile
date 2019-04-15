/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// il body riceve un evento e con proprietà which restituisce il numero
document.querySelectorAll(".astronave").forEach(function (elm, i) {
    elm.style.left = (Math.random() * 100) + "px";
    elm.style.top = (Math.random() * 100) + "px";
    elm.style.height = "50px";
    elm.style.width = "50px";
    elm.miarotazione = 0;
    elm.onclick = usaAstronave;
});

document.querySelector(".astronave").className += " astronaveSel";

var oggDaMuovere;
//imposto come prima astronave la numero 1
//oggDaMuovere = document.querySelectorAll("#astronave1");
//document.querySelectorAll("#astronave1").style.border= "solid 1px red"; 

function usaAstronave() {
    console.log("usaAstronave")
    document.querySelector(".astronaveSel").style.border = "solid 1px black";
    
    document.querySelector(".astronaveSel").classList.remove("astronaveSel");
    
    oggDaMuovere = this;
    this.classList.add("astronaveSel");
    this.style.border = "solid 1px red";
    

}

document.querySelector("body").onkeydown = function (e) {
    let tasto = e.which;
    //document.getElementById("astronave1").style.miarotazione = "rotatez(360deg)"; 
    console.log(e);
    let ctrlok = e.ctrlKey;
    let shiftok = e.shiftKey;

    document.querySelector("#tasto").innerHTML = tasto;
    switch (tasto) {
        case 37:
            if (ctrlok) {
                ridimensiona(oggDaMuovere, 0, -5);
            }
            if (shiftok) {
                ruota(oggDaMuovere, -10);
            }
            if (!shiftok && !ctrlok) {
                muovi(oggDaMuovere, 0, -5);
            }
            break;
        case 38:
            if (ctrlok) {
                ridimensiona(oggDaMuovere, -5, 0);
            }
            if (shiftok) {
                ruota(oggDaMuovere, 10);
            }
            if (!shiftok && !ctrlok) {
                muovi(oggDaMuovere, -5, 0);
            }
            break;
        case 39:
            if (ctrlok) {
                ridimensiona(oggDaMuovere, 0, 5);
            }
            if (shiftok) {
                ruota(oggDaMuovere, 10);
            }
            if (!shiftok && !ctrlok) {
                muovi(oggDaMuovere, 0, 5);
            }

            break;
        case 40:
            if (ctrlok) {
                ridimensiona(oggDaMuovere, 5, 0);
            }
            if (shiftok) {
                ruota(oggDaMuovere, -10);
            }
            if (!shiftok && !ctrlok) {
                muovi(oggDaMuovere, 5, 0);
            }
            break;

    }
    //ruota(oggDaMuovere,10);
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

function ridimensiona(oggetto, altezza, larghezza) {
    let y = parseFloat(oggetto.style.height);
    let x = parseFloat(oggetto.style.width);
    y += altezza;
    x += larghezza;

    oggetto.style.height = y + "px";
    oggetto.style.width = x + "px";
    //oggetto.style.border = "dotted 1px blue";    

}

function ruota(oggetto, quanto) {
    let posiniz = parseFloat(oggetto.miarotazione);

    posiniz += quanto;

    oggetto.style.transform = "rotatez(" + posiniz + "deg)";
    oggetto.miarotazione = posiniz;
    console.log(oggetto, quanto, posiniz);
    //oggetto.transform: rotatex(360deg);
}