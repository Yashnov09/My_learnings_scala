package com.github.essentialScala

class Director(val firstName: String,
               val lastName: String,
               val yearOfBirth: Int) {

  def name(): String = firstName + " " + lastName
}
