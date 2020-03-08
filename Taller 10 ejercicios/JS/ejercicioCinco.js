//Realice un algoritmo para generar e imprimir los números pares e impares que se encuentran entre 0 y 100. Además muestre la multiplicación de todos estos.

/* for (var i = 0; i <= 100; i++){
    if ( i%2 == 0){
        document.write ( i+" ")
    }
} */

while (true){
    tipoNumero = prompt ("Ingrese pares o impares");
    if ( tipoNumero == "pares" || tipoNumero == "impares"){
        break;
    }
}

switch(tipoNumero){
    case "pares":
        for (var i = 0; i <= 100; i++){
            if ( i%2 == 0){
                document.write ( i+" ")
            }
        }
    break;

    case "impares":
        for (var i = 1; i <= 100; i++){
            if ( i%2 == 1){
                document.write ( i+" ")
            }
        }
    break;
}