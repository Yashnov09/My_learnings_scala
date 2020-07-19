package com.github.calculator.domain

import com.github.calculator.console.{Console, LiveConsole}
import org.scalatest.{FunSuite, Matchers}

class CalculatorTest extends FunSuite with Matchers {
  val con = new LiveConsole()
  val cal = new Calculator(con)

  test("Add method gives correct result") {
    cal.evalAdd(10, 5) shouldBe 15
  }

  test("add method prints fine") {
    val testcon = new TestConsole()
    val calc = new Calculator(testcon)
    calc.evalAdd(5, 5)
    testcon.printedLines.head shouldBe "Result is 10.00"
  }
}

class TestConsole extends Console {
  var printedLines: List[String] = Nil

  override def printLine(line: String): Unit =
    printedLines = line :: printedLines

  override def readLine(): String = ???
}
