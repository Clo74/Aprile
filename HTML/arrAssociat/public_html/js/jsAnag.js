/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// var table = document.getElementById("tabAnagrafica");
// var row = table.insertRow(1);
// var cell1 = row.insertCell(0);
// var cell2 = row.insertCell(1);
// var cell3 = row.insertCell(2);
// cell1.innerHTML = j.cognome;
// cell2.innerHTML = j.nome;
// cell3.innerHTML = j.email;

//j.forEach(function (record, k) {
//    let riga = document.createElement("tr");
//    let cellaNome = document.createElement("td");
//    let cellaCognome = document.createElement("td");
//    let cellaEmail = document.createElement("td");
//
//    cellaNome.innerHTML = record.nome;
//    cellaCognome.innerHTML = record.cognome;
//    cellaEmail.innerHTML = record.email;
//
//    riga.appendChild(cellaNome);
//    riga.appendChild(cellaCognome);
//    riga.appendChild(cellaEmail);
//
//    document.querySelector("#tabAnagrafica tbody").appendChild(riga);
//})
/*
 
 j.forEach(function (record, k)
 {
 let primoUl = document.createElement("ul");
 let primoLi = document.createElement("li");
 primoLi.innerHTML = record.cognome;
 primoUl.appendChild(primoLi);
 
 let secondoUl = document.createElement("ul");
 primoLi.appendChild(secondoUl);
 
 let secondoLi = document.createElement("li");
 secondoLi.innerHTML = record.nome;
 secondoUl.appendChild(secondoLi);
 
 let terzoLi = document.createElement("li");
 terzoLi.innerHTML = record.email;
 secondoUl.appendChild(terzoLi);
 
 
 
 document.querySelector("#listaNomi").appendChild(primoUl);
 }
 );
 */

/***
 * 
 * @param {type} oggJson
 * @param {type} listaCampi
 * @param {type} idTabella
 * @param {type} classeTabella
 * @param {type} contenitore
 * @returns {undefined}
 */

function creaTabellaDaJson(oggJson, listaCampi, idTabella, classeTabella, contenitore) {
    let tabella = document.createElement("table");
    tabella.id = idTabella;
    tabella.className = classeTabella;

    //creo un array da una stringa con campi divisi da ,
    let vCampi = listaCampi.split(",")
    //riga intestazione
    let tHead = document.createElement("thead");
    let riga = document.createElement("tr");
    vCampi.forEach(function (campo, i) {
        let th = document.createElement("th");
        th.innerHTML = campo;
        riga.append(th);
    });
    tabella.append(tHead);
    tHead.append(riga);

    //creo
    let tBody = document.createElement("tbody");

    oggJson.forEach(function (record, i) {
        let rigaRecord = document.createElement("tr");
        vCampi.forEach(function (campo, j) {
            let cella = document.createElement("td");
            cella.innerHTML = record[campo];
            rigaRecord.append(cella);

        });

        tBody.append(rigaRecord);
    });
    tabella.append(tBody);


    //append della tabella al contenitore
    document.querySelector(contenitore).append(tabella);

}

//creaTabellaDaJson(j,"cognome,email,nome","tabAnagrafica","tabella","body");

function carica() {
    let x = new XMLHttpRequest();

    x.onloadstart = function (e) {
        console.log("onloadstart", e.loaded, e.total);
    }
    x.onprogress = function (e) {
        console.log("onprogress", e.loaded, e.total);
    }
    x.onabort = function (e) {
        console.log("onabort", e.loaded, e.total);
    };
    x.onerror = function (e) {
        console.log("onerror", e.loaded, e.total);
    };
    x.onreadystatechange = function (e) {
        //console.log("readystatechange",e.)
    };

    x.onload = function (e) {
        console.log("load", e.loaded, e.total);
        console.log("dati", x.responseText);
        //trasformo la risposta in un oggetto json
        let oggJson = JSON.parse(x.responseText);
        creaTabellaDaJson(oggJson, "nome,cognome,email,citta", "tabAnagrafica", "tabella", "body");
    };
    x.ontimeout = function (e) {
        console.log("ontimeout", e.loaded, e.total);
    };
    x.onloadend = function (e) {
        console.log("onloadend", e.loaded, e.total);
    };
    x.onreadystatechange = function (e) {
        console.log("onreadystatechange", e.loaded, e.total);
    };

    x.open("get", "js/jasAnag.json", true);

    x.send();

}

carica();