
//var arNomi = [];
//var arSoldi = [];
var numTotDon = 0;
var arNomi = ["Mario","Barbara","Giovanni","Francesca"];
var arSoldi = [45,55,22,125];

function addDonazioni() {

    arNomi.push(document.getElementById("in_Nome").value);
    arSoldi.push(document.getElementById("in_Soldi").value);
    prepOutput();
}

function undoDon() {
    arNomi.pop();
    arSoldi.pop();

    prepOutput();
}

function cancella() {
    let numCanc = 0;

    numCanc = document.getElementById("in_Elem").value - 1;

    arNomi.splice(numCanc, 1);
    arSoldi.splice(numCanc, 1);

    prepOutput();
}

function modifica() {
    let numCanc = 0;

    numCanc = document.getElementById("in_Elem").value - 1;
    arNomi[numCanc] = document.getElementById("in_Nome").value;
    arSoldi[numCanc] = document.getElementById("in_Soldi").value;

    prepOutput();

}

function cerca() {
    let txtNome = "";
    let i = 0;
    let bolTrovato = false;
    
    txtNome = document.getElementById("in_Nome").value;
    
    while(bolTrovato == false && i < arNomi.length) {
        if (txtNome == arNomi[i]) {
            bolTrovato = true;
            
        } else {
            i++;
        }
        
    }    
    
    if(bolTrovato== true) {
        document.getElementById("div_ricerca").innerHTML = arNomi[i] + " ha donato " + arSoldi[i];
        //document.getElementById("div_ricerca").style = ""
        //let txtOgg = "don" + i;
        document.getElementById("don" + i).style.color = "red";
       
    } else {
        document.getElementById("div_ricerca").innerHTML = "Nessun donatore con questo nome!";
    }
    
}

function prepOutput() {
    let txtTesto = "";
    let numTot = 0;

    for (i = 0; i < arNomi.length; i++) {
        txtTesto += "<span id='don" + i + "'> #" + (i + 1) + "--> <b>" + arNomi[i] + "</b> : " + arSoldi[i] + "</span><br>";
        numTot += arSoldi[i] * 1;
    }

    document.getElementById("div_donaz").innerHTML = txtTesto;
    document.getElementById("spTot").innerHTML = numTot;
    numTotDon = numTot;
    document.getElementById("in_Elem").max = arNomi.length;
    document.getElementById("in_Elem").min = 1;
    
}