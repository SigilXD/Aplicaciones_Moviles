var cont = 1;
var edad_Alumno = 0;
var sum_Edad = 0;
var num_Edad = 0;
var pro_Edad = 0;
var num_Alumnos = 0;

num_Alumnos = prompt("Ingrese el numero de alumnos: ");
cont = 1;
sum_Edad = 0;

while (cont <= num_Alumnos) {
        edad_Alumno = prompt("Ingrese la edad: ");
        sum_Edad = sum_Edad + edad_Alumno;
        cont = cont + 1;
        pro_Edad = sum_Edad / num_Alumnos;
        document.write(pro_Edad);
        break;
}

/* num_Alumnos = prompt("Ingrese el numero de alumnos: ")
sum_Edad = 0;

    for (i = 0; i <= num_Alumnos; i++) {
        num_Edad = prompt("Ingrese la edad: ")
        sum_Edad = sum_Edad + edad_Alumno
        pro_Edad = sum_Edad / num_Alumnos
        alert("El promedio de edad es: " + pro_Edad)
    } */