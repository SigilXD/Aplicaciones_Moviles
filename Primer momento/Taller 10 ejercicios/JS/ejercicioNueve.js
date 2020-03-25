/* se tiene registrado la producción (unidades) logrados por un operario a lo largo dela semana (lunes a s'"ado). ;la"ore un algoritmo que nos muestre o nos diga si eloperario reci"ir' incentivos sa"iendo que el promedio de producción mínima es de 100unidades*/

var pLunes = 0;
var pMartes = 0;
var pMiercoles = 0;
var pJueves = 0;
var pSabado = 0;
var pTotal = 0;
var pPromedia = 0;


//parseInt o parseFloat para convertir la variable String a un entero o numero decimal

pLunes = parseInt(prompt("ingrese produccion del dia lunes: "));
pMartes = parseInt(prompt("ingrese produccion del dia Martes: "));
pMiercoles = parseInt(prompt("ingrese produccion del dia Miercoles: "));
pJueves = parseInt(prompt("ingrese produccion del dia Jueves: "));
pViernes = parseInt(prompt("ingrese produccion del dia Viernes: "));
pSabado = parseInt(prompt("ingrese produccion del dia Sabado: "));


var pTotal = pLunes + pMartes + pMiercoles + pJueves + pViernes + pSabado;
alert("La produccion total es: " + pTotal);


pPromedia = pTotal / 6;
alert("la produccion promedia es: " + pPromedia);

if (pPromedia >= 100) {
    alert("El trabajador recibe incentivos.")
} else {
    alert("El trabajador no recibira incentivos.")
}