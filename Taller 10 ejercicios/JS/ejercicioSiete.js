//algoritmo que solicite el numero de respuestas correctas, incorrectas y en blanco (punto 3, segunda parte)


var cantRC = 0;
var cantRB = 0;
var cantRI = 0;
var puntaje = 0;



cantRC = prompt("Ingrese la cantidad de respuestas correctas: ");

cantRB = prompt("Ingrese la cantidad de respuestas en blanco: ");

cantRI = prompt("Ingrese la cantidad de respuestas incorrectas: ");

puntaje = cantRC * 4 + cantRI * -1;
alert("Puntaje final obtenido:" + puntaje);