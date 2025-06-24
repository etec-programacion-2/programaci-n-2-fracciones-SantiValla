package org.example

class Fraccion(
    private var _numerador : Int,
    private var _denominador: Int
) {
      var numerador: Int = 0
       get() = field
       set(value) { field = value }
   
   var denominador: Int = 1
       get() = field
       set(value) { 
           if (value == 0) throw IllegalArgumentException("El denominador no puede ser cero")
           field = value 
       }

    fun mostrar() {
        println("${toString()}") 
    }


    override fun toString(): String {
       return "${_numerador} / ${_denominador}"              
    }
    operator fun plus(otro: Fraccion): Fraccion {
        return Fraccion(
           
        )
    }

    operator fun plus(otro: Fraccion): Fraccion {
        
        return Fraccion(_numerador = numerador, _denominador = denominador)
    }
}