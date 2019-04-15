
class Scritta {
    constructor(tasto) {
        this.tasto = tasto;
        this.ul = document.createElement("ul");
        this.li = document.createElement("li");
        this.contenitore = document.getElementById("contenitore");

        this.scriviRis();
    }

    scriviRis() {
        this.li.innerHTML = `hai premuto il tasto ${String.fromCharCode(this.tasto)} 
                                con codice: ${this.tasto}`;
        this.ul.appendChild(this.li);
        this.contenitore.appendChild(this.ul);
    }
}

//document.querySelector("body").onkeydown = function (e) {
//    new Scritta(e.which);
//};

new Tabella("idTab","classTab",10,10,"contenitore");