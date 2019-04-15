var coloreSelezionato="red";

var listaColori="red,aqua,pink,red,green,blue,black,white";

document.querySelector("#pStart").onclick = function() {
    console.log("click");
    creoAmbienteGioco();
};

function creoAmbienteGioco(){
    generaTabellaDisegno();
    programmaClickTabellaDisegno();
    generaTavolozza();
    coloraTavolozza();
    programmaClickTavolozza();
};

/***
 * crea una tabella 20 * 20 e la inserisce nel div intContT1
 * la tabella si chiamerà tabella1
 * @returns {undefined}
 */function generaTabellaDisegno(){
    let html = costruisciTabella(20,20,"tabella1","tab");
    document.querySelector("#divContT1").innerHTML = html;
};

/**
 * programma il click di tutte le celle della tabella disegno
 * @returns {undefined}
 */
function programmaClickTabellaDisegno(){
    document.querySelectorAll("#tabella1 tr td").forEach(function(elm,k){
        elm.onclick = function(){
            console.log("click su cella");
            this.style.backgroundColor = "red";
        }
    })
};

function generaTavolozza() {
    
};

function coloraTavolozza() {
    
};

function programmaClickTavolozza(){
    
}