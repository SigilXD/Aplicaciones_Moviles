var numPersonas = 0;
var tipoPlato = 0;
var hambuerguesa = 0;
var perro = 0;
var salchipapa = 0;
var chorizo = 0;
var valorHam = 10000;
var valorPerro = 8000;
var valorSalchipapa = 6000;
var valorChorizo = 7000;
var totalCompra = 0;

while (true){
    numPersonas = prompt ("Ingrese cantidad de personas");
    if (!isNaN(numPersonas)){
        break;
    }
}

while (true){
    minActividad = prompt ("Ingrese los minutos de la actividad");
    if (!isNaN(minActividad)){
        break;
    }
}

switch (tipoPlato){
    case "hamburguesa":
        var pedidoHamb = hamburguesa++;
        alert ();
    break;

    case "perro":
        var pedidoPerro = perro++;
        alert ();
    break;

    case "salchipapa":
        var pedidoSalchipapa = salchipapa++;
        alert ();
    break;

    case "chorizo":
        var chorizo = chorizo++;
        alert ();
    break;
}