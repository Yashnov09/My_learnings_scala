package com.github.essentialScala

object person {
  val firstName = "Yash"
  val lastName = "Sait"
}

object alien {
  def greet(p: person.type) = "Greetings, " + p.firstName + " " + p.lastName
}
