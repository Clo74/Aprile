
let tessera1 = "";
let tessera2 = "";

let nrRighe = 4;
let nrColonne = 5;
let strTabella = "";

let dietroTess = "immagini/dietroTess.png";

/*carico una arrau con le immagini*/
let arrImm = ["immagini/Arrabbiato.jpeg", "immagini/Bacio.jpeg", "immagini/Canguro.jpeg", "immagini/Cuccioli.jpeg", "immagini/Lupo.jpeg", "immagini/Occhioni.jpeg",
    "immagini/Pulcini.jpeg", "immagini/Riccio.jpeg", "immagini/Scatola.jpeg", "immagini/Scoiattolo.jpeg"]

let arrApp = [];

arrImm.forEach((elm, k) => {
    arrApp[k] = 0;
})

/**
 * Ho due array nel secondo mi tengo quante volte ho usato la tessera
 */

strTabella = costruisciTabella(nrRighe, nrColonne, "miaTab", "classTabMia");

document.querySelector("#contenitoreTab").innerHTML = strTabella;
let ok = 0;
document.querySelectorAll("#miaTab tr td").forEach(function (elm, i) {
    while (ok == 0) {
        let pos = Math.floor(Math.random() * 10);
        if (arrApp[pos] <= 1) {
            elm.tessera = "<img src='" + arrImm[pos] + "' />";
            elm.innerHTML = "<img src='" + dietroTess + "' />";
            elm.selezionata = "";
            ok = 1;
            arrApp[pos]++;
        }
    }
    ok = 0;
    elm.onclick = giraTess;
});

/*document.querySelectorAll("#tabCol tr td").forEach(function(elm,i) {
 elm.onclick = prendiCol;});
 
 */

function costruisciTabella(nrRighe, nrColonne, idTab, classeTab) {


    let strTabella = "<table";
    if (idTab != "")
        strTabella += " id='" + idTab + "'";
    if (classeTab != "")
        strTabella += "' class = '" + classeTab + "' ";
    strTabella += ">";
    for (let i = 1; i <= nrRighe; i++) {
        strTabella += "<tr> ";
        for (let j = 1; j <= nrColonne; j++) {
            strTabella += "<td class='tdTab'> </td>";
        }
        strTabella += "</tr> ";
    }
    strTabella += "</table>";

    return strTabella;
}


//click sul td che contiene immagmne
function giraTess() {
    /**
     * gira la tessera su cui clicco assegnando la sua immagine
     * 
     */
    let uguali = false;
    this.innerHTML = this.tessera;
    if (this.selezionata == "X") 
        return;
    
    //selezionata contine "" quando non è girata X quando è una delle ultime selezionate O quando ho trovato due uguali
    if (tessera1 == "") {
        tessera1 = this.tessera;
        this.selezionata = "X";
    } else {
        if (tessera2 == "") {
            tessera2 = this.tessera;
            this.selezionata = "X";
            uguali = confronta();
            if (uguali == false) {
                //metto un div per bloccare l'utente e non far cliccare
                document.querySelector(".bloccoSch").style.display = "block";
                //rigiro le due tessere errate dopo un intervallo
                setTimeout(function () {
                    document.querySelectorAll("#miaTab tr td").forEach(function (elm, i) {
                        if (elm.selezionata == "X" && elm.selezionata != "O") {
                            elm.innerHTML = "<img src='" + dietroTess + "' />";
                            elm.selezionata = "";
                        }
                    });
                    document.querySelector(".bloccoSch").style.display = "none";
                }, 2000);

            } else {
                //se ho azzeccato due tessere metto selezionata a O
                document.querySelectorAll("#miaTab tr td").forEach(function (elm, i) {
                    if (elm.selezionata == "X")
                        elm.selezionata = "O";

                });
            }

        }
        tessera1 = "";
        tessera2 = "";
        getEnd();
    }
}
/*controllo se tutti i td sono stati girati*/
function getEnd(){
    let finito = true;
    document.querySelectorAll("#miaTab tr td").forEach(function (elm, i) {
        if (elm.selezionata != "O")
            finito=false;

    });
    if (finito == true) {
        alert("Hai finito");
        
    }
   
}

function confronta() {
    if (tessera1 == tessera2)
        return true;
    else
        return false;

}
