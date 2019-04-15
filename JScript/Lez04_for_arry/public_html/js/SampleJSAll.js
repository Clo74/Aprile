
var arrValutazioni = [];

function addVoti(){
    
    let intVoto = document.getElementById("in_voto").value;
    arrValutazioni.push(intVoto);
    
   
    
}

function mediaVoti() {
    let intTot = 0;
    
    for (i = 0;i<arrValutazioni.length;i++) {
        intTot += arrValutazioni[i] * 1;
       
    }
    let intMedia = intTot / arrValutazioni.length;
    
    document.getElementById("div_media").innerHTML = intMedia;
 
}