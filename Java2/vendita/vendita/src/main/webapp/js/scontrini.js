import ProdottoService from "./ProdottoService.js";
import ScontrinoTService from "./ScontrinoTService.js";
import ScontrinoRService from "./ScontrinoRService.js";
import Tabella from "./Tabella.js";

class AppScont {

    constructor() {
        this.serviceP = new ProdottoService();
        this.serviceST = new ScontrinoTService();
        this.serviceSR = new ScontrinoRService();

        this.myProd = [];

        this.appRighe = {};
        this.righe = [];

        this.bindingAll();
        this.getCampi();

        this.dtaScont.value = this.getData();

        this.mySel.onchange = this.fillText;
        this.btConfP.onclick = this.confProd();

        //riempo la select con i prodotti a magazzino
        this.getProdotti();

        this.createJson();
        
    }

    createTable() {
        this.tb = new Tabella({
            json: this.righe,
            idTabella: "tblRighe",
            classeTabella: "pure-table table-select",
            contenitore: "#contenitore",
            callbackUpdate: this.onUpdate,
            callbackDelete: this.onDelete
        });
    }
    
    createJson() {
        this.serviceSR.all()
                .then(arrJson => {
                    arrJson.forEach((json) => {
                        this.appRighe = {
                            id: json.id,
                            prezzoVL: json.prezzoVL,
                            descrizione: json.prodotto.descrizione,
                            qta: json.qta
                        };
                        this.righe.push(this.appRighe);
                    });
                    this.createTable();
                });
    }

    getProdotti() {
        this.serviceP.all()
                .then(arrJson => {
                    arrJson.forEach((json) => {
                        this.myProd.push(json);
                        this.addSelect(json);
                    })
                });

    }
    getCampi() {
        this.mySel = document.getElementById("cmbProd");
        this.przVendL = document.getElementById("przVendL");
        this.qta = document.getElementById("qta");
        this.dtaScont = document.getElementById("dataScont");
        this.btConfP = document.getElementById("btConfProd")
        this.idT = 1;
    }

    addSelect(myJson) {
        let opt = document.createElement("option");
        opt.value = myJson.id;
        opt.text = myJson.descrizione;
        this.mySel.add(opt);

    }

    bindingAll() {
        this.addSelect = this.addSelect.bind(this);
        this.getCampi = this.getCampi.bind(this);
        this.fillText = this.fillText.bind(this);
        this.getData = this.getData.bind(this);
        this.createJson = this.createJson.bind(this);
    }

    fillText() {

        let nrSel = this.mySel.selectedIndex;

        this.przVendL.value = this.myProd[nrSel].prezzoVL;
        this.qta.value = 1;


    }

    getData() {
        let toDay = new Date();
        //console.log(toDay);
        var day = toDay.getDate();
        if (day < 10)
            day = "0" + day;

        var month = toDay.getMonth() + 1;
        if (month < 10)
            month = "0" + month;

        var year = toDay.getFullYear();

        return year + '-' + month + '-' + day;
        //return "2019-05-03";
    }

    confProd() {

    }

    onUpdate(idMod) {

    }

    onDelete(idMod) {
    }

    onSave() {

    }
}
new AppScont();

