package com.ordenaris.pruebaBackEnd
import java.io.Serializable


class Subordinado implements Serializable {

    Empleado jefe
    Empleado subordinado

    static belongsTo = [jefe: Empleado, subordinado: Empleado]

    static constraints = {
        subordinado nullable: false
    }

    static mapping = {
        id composite: ['jefe', 'subordinado']
        version false
    }

}
