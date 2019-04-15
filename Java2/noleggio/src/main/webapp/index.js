/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


fetch("http://localhost:8080/noleggio/resources/biciclette")
        .then(response => response.json())
        .then(data => {creaTabellaDaJson(data, "id,nr_telaio,cat_prodotto", "tabOff", "tabResp", "#contenitore");
        renderData(data);
        });

function renderData(data) {
    //per ogni json viene chiamata la funzione renderBici
    data.map(bici => renderBici(bici))
            .forEach(el => document.body.appendChild(el));
}

function renderBici(bici) {
    //crea un tag p per ogni 
    const el = document.createElement("p");
    el.innerHTML = `id --> ${bici.id} categoria --> ${bici.cat_prodotto} nr_telaio --> ${bici.nr_telaio}`;
    return el
}

function creaTabellaDaJson(oggJson, listaCampi, idTabella, classeTabella, contenitore) {

    //pulisco il contenitore
    document.querySelector(contenitore).innerHTML = "";

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