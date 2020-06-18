package com.github.calculator

import org.scalactic.Equality
import org.scalatest.{FunSuite, Matchers}

class CalculatorAppTest extends FunSuite with Matchers {

 test ("Adding 2 numbers gives correct result"){
   CalculatorApp.evalAdd(10,5) shouldBe 15
 }

 test("Division by 2 numbers works fine"){
   CalculatorApp.evalDivide(10,2) shouldBe 5
 }

 test("Division by zero should fail"){
   assertThrows[IllegalArgumentException](CalculatorApp.evalDivide(9,0) )
 }

 test("Division should return floating point"){
   import org.scalactic.TolerantNumerics
   implicit val floatEq: Equality[Float] = TolerantNumerics.tolerantFloatEquality(0.01f)
   CalculatorApp.evalDivide(10,3) shouldBe 10/3.0f
 }





}
