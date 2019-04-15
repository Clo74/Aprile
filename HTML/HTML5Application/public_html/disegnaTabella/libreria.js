/***
 * 
 * @param {type} nrRighe
 * @param {type} nrColonne
 * @param {type} idTab passare id della tabella
 * @param {type} classeTab passare classe della tabella
 * @returns {String} ritorna una stringa con codice html della tabella
 */
function costruisciTabella(nrRighe, nrColonne, idTab, classeTab) {
    
    
    let strTabella = "<table";
    if (idTab != "") 
        strTabella += " id='" + idTab + "'";
    if (classeTab != "") 
        strTabella += "' class = '" + classeTab + "' ";
    strTabella += ">";
    for (let i = 1; i <= nrRighe ; i++) {
        strTabella += "<tr> ";
        for (let j = 1; j <= nrColonne; j++) {
            strTabella += "<td class='tdTab'> </td>";
        }
        strTabella += "</tr> ";
    }
    strTabella += "</table>";
    
    return strTabella;
}