package org.example

class Fraccion(
    private var _numerador : Int,
    private var _denominador: Int
) {
      var numerador: Int
       get() = _numerador
       set(value) { _numerador = value }
   
   var denominador: Int
       get() = _denominador
       set(value) { 
           if (value == 0) throw IllegalArgumentException("El denominador no puede ser cero")
           _denominador = value 
       }

    fun mostrar() {
        println("${toString()}") 
    }


    override fun toString(): String {
       return "${_numerador} / ${_denominador}"              
    }

    operator fun plus(otro: Fraccion): Fraccion {
        val sumnumerador = this.numerador * otro.denominador + this.denominador * otro.numerador
        val sumdenominador = this.denominador * otro.denominador
        return Fraccion(sumnumerador, sumdenominador)   
    } 
    operator fun minus(otro: Fraccion): Fraccion {
        val resnumerador = this.numerador * otro.denominador - this.denominador * otro.numerador
        val resdenominador = this.denominador * otro.denominador
        return Fraccion(resnumerador, resdenominador)
    

}
}