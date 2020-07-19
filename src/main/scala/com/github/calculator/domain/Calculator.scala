package com.github.calculator.domain
import com.github.calculator.console.{Console, LiveConsole}

class Calculator(console: Console) {

  /* Methods to perform various operations */

  def evalAdd(a: Double, b: Double): Double = {
    val c = a + b
    console.printLine(s"Result is $c")
    c
  }

  def evalSub(a: Double, b: Double): Double = {
    val c = a - b
    console.printLine(s"Result is $c")
    c
  }

  def evalMultiple(a: Double, b: Double): Double = {
    val c = a * b
    console.printLine(s"Result is $c")
    c
  }

  def evalDivide(a: Double, b: Double): Double = {
    require(b != 0, "Denominator cannot be 0")
    val c = a / b
    console.printLine("Result is " + c)
    c
  }

}
