package com.github.calculator

object Calc {

  def square(x: Double): Double = x * x

  def cube(y: Double): Double = square(y) * y

  def main(args: Array[String]): Unit = {

    println(s"Result is " + square(2))
    println(s"Result is " + cube(3))
  }

}
