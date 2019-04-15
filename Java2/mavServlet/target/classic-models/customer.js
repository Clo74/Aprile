
const elSearch = document.getElementById("search");
const btn = document.getElementById("invia");


btn.addEventListener("click", e => onSearch(e));
//btn.onclick = onSearch;

function onSearch(e) {
    e.preventDefault();
    fetch("http://localhost:8080/mavServlet/api/customers/search?name="+ elSearch.value)
            .then(response =>response.json())
            .then(json => creaTabellaDaJson(json,"id,name","tabAnag","tabResp","#contenitore"));
    
    
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
