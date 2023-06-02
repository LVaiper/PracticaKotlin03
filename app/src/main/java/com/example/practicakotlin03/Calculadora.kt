package com.example.practicakotlin03

class Calculadora {
    var num1: Int=6;
    var num2: Int=6;

    constructor(num1:Int, num2:Int) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // Función
    fun suma():Int {
        return num1 + num2;
    }

    fun resta():Int {
        return num1 - num2;
    }

    fun multiplicacion():Int {
        return num1 * num2;
    }

    fun division():Int {
        var total = 0;
        if(num2 != 0) {
            total = num1 / num2;
        }
        return total;
    }
}
