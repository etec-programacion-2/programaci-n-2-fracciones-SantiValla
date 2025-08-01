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
         if (otro.numerador == 0) {
        throw IllegalArgumentException("No se puede dividir por una fracción con numerador cero")}
        val sumnumerador = this.numerador * otro.denominador + this.denominador * otro.numerador
        val sumdenominador = this.denominador * otro.denominador
        val resultado = Fraccion(sumnumerador, sumdenominador)
        resultado.simplificar()  
        return resultado 
    } 
    operator fun minus(otro: Fraccion): Fraccion {
         if (otro.numerador == 0) {
        throw IllegalArgumentException("No se puede dividir por una fracción con numerador cero")}
        val resnumerador = this.numerador * otro.denominador - this.denominador * otro.numerador
        val resdenominador = this.denominador * otro.denominador
        val resultado = Fraccion(resnumerador, resdenominador)
        resultado.simplificar()  
        return resultado 
        }
    operator fun times(otro: Fraccion): Fraccion {
         if (otro.numerador == 0) {
        throw IllegalArgumentException("No se puede dividir por una fracción con numerador cero")}
        val mulnumerador = this.numerador * otro.numerador
        val muldenominador = this.denominador * otro.denominador
        val resultado = Fraccion(mulnumerador, muldenominador)
        resultado.simplificar()  
        return resultado 
        }
    operator fun div(otro: Fraccion): Fraccion {
         if (otro.numerador == 0) {
        throw IllegalArgumentException("No se puede dividir por una fracción con numerador cero")
    }
        val divnumerador = this.numerador * otro.denominador
        val divdenominador = this.denominador * otro.numerador
        val resultado = Fraccion(divnumerador, divdenominador)
        resultado.simplificar()  
        return resultado 
    } 
    private fun simplificar() {
        val mcd = calcularMCD(kotlin.math.abs(numerador), kotlin.math.abs(denominador))
        if (mcd > 1) {
            _numerador /= mcd
            _denominador /= mcd
        }

        if (_denominador < 0) {
            _numerador = -_numerador
            _denominador = -_denominador
        }
    }    private fun calcularMCD(a: Int, b: Int): Int {
        return if (b == 0) a else calcularMCD(b, a % b)

}
    operator fun compareTo(otro: Fraccion): Int {
        return (this.numerador * otro.denominador).compareTo(otro.numerador * this.denominador)
}
    override fun equals(other: Any?): Boolean {
        
        if (this === other){ // verifica si ocupa la misma posición de memoria
            return true
        }

        if (other !is Fraccion) { // si other no es un objeto de la clase que retorne false
            return false
        }
        //si no se hace lo anterior no se puede utilizar other

        return this.numerador * other.denominador == other.numerador * this.denominador
        }
        fun esMayor(other: Fraccion): Boolean {
            if (this > other){ 
            return true
        }

        if (other !is Fraccion) { 
            return false
        }
        

        return this.numerador * other.denominador > other.numerador * this.denominador
        }
        fun esMenor(other: Fraccion): Boolean {
            if (this < other){ 
            return true
        }

        if (other !is Fraccion) { 
            return false
        }
        

        return this.numerador * other.denominador < other.numerador * this.denominador
        }
        fun aDecimal(): Double {
    return numerador.toDouble() / denominador
    }
    companion object { fun desdeDecimal(decimal: Double): Fraccion {
        val precision = 1_000_000 
        val numerador = (decimal * precision).toInt()
        val denominador = precision
        val fraccion = Fraccion(numerador, denominador)
        fraccion.simplificar()
        return fraccion
    }
}
    }
