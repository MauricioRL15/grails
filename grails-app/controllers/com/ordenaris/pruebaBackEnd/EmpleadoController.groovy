package com.ordenaris.pruebaBackEnd


import grails.rest.*
import grails.converters.JSON

class EmpleadoController {

    EmpleadoService empleadoService

	static responseFormats = ['json', 'xml']
	
    def registrar() {
        def jsonParams = request.JSON
        def resultado = empleadoService.registrarEmpleado(jsonParams)
        render resultado as JSON
    }

    def listar() {
        def empleados = empleadoService.listarEmpleados()
        render empleados as JSON
    }
}
