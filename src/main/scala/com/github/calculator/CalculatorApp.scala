package com.github.calculator
import scala.io.StdIn.readLine

object CalculatorApp {

  /* Methods to perform various operations */

  def evalAdd(a: Int, b: Int): Int = {
    val c = a + b
    println(s"Result is $c")
    c
  }


  def evalDivide(a: Int, b: Int): Float = {
    require(b != 0,"Denominator cannot be 0")
    val c = a / b.toFloat
    println("Result is "+c)
    c
  }






  def main(args: Array[String]): Unit = {


    println("Welcome to calculator! Type help")
    val help = """Please enter the operation to preform
                 |For Eg: 3+6""".stripMargin

    def getChoice: String = {
      val line = readLine().toLowerCase()
      line match {
        case "help" => println(help);line
        case _ => println("Invalid input, please type help !!"); getChoice
      }
    }
    getChoice



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




    def removeDigit(s: String): Char ={
      //def isDigit(c: Char): Boolean = true
      s.filter(c => !c.isDigit).head
    }


    val nextStep = readLine().replaceAll(" +","")
    val delimit = "([\\+\\/\\-\\*]+)"
    val op = removeDigit(nextStep)

    val Args = nextStep.split(delimit).map(_.toInt).toList
    println(Args(0),Args(1))

    def perform(c: Char): Unit = op match{
      case '+' => evalAdd(Args.head,Args(1))
      case '-' => evalSub(Args.head,Args(1))
      case '*' => evalMultiple(Args.head,Args(1))
      case '/' => evalDivide(Args.head,Args(1))
      case _ => System.exit(0)
    }
    perform(op)

    println("Exiting the calculator App !!")

    System.exit(0)

  }

}
