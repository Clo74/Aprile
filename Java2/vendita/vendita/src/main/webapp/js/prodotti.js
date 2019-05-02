import ProdottoService from "./ProdottoService.js";
import Tabella from "./Tabella.js";

class App {

    constructor() {
        this.service = new ProdottoService();

        this.bindingAll();

        this.getCampi();

        this.btOnSave.onclick = this.onSave;

        this.tb = new Tabella({
            service: this.service,
            idTabella: "tblProdotti",
            classeTabella: "pure-table table-select",
            contenitore: "#contenitore",
            callbackUpdate: this.onUpdate,
            callbackDelete: this.onDelete
        });
    }

    getCampi() {
        this.tipo = document.querySelector("#tipo");
        this.desc = document.querySelector("#desc");
        this.przAcq = document.querySelector("#przAcq");
        this.przVendN = document.querySelector("#przVendN");
        this.iva = document.querySelector("#iva");
        this.przVendL = document.querySelector("#przVendL");
        this.qta = document.querySelector("#qta");
        this.btOnSave = document.querySelector("#btConfirm");
        this.idRec = document.querySelector("#idRec");

    }

    bindingAll() {
        this.onUpdate = this.onUpdate.bind(this);
        this.onDelete = this.onDelete.bind(this);
        this.onSave = this.onSave.bind(this);
        this.getCampi = this.getCampi.bind(this);
    }

    onUpdate(idMod) {
        //leggo il record con id=idMod e carico i campi a video
        this.service.find(idMod)
                .then(json => {
                    this.idRec.value = idMod;
                    this.tipo.value = json.tipo;
                    this.desc.value = json.descrizione;
                    this.przAcq.value = json.prezzoA;
                    this.przVendN.value = json.prezzoVN;
                    this.iva.value = json.iva;
                    this.przVendL.value = json.prezzoVL;
                    this.qta.value = json.qta;
                });

    }

    onDelete(idMod) {

        if (confirm("Confermi di voler cancellare?")) {
            this.service.delete(idMod)
                    .then(response => this.tb.reloadData());
        }
    }

    onSave() {
        
        let json = {
            tipo: this.tipo.value,
            descrizione: this.desc.value,
            prezzoA: this.przAcq.value,
            prezzoVN: this.przVendN.value,
            iva: this.iva.value,
            prezzoVL: this.przVendL.value,
            qta: this.qta.value
        };

        if (this.idRec.value !== "" && this.idRec.value !== null) {
            //se c'è id a video devo modicare il record
            this.service.update(this.idRec.value, json)
                    .then(response => this.tb.reloadData());
        } else {
            //se non c'è l'id devo inserire
            this.service.create(json)
                    .then(response => this.tb.reloadData());
        }

    }
}
new App();

