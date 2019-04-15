/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
document.querySelectorAll(".pBlocca").forEach(function(elm,i){elm.style.color="red"});


function nascondiPopUp() {
    document.querySelector("#sfondo").style.display = "none";
}
function mostraPopUp() {
    document.querySelector("#sfondo").style.display="block";
}

//se mettessi le parentesi dopo nascondiPopUp e come se chiamassi una funzione che mi 
//restituisce qualcosa che assegno a onclick
document.querySelector("#sfondo #butOk").onclick = nascondiPopUp;

document.querySelectorAll(".pBlocca").forEach(function(elm,i){
    elm.onclick = mostraPopUp;
});  
 



