

/*BISOGNA GESTIRE ID UTENTE CONNESSO ADESSO METTO VARIABILE CON ID=1 FISSO*/
let idUt = 1;

//dichiaro variabile globale jsonCorsi
let jsonCorsi;

//chiamo anagrafica utente connesso con id

    fetch('http://localhost:8080/nostalciac/resources/anagrafiche' + idUt)
            .then(response => {
                console.log("response...", response);
                return response.json();
            })
            .then(json => {
                document.querySelector("#contenitore").innerHTML = "";
                creaTabellaDaJsonDB(json, "nome,indirizzo,telefono,citta,email,note", "tab1", "pure-table pure-table-bordered", "#contenitore", "id", "Sedi");
                jsonSedi = json;
            })
            .then(e => caricaSelect())
            .catch(x => {
                alert("err" + x);
                console.log("err", x);
            });

