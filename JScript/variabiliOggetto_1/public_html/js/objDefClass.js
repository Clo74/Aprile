/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//definisco classi e sottoclassi

class Anagrafica {
    constructor(nome, tel, cod, sex) {
        this.nome = nome.toLowerCase();
        this.tel = tel;
        this.cod = cod * 1;
        let s = sex;
        s = s.substr(0, 1).toUpperCase();
        this.sex = s;
    }
    saluta() {
        let ris = "";
        let sesso = "";
        if (this.sex == "M") {
            sesso = "un uomo";
        } else {
            sesso = "una donna";
        }
        ris = "Salve sono " + this.nome + ", sono " + sesso + " e il mio tel. è " + this.tel;
        return ris;
    }

}

class Giocatore extends Anagrafica {
    constructor(nome, tel, cod, sex, peso, ruolo) {
        super(nome, tel, cod, sex);
        this.peso = peso;
        this.ruolo = ruolo;
        this.cod = cod;
        this.nome = "Giocatore " + nome;
        this.peso = peso;
    }

}
class Arbitro extends Anagrafica {
    constructor(nome, tel, cod, sex, categoria) {
        super(nome, tel, cod, sex);
        this.categoria = categoria;
    }
    saluta() {
        let ris = "";
        let sesso = "";
        if (this.sex == "M") {
            sesso = "un arbitro uomo";
        } else {
            sesso = "un arbitro donna";
        }
        ris = "Salve sono " + this.nome + ", sono " + sesso + " la mia categoria" + this.categoria;
        return ris;
    }

}

class Team {
    constructor(nome, citta, colori, categoria) {
        this.nome = nome;
        this.citta = citta;
        this.logo = "";
        this.colori = colori;
        this.categoria = categoria;
        this.el_gioc = [];
    }
    elencoGiocBR() {
        let txtElenco = "";
        for (let i = 0; i < this.el_gioc.length; i++) {
            txtElenco += this.el_gioc[i].nome + " - " + this.el_gioc[i].cod + this.el_gioc[i].ruolo + " <br>";
        }

        return txtElenco;
    }

    visTeam() {
        let ris = "";
        let elGioc = "";

        ris = "Squadra " + this.nome + " con sede a " + this.citta + " di " + this.categoria + " categoria";

        elGioc = this.elencoGiocBR();

        return ris + "<br>" + elGioc;
    }

    compraGioc(objGiocatore) {
        this.el_gioc.push(objGiocatore);
    }

    vendiGioc(codice) {
        for (let i = 0; i < this.el_gioc.length; i++) {
            let cod = this.el_gioc[i].codice;
            if (codice == cod) {
                this.el_gioc.splice(i, 1);
                break;
            }
        }

    }
}

class Campionato {
    constructor(stagione) {
        this.stagione = stagione;
        this.el_partite = [];
    }

    addPartita(objPartita) {
        this.el_partite.push(objPartita);
    }
    visPartite() {
        let txtElenco = "";
        let elp = "";
        let i = 0;
        //altro modo
        this.el_partite.forEach(function (myP) {
            elp += "<option value ='" + i + "'> " + myP.data + " - " + myP.sq1 + " vs " + myP.sq2 +
                    " ris. " + myP.pt1 + " - " + myP.pt2 + "</option>";
            i++;
        });
        txtElenco = "<select onchange = 'selPartita()' size='10' id='s_partite'>" + elp + "</select>";
        return txtElenco;
    }

}

class Lega {
    constructor(nome, descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.el_squadre = [];
        this.el_arbitri = [];
        this.el_campionati = [];
    }

    addCampionato(objCampionato) {
        this.el_campionati.push(objCampionato);
    }

    addSquadra(objSquadra) {
        this.el_squadre.push(objSquadra);
    }

    addArbitro(objArbitro) {
        this.el_arbitri.push(objArbitro);
    }

