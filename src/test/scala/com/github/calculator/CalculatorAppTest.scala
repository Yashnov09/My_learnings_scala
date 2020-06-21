package com.github.calculator

import org.scalactic.Equality
import org.scalatest.{FunSuite, Matchers}

class CalculatorAppTest extends FunSuite with Matchers {

 test ("Add method gives correct result"){
   CalculatorApp.evalAdd(10,5) shouldBe 15
 }

  test("Sub method gives correct result"){
    CalculatorApp.evalSub(20,4) shouldBe 16
  }

  test("Multiple method gives correct result"){
    CalculatorApp.evalMultiple(3,6) shouldBe 18
  }
 test("Division method gives correct results"){
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

  test("Remove operand gives correct result"){
    val s = "20+30"
    val result = '+'
    CalculatorApp.removeDigit(s) shouldBe result
  }




}
