/*
Un obrero necesita calcular su salario semanal, el cual se obtiene de la siguiente manera:
• Si trabaja 40 horas o menos se le paga $16 por hora
• Si trabaja más de 40 horas se le paga $16 por cada una de las primeras 40 horas y $20
por cada hora extra.
*/

var horasTrabajo=0;
var valorPagar=0;

while (true){
    horasTrabajo=prompt("Ingrese la cantidad de horas trabajadas");
    if (!isNaN(horasTrabajo)){
        break;
    }
}

if (horasTrabajo <= 40){
    var valorPagar = horasTrabajo * 16;
    alert ("Valor a cancelar:" + valorPagar);
}

else if (horasTrabajo > 40){
    valorPagar = (40 * 16) + ((horasTrabajo - 40) * 20);
    alert ("Total a cancelar: " + valorPagar)
}