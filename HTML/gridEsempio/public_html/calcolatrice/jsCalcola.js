
/*dichiaro variabili globali*/
var strOperaz = "";
var bolNum = false;
/*--------------*/

document.querySelectorAll(".num").forEach(function (elm, i) {
    elm.style.backgroundColor = "red";
});

document.querySelectorAll(".oper").forEach(function (elm, i) {
    elm.style.backgroundColor = "blue";
});

document.querySelector(".invio").onclick = calcola;
document.querySelectorAll(".num").forEach(function (elm, i) {
    elm.onclick = getNum;
});

document.querySelectorAll(".oper").forEach(function (elm, i) {
    elm.onclick = getOper;
});

document.querySelectorAll(".punto").forEach(function (elm, i) {
    elm.onclick = getPunto;
});

document.querySelector(".block").onclick = function () {
    strOperaz = "";
    bolNum = false;
    document.querySelector("#risultato").innerHTML = "";
};

document.querySelector("body").onkeydown = function (e) {
    let tasto = e.which;
    
    switch (tasto) {
        case 96:
            getTasto("0");
            bolNum = true; 
            break;
        case 97:
            getTasto("1");
            bolNum = true; 
            break;
        case 98:
            getTasto("2");
            bolNum = true; 
            break;
        case 99:
            getTasto("3");
            bolNum = true; 
            break;
        case 100:
            getTasto("4");
            bolNum = true; 
            break;
        case 101:
            getTasto("5");
            bolNum = true; 
            break;
        case 102:
            getTasto("6");
            bolNum = true; 
            break;
        case 103:
            getTasto("7");
            bolNum = true; 
            break;
        case 104:
            getTasto("8");
            bolNum = true; 
            break;
        case 105:
            getTasto("9");
            bolNum = true; 
            break;
    }
    
};

function calcola() {
    if (strOperaz != "") {
        try {
            var ris = eval(strOperaz);
            document.querySelector("#risultato").innerHTML = ris;
        } catch (err) {
            document.querySelector("#risultato").innerHTML = "Operazione non valida " + strOperaz;

        } finally {
            strOperaz = "";
            bolNum = false;
        }
    }
}

function getNum() {
    getTasto(this.innerHTML);
}
 
function getTasto(tasto) {
    if (bolNum == true) {
        document.querySelector("#risultato").innerHTML += tasto;
    } else
    {
        document.querySelector("#risultato").innerHTML = tasto;
    }
    strOperaz += tasto;
    bolNum = true;    
}

function getOper() {
    document.querySelector("#risultato").innerHTML = this.innerHTML;
    strOperaz += this.innerHTML;
    bolNum = false;
}

function getPunto() {
    if (bolNum == true) {
        document.querySelector("#risultato").innerHTML += this.innerHTML;
        strOperaz += this.innerHTML;
    } else
    {
        document.querySelector("#risultato").innerHTML = "0.";
        strOperaz += "0.";
    }
    bolNum = true;
}