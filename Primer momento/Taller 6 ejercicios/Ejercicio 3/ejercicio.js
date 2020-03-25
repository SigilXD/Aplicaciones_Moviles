var interesGanado = 0;
var inversionBanco = 0;
var dineroFinal = 0;
var tasaInteres = 0;

while (true) {
    tasaInteres = prompt("Ingrese tasa de interes: ");
    if (!isNaN(tasaInteres)){
        break;
    }
}

while (true) {
    inversionBanco = prompt("Ingrese dinero por concepto de inversión: ");
    if (!isNaN(inversionBanco)){
        break;
    }
}

var interesGanado = (inversionBanco * tasaInteres) / 100;

if (interesGanado >= 7000) {
    var dineroFinal = interesGanado + inversionBanco;
    alert("El dinero inicial + su interes es:" + " " + dineroFinal);
}
else if (interesGanado < 7000) {
    alert("El interes no supera los 7000")
}