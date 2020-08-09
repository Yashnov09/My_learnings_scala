package com.github.calculator.domain

import com.github.calculator.console.{Console, LiveConsole}
import org.scalatest.{FunSuite, Matchers}
import org.mockito.{MockitoSugar, ArgumentMatchersSugar}

import org.mockito.ArgumentMatchers.anyString

class CalculatorTest
    extends FunSuite
    with Matchers
    with MockitoSugar
    with ArgumentMatchersSugar {
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

  test("mock add method prints correct") {

    val aMock = mock[User]

    when(aMock.getName).thenCallRealMethod()

    when(aMock.getUser) thenReturn ("Paell")

    aMock.getName shouldBe "Pavel"

  }
}

class TestConsole extends Console {
  var printedLines: List[String] = Nil

  override def printLine(line: String): Unit =
    printedLines = line :: printedLines

  override def read(): String = ???
}

trait User {
  def getName: String = {
    println("Pavell")
    "Pavel"
  }

  def getUser: String
}
