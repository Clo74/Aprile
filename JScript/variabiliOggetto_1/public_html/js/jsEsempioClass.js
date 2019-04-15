/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var lega;
function init() {
//creo la lega
    lega = new Lega("IFL", "Italian Football league");
//creo un arbitro
    let arb = new Arbitro("Rossana", "0124558899", 19, "F", "super");
    lega.addArbitro(arb);

//creo giocatori e squadre
    let sq = new Team("Mastini", "Ivrea", "grigio bianco", "seconda divisione");
    let gioc = new Giocatore("Pippo", "012555546", 55, "M", 80, "difesa");
    sq.compraGioc(gioc);
    gioc = new Giocatore("Pluto", "012555546", 56, "M", 90, "difesa");
    sq.compraGioc(gioc);
    gioc = new Giocatore("Paperino", "012555546", 57, "M", 100, "difesa");
    sq.compraGioc(gioc);
    gioc = new Giocatore("Topolino", "012555546", 58, "M", 50, "difesa");
    sq.compraGioc(gioc);

//assegno la squadra alla lega
    lega.addSquadra(sq);

//creo altra squadra con giocatori
    sq = new Team("Sirbon", "Cagliari", "rossi bianco", "seconda divisione");
    gioc = new Giocatore("Piras", "02555546", 30, "M", 80, "difesa");
    sq.compraGioc(gioc);
    gioc = new Giocatore("Aio", "02455", 31, "M", 90, "attacco");
    sq.compraGioc(gioc);
    gioc = new Giocatore("Garau", "231000252", 32, "M", 100, "attacco");
    sq.compraGioc(gioc);
    gioc = new Giocatore("Zio paperone", "012555546", 33, "M", 50, "difesa");
    sq.compraGioc(gioc);

//assegno la squadra alla lega
    lega.addSquadra(sq);

//creo altra squadra con giocatori
    sq = new Team("Lancieri", "Novara", "azzurro", "seconda divisione");
    gioc = new Giocatore("Maria", "02555546", 20, "F", 80, "difesa");
    sq.compraGioc(gioc);
    gioc = new Giocatore("Filippa", "02455", 21, "F", 90, "attacco");
    sq.compraGioc(gioc);
    gioc = new Giocatore("Genoveffa", "231000252", 22, "F", 100, "attacco");
    sq.compraGioc(gioc);
    gioc = new Giocatore("Patrizia", "012555546", 23, "F", 50, "difesa");
    sq.compraGioc(gioc);

//assegno la squadra alla lega
    lega.addSquadra(sq);

//CREO le partite
    camp = new Campionato("2019");
    let part = new Partita("20190202", "Olbia", "Mastini", "Sirbons", 19);
    camp.addPartita(part);

    part = new Partita("20190215", "Ivrea", "Sirbons", "Mastini", 19);
    camp.addPartita(part);

    part = new Partita("20190302", "Novara", "Lanceri", "Sirbons", 19);
    camp.addPartita(part);

    part = new Partita("20190315", "Cagliari", "Sirbons", "Lanceri", 19);
    camp.addPartita(part);

    part = new Partita("20190402", "Ivrea", "Mastini", "Lanceri", 19);
    camp.addPartita(part);

    part = new Partita("20190415", "Novara", "Lanceri", "Mastini", 19);
    camp.addPartita(part);

    lega.addCampionato(camp);

    document.getElementById("div_visualizza").innerHTML = lega.el_campionati[0].visPartite();
}

function selPartita() {
    let ris = 0;

    return ris;

}
function addRisultato() {
    let pt1 = document.getElementById("in_pt1").value * 1;
    let pt2 = document.getElementById("in_pt2").value * 1;
    let indexP = document.getElementById("s_partite").value;

    let camp = lega.el_campionati[0];
    let part = camp.el_partite[indexP];

    part.pt1 = pt1;
    part.pt2 = pt2;

    document.getElementById("div_visualizza").innerHTML = lega.el_campionati[0].visPartite();

}
function addGiocatore() {

//alert(sq.visTeam());

    let nome = "";
    let tel = "";
    let sesso = "";

    nome = document.getElementById("in_nome").value;
    tel = document.getElementById("in_telefono").value;
    if (document.getElementById("in_sesso_F").checked)
        sesso = "F";
    else
        sesso = "M";


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
}





