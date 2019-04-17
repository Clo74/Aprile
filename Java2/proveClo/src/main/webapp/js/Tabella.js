import {html, render} from "./../node_modules/lit-html/lit-html.js"

class Tabella {

    constructor(id, classe, nRighe, nColonne, contenitore) {
        this.id = id;
        this.nRighe = nRighe;
        this.nColonne = nColonne;
        this.classe = classe;

        this.contenitore = document.getElementById(contenitore);
        render(this._drowTab(), this.contenitore);
    }

    _drowTab() {
        return html `
               <table id=${this.id} class=${this.classe}>
                    <thead></thead>
                    <tbody>
                        ${this._creaTab()}
                    </tbody>
                    <tfoot></tfoot>
                </table>
        `;
    }

    _creaTab() {
        const itemTemp = [];
        for (var i = 0; i < this.nRighe; i++) {
            itemTemp.push(html`<tr>${this._creaCella()}</tr>`);
        }
        return itemTemp;
    }

    _creaCella() {
        const itemTemp = [];
        for (var i = 0; i < this.nColonne; i++) {
            itemTemp.push(html`<td>${i}</td>`);
        }
        return itemTemp;
    }

}

new Tabella("idTab", "classTab", 10, 10, "contenitore");