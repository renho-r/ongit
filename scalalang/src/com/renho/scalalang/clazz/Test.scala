package com.renho.scalalang.clazz

object Test {
  def main(args: Array[String]): Unit = {

    implicit def string2Dog(str: String) = new Dog(str)

    //var dog = new Dog("dd")
    val dog = "ss"
    dog say;
    dog.say
    println(dog.math(1, 2))
    println(dog + 100)
    val a: Animal = dog
    a.say
  }
}