//Crear un programa que pida al usuario el radio de un círculo y le indique su área. Hago de forma infinita hasta que el usuario ingrese un numero negativo.

function areac()  {
    var radius = prompt ("Introduce el radio")
    var pi = "3.14159"
    var sum = radius*radius*pi
    alert("El área es "+sum+"")
    }