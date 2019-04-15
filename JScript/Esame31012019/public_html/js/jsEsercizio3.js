/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class PrevPav {
    constructor(larg, lung, cosMq, nome) {
        this.larg = larg;
        this.lung = lung;
        this.cosMq = cosMq;
        this.nome = nome;
        this.cosTot = 0;
    }
    prezzoFinale() {
        let txtRis = "";
        let cosTot = 0;
        //cos tot

        this.cosTot = (this.larg * this.lung) * this.cosMq;

        txtRis = this.nome + ": <br> dimensioni: " + this.larg + " X " + this.lung + " <br> Costo al mq: " + this.cosMq + " euro <br> Costo totale: " + this.cosTot + " euro";
        return txtRis;

    }
    rigaPreventivo() {
        let txtRis = "";
        let cosTot = 0;
        //cos tot

        this.cosTot = (this.larg * this.lung) * this.cosMq;

        txtRis = this.nome + " -- " + this.larg + " X " + this.lung + " Costo: " + this.cosTot + " euro";
        return txtRis;

    }
}

class PrevCliente {
    constructor(nome) {
        this.nome = nome;
        this.elPrev = [];
    }
    getPrev() {
        let txtRis = "";
        
        txtRis = "Cliente: " + this.nome;

        for (let i = 0; i < this.elPrev.length; i++) {
            txtRis += this.elPrev[i].rigaPreventivo() + " <br> "
            
        }
        
    }
}

var newCli;
var pavCorr;

function creaPav() {
    let txtRis = "";
    
    txtRis = prepPrev();
    document.getElementById("dvPrev").innerHTML = txtRis;

}

function creaCli() {
    let txtNome = "";

    txtNome = document.getElementById("inNomeCli").value;

    newCli = new PrevCliente(txtNome);


}

function aggPrevCli() {
    let txtRis = "";
    let numTot = 0;
    let txtApp = "";

    //richiamo la funzione che prepara l'oggetto pavimento
    txtApp = prepPrev();

    //faccio il push dell'oggetto pavimento nell'oggetto cliente
    newCli.elPrev.push(pavCorr);

    //scrivo l'elenco dei preventivi a video

    txtRis = "Cliente: " + newCli.nome + " <br> Preventivi: <br> ";

    for (let i = 0; i < newCli.elPrev.length; i++) {
        txtRis+= newCli.elPrev[i].rigaPreventivo() + " <br>";
        numTot+=newCli.elPrev[i].cosTot;
    }

    txtRis += "Totale Preventivi: " + numTot + " euro";
    
    document.getElementById("dvElPrev").innerHTML = txtRis;
    
}
function prepPrev() {
    let numLarg = 0;
    let numLung = 0;
    let numCosMq = 0;
    let txtNome = "";
    let txtRis = "";

    numLarg = document.getElementById("inLarg").value;
    numLung = document.getElementById("inLung").value;
    numCosMq = document.getElementById("inCosMq").value;
    txtNome = document.getElementById("inTipoPav").value;



    pavCorr = new PrevPav(numLarg, numLung, numCosMq, txtNome);

    txtRis = pavCorr.prezzoFinale();
    
    return txtRis;
}