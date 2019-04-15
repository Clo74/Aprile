const msg = "testo messaggio";

const primo = "prima riga della tabella";
const secondo = "seconda riga della tabella";
const terzo = "terza riga della tabella";

console.log(`ecco il messaggio ${msg}`);

document.getElementById("prova").innerHTML = `ecco il messaggio ${msg}`;



document.getElementById("prova").innerHTML = 
        `<table style="border: solid black 1px" > 
            <tr>
                <td>${primo}</td>
                <td>${secondo}</td>
                <td>${terzo}</td>
            </tr>
         </table>
`;
