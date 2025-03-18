package com.ordenaris.pruebaBackEnd

class Direccion {
    Empleado empleado
    String calle
    String noExterior
    String noInterior
    String colonia
    String municipio
    String estado
    String pais
    

    static constraints = {
        noInterior nullable: true, maxSize: 10
        calle maxSize: 100
        noExterior maxSize: 10
        colonia maxSize: 50
        municipio maxSize: 50
        estado maxSize: 50
        pais maxSize: 50
    }
}
