import NegozioService from "./NegozioService.js";
import Tabella from "./Tabella.js";

class App {

    constructor() {
        this.service = new NegozioService();

        this.bindingAll();

        this.getCampi();

        this.btOnSave.onclick = this.onSave;

        this.tb = new Tabella({
            service: this.service,
            idTabella: "tblNegozi",
            classeTabella: "pure-table table-select",
            contenitore: "#contenitore",
            callbackUpdate: this.onUpdate,
            callbackDelete: this.onDelete
        });
    }

    bindingAll() {
        this.onUpdate = this.onUpdate.bind(this);
        this.onDelete = this.onDelete.bind(this);
        this.onSave = this.onSave.bind(this);
        this.getCampi = this.getCampi.bind(this);
    }

    getCampi() {
        this.desc = document.querySelector("#descNeg");
        this.address = document.querySelector("#address");
        this.mail = document.querySelector("#mail");
        this.tel = document.querySelector("#tel");
        this.btOnSave = document.querySelector("#btConfirm");
        this.idRec = document.querySelector("#idRec");
    }

    onUpdate(idMod) {
        console.log("id riga su modifica" + idMod);
        //leggo il record con id=idMod e carico i campi a video
        this.service.find(idMod)
                .then(json => {
                    this.idRec.value = idMod;
                    this.desc.value = json.descrizione;
                    this.address.value = json.indirizzo;
                    this.tel.value = json.tel;
                    this.mail.value = json.email;
                });

    }

    onDelete(idMod) {

        if (confirm("Confermi di voler cancellare?")) {
            this.service.delete(idMod)
                    .then(response => this.tb.reloadData());

        }
    }

    onSave() {
        //let idRec = document.querySelector("#idRec").value;
        if (this.idRec.value !== "" && this.idRec.value !== null) {
            //se c'è id a video devo modicare il record
            this.service.update(this.idRec.value, {
                descrizione: this.desc.value,
                indirizzo: this.address.value,
                tel: this.tel.value,
                email: this.mail.value
            })
                    .then(response => this.tb.reloadData());
        } else {
            //se non c'è l'id devo inserire
            this.service.create({
                descrizione: this.desc.value,
                indirizzo: this.address.value,
                tel: this.tel.value,
                email: this.mail.value
            })
                    .then(response => this.tb.reloadData());
        }

    }
}
new App();

