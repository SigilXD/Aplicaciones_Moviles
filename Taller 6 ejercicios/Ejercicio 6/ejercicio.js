window.onload = function(){
    numero = prompt("Introduce un número: ");

    for (i=0; i<=10; i++){
        document.write(numero + "x" + i + ": " + numero * i + "<br>");
    }
}