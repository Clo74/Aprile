import {render, html} from "../node_modules/lit-html/lit-html.js"
        /**
         * --properties--
         * data
         * service
         * contenitore
         * id
         * classe
         
         */

        export default class Tabella {

    constructor(properties) {
        this.prop = properties;
        this.bindings();
        this.loadData();

    }
    bindings() {
        this._modifyRow = this._modifyRow.bind(this);
        this._delRow = this._delRow.bind(this);
    }

    loadData() {
        this.prop.service.all()
                .then(json => {
                    this.data = json;
                    this.readFields();
                    this.el = document.querySelector(this.prop.contenitore);
                    render(this._createTab(), this.el);
                });
    }

    readFields() {
        const [first] = this.data;
        this.fields = Reflect.ownKeys(first);
    }

    _createTab() {
        return html `
            <table class=${this.prop.classeTabella} id=${this.prop.idTabella} idRow="0">
                <thead>
                    <tr>${this.fields.map(f => this._createTop(f))}<th colspan="2"></th></tr>
                </thead>
                <tbody>
                    ${this.data.map(anag => this._createRow(anag))}
                </tbody>
                <tfoot>
        
                </tfoot>
            </table>
`
    }

    reloadData() {
        this.prop.service.all()
                .then(json => {
                    this.data = json;
                    render(html `${this.data.map(anag => this._createRow(anag))}`, document.querySelector("tbody"));
                });

    }

    _createRow(anag) {
        return html `
            <tr>${this.fields
                .map(v => Reflect.get(anag, v))
                .map(v => html`<td>${v}</td>`)}
                <td><button idRec=${Reflect.get(anag, "id")} @click=${this._modifyRow}>Modifica</button></td>
                <td><button idRec=${Reflect.get(anag, "id")} @click=${this._delRow}>Cancella</button></td>
                </tr>
            `

    }

    _createTop(value) {
        return html `
            <th>${value}</th>
            `
    }

    _modifyRow(e) {

        this.prop.callbackUpdate(e.toElement.getAttribute("idRec"));
    }

    _delRow(e) {

        this.prop.callbackDelete(e.toElement.getAttribute("idRec"));
    }
}

