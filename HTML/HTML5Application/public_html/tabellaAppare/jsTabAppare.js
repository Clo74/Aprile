/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


document.querySelector("#bAppTab").onclick = appareTab;
var colore;

function appareTab(){
    let nrRighe = 0;
    let nrColonne = 0;
    let strTabella = "";
    nrRighe = document.querySelector("#inNrRighe").value;
    nrColonne = document.querySelector("#inNrColonne").value;
    
    strTabella = costruisciTabella(nrRighe,nrColonne,"miaTab","classTabMia");
    
    document.querySelector("#contenitoreTab").innerHTML = strTabella;
    
    strTabella = costruisciTabella(4,4,"tabCol","classTabCol");
    document.querySelector("#contenitoreColori").innerHTML = strTabella;
    
    riempiColori();
    
    document.querySelectorAll("#miaTab tr td").forEach(function(elm,i) {
        elm.onclick = coloraTd;});

    document.querySelectorAll("#tabCol tr td").forEach(function(elm,i) {
        elm.onclick = prendiCol;});
    
    
   
    
}

function prendiCol(){
    //prende il colore dell'oggetto su cui sono
     colore = this.style.backgroundColor;
}

function coloraTd(){
    colore = document.querySelector("#inColor").value;
    
    this.style.backgroundColor = colore;
}
/***
 * 
 * @param {type} nrRighe
 * @param {type} nrColonne
 * @param {type} idTab passare id della tabella
 * @param {type} classeTab passare classe della tabella
 * @returns {String} ritorna una stringa con codice html della tabella
 */
function costruisciTabella(nrRighe, nrColonne, idTab, classeTab) {
    
    
    let strTabella = "<table";
    if (idTab != "") 
        strTabella += " id='" + idTab + "'";
    if (classeTab != "") 
        strTabella += "' class = '" + classeTab + "' ";
    strTabella += ">";
    for (let i = 1; i <= nrRighe ; i++) {
        strTabella += "<tr> ";
        for (let j = 1; j <= nrColonne; j++) {
            strTabella += "<td class='tdTab'> </td>";
        }
        strTabella += "</tr> ";
    }
    strTabella += "</table>";
    
    return strTabella;
}

function riempiColori(){
    //let i = 0;
    let elColori = ["lightYellow","yellow","lightRed","red","lightGreen","green","lightBlue","blue","lightYellow","yellow","lightRed","red","lightGreen","green","lightBlue","blue"];
    document.querySelectorAll("#tabCol tr td").forEach(function(elm,i) {
       /* j++;
        if (j>=elColori.length) 
            j = 0;*/
        elm.style.backgroundColor = elColori[i];});
}