/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
document.querySelector("#sfondo #butOk").onclick = function() {
    document.querySelector("#sfondo").style.display = "none";
};

document.querySelectorAll(".blocca").forEach(function(elm,i){elm.style.color="red"});
document.querySelector(".blocca").onclick = function() {
    document.querySelector("#sfondo").style.display="block";
};
