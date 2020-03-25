// Se requiere un algoritmo para obtener la suma de diez cantidades mediante la utilización de un ciclo for.

var cantidad = [];
var suma = 0;

for (var i = 0; i < 10; i++) {
    cantidad[i] = Number(prompt("Ingrese las cantidades"));
    suma = suma + cantidad[i];
}

alert("La cantidad en total ingresada es:" + suma);