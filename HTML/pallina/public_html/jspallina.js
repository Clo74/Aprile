/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


let obj = document.createElement("div");
obj.classList.add("pallina");
obj.style.backgroundColor = "black";

let obj2 = document.createElement("div");
obj2.classList.add("pallina");
obj2.style.backgroundColor = "brown";
obj2.style.animationDelay = "1s";

document.querySelector("body").appendChild(obj);
document.querySelector("body").insertBefore(obj2,obj);
document.querySelector("body").removeChild(obj2);

