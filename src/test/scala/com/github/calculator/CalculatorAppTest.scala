package com.github.calculator

import org.scalactic.Equality
import org.scalatest.{FunSuite, Matchers}
import org.mockito.{MockitoSugar, ArgumentMatchersSugar}
import org.mockito.stubbing.{CallsRealMethods}
import com.github.calculator.domain.Calculator
import com.github.calculator.console.LiveConsole
class CalculatorAppTest
    extends FunSuite
    with Matchers
    with MockitoSugar
    with ArgumentMatchersSugar {
  val con = new LiveConsole()
  val cal = new Calculator(con)

  test("Add method gives correct result") {
    cal.evalAdd(10, 5) shouldBe 15
  }

  test("Sub method gives correct result") {
    cal.evalSub(20, 4) shouldBe 16
  }

  test("Multiple method gives correct result") {
    cal.evalMultiple(3, 6) shouldBe 18
  }
  test("Division method gives correct results") {
    cal.evalDivide(10, 2) shouldBe 5
  }

  test("Division by zero should fail") {
    assertThrows[IllegalArgumentException](cal.evalDivide(9, 0))
  }

  test("Division should return floating point") {
    import org.scalactic.TolerantNumerics
    implicit val floatEq: Equality[Float] =
      TolerantNumerics.tolerantFloatEquality(0.01f)
    cal.evalDivide(10, 3) shouldBe 10 / 3.0
  }

  test("Remove operand gives correct result") {
    val s: String = "20+30"
    val result: Char = '+'
    CalculatorApp.removeDigit(s) shouldBe result
  }

  test("Operand function gives correct results ") {
    val result: (Char, Double, Double) = ('+', 20.0, 10.0)
    CalculatorApp.operand("20.0+10.0") shouldBe result
  }

  test("Entry to the app and User is presented help pop-up") {
    val mockHelp = mock[LiveConsole]

    doReturn("help").when(mockHelp).read()

    mockHelp.read() shouldBe "help"
  }

  test("Getchoice method returns proper message") {

    val mockGetchoice = MockitoSugar.mock[CalculatorApp](CallsRealMethods)

    mockGetchoice.checkLine("help") shouldBe Right()

  }

}
