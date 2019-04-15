/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

let colori = ["red","yellow","green"];
let j=0;
function cambiaSfondo() {
    document.querySelectorAll(".divGen").forEach(function(elm,i) {
       elm.style.backgroundColor = colori[j];
       j++;
       if(j>2) j=0;
    });
    
};
function cambiaSfondoThis() {
    this.style.backgroundColor = colori[j];
       j++;
       if(j>2) j=0;

}
document.querySelectorAll(".divGen").forEach(function(elm,i) {
    elm.onclick = cambiaSfondoThis;
});
