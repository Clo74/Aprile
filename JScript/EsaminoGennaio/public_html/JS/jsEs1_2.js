/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var nome = "";
var cognome = "";
var arrVoti = [];
var arrStud = [];

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

    if ( isNaN(intVoto) || isNaN(intVotoMin) ) {
        window.alert("Inserisci il voto ottenuto e il voto minimo necessario per la promozione Solo Numeri");
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

function scrivMaiusc() {
    let strFrase = "";

    strFrase = document.getElementById("sp_prom").innerHTML;
    if (strFrase != "") {
        document.getElementById("sp_promMasc").innerHTML = convMaiusc(strFrase);
    }

    
}

function convMaiusc(frase) {

    return frase.toUpperCase().trim();
}

function aggVoto() {
    /**let intVoto = 0;
    let flMedia = 0;
    intVoto = document.getElementById("in_voto").value;

    if (intVoto == "") {
        window.alert("Inserisci il voto ottenuto");
    } else {
        intVoto = intVoto * 1;
        arrVoti.push(intVoto);
        flMedia = eseguiMedia(arrVoti);
        document.getElementById("sp_media").innerHTML = "Num. voti = " + arrVoti.length + " media: " + flMedia;
    }
    **/
    let strFrase = false;
    strFrase = caricaArrVoti(document.getElementById("in_voto").value);
    if (strFrase != "") {
        document.getElementById("sp_media").innerHTML = strFrase;
    }
}

function caricaArrVoti(intVotoAgg) {
    //carica array di voti restituisce la frase con numero voti caricati e la media
    let flMedia = 0;
    let strFraseMedia = "";
    if (intVotoAgg == "") {
        window.alert("Inserisci il voto ottenuto");
        return "";
    } else {
        intVotoAgg = intVotoAgg * 1;
        arrVoti.push(intVotoAgg);
        flMedia = eseguiMedia(arrVoti);
        strFraseMedia = "Num. voti = " + arrVoti.length + " media: " + flMedia;
        return strFraseMedia;
    }

}
function caricaArrStud(strStudAgg) {
    //carica l'array degli studenti
    if (strStudAgg == "") {
        window.alert("Inserisci il cognome dello studente");
        return false;
    } else {
        arrStud.push(strStudAgg);
        return true;
    }

}

function eseguiMedia(arrayNum) {
    let flmedia = 0;
    if (arrayNum.length > 0) {
        for (let i = 0; i < arrayNum.length; i++) {
            flmedia += arrayNum[i] * 1;
        }
        flmedia = flmedia / arrayNum.length;
        return flmedia;
    } else {
        return 0;
    }
}

function aggStudVoto() {
    //carico l'array voti
    let strFraseArr = "";
    let bolCarc = false;
    let strFraseMedia = "";
    
    strFraseMedia = caricaArrVoti(document.getElementById("in_voto").value);
    //carico l'array studenti
    bolCarc = caricaArrStud(document.getElementById("in_cogn").value);
    if (bolCarc == true) {
          for (var i = 0; i < arrVoti.length; i++) {
                strFraseArr += "#" + (i+1) + " " + arrStud[i] + " --- " + arrVoti[i] + "<br/>";
        }
        let strMigliore = trovaMigliore(arrStud,arrVoti);
        document.getElementById("div_elStudVoti").innerHTML = strFraseMedia + "<br/>" + strFraseArr + "<br/>" + strMigliore

    }
}

function trovaMigliore(arrNomi,arrNumeri) {
    let flNumMax = 0;
    let strNome = "";
    for (var i = 0; i < arrNumeri.length; i++) {
        if (flNumMax < arrNumeri[i]) {
            flNumMax = arrNumeri[i];
            strNome = arrNomi[i] + " con: " + arrNumeri[i];
        }
    }
    
    return strNome;
}