    elencoSqBR() {
        let txtElenco = "";
        for (let i = 0; i < this.el_squadre.length; i++) {
            txtElenco += this.el_squadre[i].nome + " - " + this.el_squadre[i].citta + " - squadra: " + (i + 1) + " <br>";
        }
        //altro modo
        this.el_squadre.forEach(function (mySq) {
            txtElenco += mySq.nome + " - " + mySq.citta + " <br>";
        })
        return txtElenco;
    }
    elencoArbitri() {
        let txtElenco = "";
        //altro modo
        this.el_arbitri.forEach(function (mySq) {
            txtElenco += mySq.saluta() + " <br>";
        })
        return txtElenco;
    }

    visLega() {
        let ris = "";
        let elSq = "";
        let elArb = "";

        ris = "Lega " + this.nome + " - " + this.descrizione;

        elSq = this.elencoSqBR();
        elArb = this.elencoArbitri();

        return ris + "<br>" + elSq + " <br> " + elArb;
    }

}

class Partita {
    constructor(data, luogo, sq1, sq2, arbitro) {
        this.data = data;
        this.luogo = luogo;
        this.sq1 = sq1;
        this.sq2 = sq2;
        this.arbitro = arbitro;
        this.risultato = "da giocare";
        this.pt1 = 0;
        this.pt2 = 0;

    }
    getRisultato() {
        //esempio va vinto mastini ..
        let ris = "";
        if (this.pt1 > this.pt2)
            ris = "Ha vinto " + this.sq1 + " con " + this.pt1 + " punti, contro " + this.sql2 + " con " + this.pt2 + " punti";
        else
            ris = "Ha vinto " + this.sq2 + " con " + this.pt2 + " punti, contro " + this.sql1 + " con " + this.pt1 + " punti";
        return ris;
    }
    
}



/*   const uomo = new Anagrafica("Mario", "012556666", 5, "M");
 //alert(uomo.saluta());
 let gioc = new Giocatore("Giuseppe", "01255554545466", 1, "M", 80, "avanti");
 //alert(gioc.saluta());
 const sq = new Team("Mastini", "Ivrea", "grigio bianco", "seconda divisione");
 
 const lega = new Lega("IFL", "Italian Football league");
 lega.addSquadra(sq);
 
 sq.compraGioc(gioc);
 gioc = new Giocatore("Pippo", "012555546", 55, "M", 80, "difesa");
 sq.compraGioc(gioc);
 gioc = new Giocatore("Pluto", "012555546", 56, "M", 90, "difesa");
 sq.compraGioc(gioc);
 gioc = new Giocatore("Paperino", "012555546", 57, "M", 100, "difesa");
 sq.compraGioc(gioc);
 gioc = new Giocatore("Topolino", "012555546", 58, "M", 50, "difesa");
 //nome, tel, cod, sex, categoria
 let arb = new Arbitro("Rossana", "0124558899", 1, "F", "super");
 lega.addArbitro(arb);
 arb = new Arbitro("Filomena", "0124558899", 1, "F", "super");
 lega.addArbitro(arb);
 arb = new Arbitro("Maria", "0124558899", 1, "F", "super");
 lega.addArbitro(arb);
 arb = new Arbitro("Giovanni", "0124558899", 1, "F", "super");
 lega.addArbitro(arb);
 
 document.getElementById("div_visualizza").innerHTML = lega.visLega();
 
 let part = new Partita("20190202", "Olbia", "mastini", "sirbons", 19);
 let camp = new Campionato("stagione 2019");
 
 part = new Partita("2019-02-02", "Olbia", "mastini", "sirbons", 19);
 camp.addPartita(part);
 
 part = new Partita("2019-02-10", "Ivrea", "mastini", "torino", 19);
 camp.addPartita(part);
 
 part = new Partita("2019-02-28", "Ivrea", "torino", "sirbons", 19);
 camp.addPartita(part);
 
 //aggiungo il campionato alla lega
 lega.addCampionato(camp);
 lega.el_campionati[0].addPartita(part);
 
 document.getElementById("div_visualizza2").innerHTML = camp.visPartite();
 
 
 */
