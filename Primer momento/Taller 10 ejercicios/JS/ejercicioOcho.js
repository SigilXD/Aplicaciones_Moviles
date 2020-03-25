//Escribir un algoritmo que solicite de un equipo de futbol la cantidad de partidos ganados, partidos perdidos y partidos empate. Finalmente deberá mostrar el puntaje obtenido teniendo en cuenta que por partido ganado se suman 3 puntos, empate 1 y perdidos 0.


var pGanados = 0;
var pEmpatados = 0;
var pPerdidos = 0;
var equipo = "";

while (true) {
    equipo = prompt("ingrese el nombre de su equipo: ");
    break;
}

while (true) {
    pGanados = prompt("ingrese la cantidad de partidos ganados: ");
    break;
}

while (true) {
    pEmpatados = prompt("ingrese la cantidad de partidos empatados: ");
    break;
}

while (true) {
    pPerdidos = prompt("ingrese la cantidad de partidos perdidos: ");
    break;
}

var part = pGanados + pEmpatados + pPerdidos;
var puntosG = pGanados * 3;
var puntosE = pEmpatados * 1;
var puntosAcum = puntosG + puntosE;


alert("el equipo: " + equipo + "jugo " + part + "partidos")
alert("Gano " + pGanados + " " + "partidos")
alert("Empato " + pEmpatados + " " + "partidos")
alert("Perdio " + pPerdidos + " " + "partidos")
alert("Puntos acumulados " + puntosAcum)