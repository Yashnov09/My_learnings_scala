package com.github.calculator

import org.scalatest.{FunSuite, Matchers}

class CalcTest extends FunSuite with Matchers {

  test("Square of a number works correctly") {
    Calc.square(2) shouldBe 4
  }

}
