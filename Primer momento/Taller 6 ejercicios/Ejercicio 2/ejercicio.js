var tipoActividad = "";
var pesoPersona = 70;
var dormir = 1.08;
var sentado = 1.66;
var minActividad = 0;

while (true){
    tipoActividad = prompt ("Ingrese si fue Dormir o Sentado");
    if ( tipoActividad == "Dormir" || tipoActividad == "Sentado"){
        break;
    }
}

while (true){
    minActividad = prompt ("Ingrese los minutos de la actividad");
    if (!isNaN(minActividad)){
        break;
    }
}

switch (tipoActividad){
    case "Dormir":
        var caloriasConsumidas = minActividad * 1.08;
        alert ("Consumio: " + caloriasConsumidas);
    break;

    case "Sentado":
        var caloriasConsumidas = minActividad * 1.66;
        alert ("Consumio: " + caloriasConsumidas);
    break;
}