

class Tabella {

    constructor(id, classe, nRighe, nColonne, contenitore) {
        this.id = id;
        this.nRighe = nRighe;
        this.nColonne = nColonne;
        this.classe = classe;

        this.table = document.createElement("table");
        this.contenitore = document.getElementById(contenitore);

        this._creaTab();
    }

    _creaTab() {
        this.table.className = this.classe;
        this.table.id = this.id;
        for (var i = 0; i < this.nRighe; i++) {
            this._creaRiga();
        }
        this.contenitore.appendChild(this.table);

    }

    _creaRiga() {
        this.tr = document.createElement("tr");
        this.table.appendChild(this.tr);
        for (var i = 0; i < this.nColonne; i++) {
            this._creaColonna();
        }

    }

    _creaColonna() {
        this.td = document.createElement("td");
        this.td.innerHTML = "";
        this.tr.appendChild(this.td);
    }
}
