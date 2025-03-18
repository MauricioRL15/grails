package com.ordenaris.pruebaBackEnd

import grails.gorm.transactions.Transactional

@Transactional
class EmpleadoService {

 def registrarEmpleado(Map params) {
        def empleado = new Empleado(params)

        if (!empleado.save(flush: true)) {
            return [error: "Error al guardar el empleado", detalles: empleado.errors]
        }

        if (params.direccion) {
            def direccion = new Direccion(params.direccion)
            direccion.empleado = empleado
            direccion.save(flush: true)
        }

        return [mensaje: "Empleado registrado exitosamente", empleado: empleado]
    }

    def listarEmpleados() {
        def empleados = Empleado.list().collect { emp ->
        [
            idEmpleado: emp.id,
            claveUnica: emp.claveUnica,
            nombres: emp.nombres,
            apellidos: emp.apellidos,
            curp: emp.curp,
            puesto: emp.puesto ?: "Sin puesto",
            jefe: emp.jefe?.id ?: "Sin jefe",
            subordinados: Subordinado.findAllByJefe(emp).collect { it.subordinado.id }
        ]
    }
    return empleados
    }

}
