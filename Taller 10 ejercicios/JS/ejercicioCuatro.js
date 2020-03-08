//Se requiere un algoritmo para determinar, de N cantidades, cuántas son menores o iguales a cero y cuántas mayores a cero.

var N = 0;
var s1 = 0;
var s2 = 0;
var s3 = 0;

N = prompt("Ingrese la cantidades");


for (var i = 0; i <= N; i++) {
    var numeros = prompt("Ingrese los numeros: ")

    if (numeros == 0) {
        s1 = s1 + 1
    } else {
        if (numeros < 0) {
            s2 = s2 + 1
        } else {
            s3 = s3 + 1
        }
    }
}

alert("iguales a 0: " + s1 + "<br>" + "menos que 0 :" + s2 + "<br>" + "mayores que 0: " + s3)