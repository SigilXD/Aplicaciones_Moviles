//diferencia de hermano (punto 10 segunda parte)

var nombre1 = "";
var nombre2 = "";
var edad1 = 0;
var edad2 = 0;
var mayor = 0;
var diferencia = 0;

while (true) {
    nombre1 = prompt("ingrese el nombre del hermano 1: ");
    edad1 = prompt("ingrese la edad del hermano 1: ")
    break;
}

while (true) {
    nombre2 = prompt("ingrese el nombre del hermano 2: ");
    edad2 = prompt("ingrese la edad del hermano 2: ")
    break;
}

if (edad1 == edad2) {
    alert("no deben de tener la misma edad")

} else if (edad1 > edad2) {
    mayor = edad1;
    alert("la edad mayor es: " + mayor)
    diferencia = edad1 - edad2;
    alert("la diferencia de años es: " + diferencia)

} else {
    mayor = edad2;
    alert("la edad mayor es: " + mayor)
    diferencia = edad2 - edad1;
    alert("la diferencia de años es: " + diferencia)
}
