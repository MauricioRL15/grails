package com.ordenaris.pruebaBackEnd

class Empleado {

    String claveUnica
    String nombres
    String apellidos
    String curp
    String puesto
    Empleado jefe
    int version

    static hasMany = [subordinados: Subordinado]

    static constraints = {
        claveUnica unique: true, maxSize: 12
        nombres nullable: false, maxSize: 50
        apellidos nullable: false, maxSize: 50
        curp unique: true, nullable: false, maxSize: 18
        puesto nullable: true, maxSize: 50
        jefe nullable: true
    }

    static mapping = {
        version false // Deshabilitar la columna "version"
    }
}
