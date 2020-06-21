package com.github.calculator
import scala.io.StdIn.readLine

object CalculatorApp {

  /* Methods to perform various operations */

  def evalAdd(a: Int, b: Int): Int = {
    val c = a + b
    println(s"Result is $c")
    c
  }

  def evalSub(a: Int, b: Int): Int =
  { val c = a - b
    println(s"Result is $c")
    c
  }

  def evalMultiple(a: Int, b: Int): Int =
  { val c = a * b
    println(s"Result is $c")
    c
  }


  def evalDivide(a: Int, b: Int): Float = {
    require(b != 0,"Denominator cannot be 0")
    val c = a / b.toFloat
    println("Result is "+c)
    c
  }

  /*Method to remove special char*/
  def removeDigit(s: String): Char ={
    s.filter(c => !c.isDigit).head
  }


  def getChoice: String = {

    val help = """Please enter the operation to perform
                 |For Eg: 3+6""".stripMargin
    val line = readLine().toLowerCase()
    line match {
      case "help" => println(help);line
      case _ => println("Invalid input, please type help !!"); getChoice
    }
  }




  def main(args: Array[String]): Unit = {
    println("************* Welcome to calculator! Type help *************")
    getChoice
    def operand: (Char, Int, Int) = {
      val nextStep = readLine().replaceAll(" +", "")
      val sym = removeDigit(nextStep)
      val delimit = "([\\+\\/\\-\\*]+)"
      val Args = nextStep.split(delimit).map(_.toInt).toList
      (sym,Args.head,Args(1))
    }
    val (op, arg1, arg2) = operand

    def perform: Unit = op match{
      case '+' => evalAdd(arg1,arg2)
      case '-' => evalSub(arg1,arg2)
      case '*' => evalMultiple(arg1,arg2)
      case '/' => evalDivide(arg1,arg2)
      case _ => System.exit(0)
    }
    perform
    println("Do you want to continue with Calculator: Y or N")
    val input = readLine().toUpperCase()
    def Continue(c: String): Unit = input match {
      case "Y" => println("Enter the operation");operand;perform
      case "N" => println("Exiting the calculator App !!"); System.exit(0)
    }
    Continue(input)



  }

}
