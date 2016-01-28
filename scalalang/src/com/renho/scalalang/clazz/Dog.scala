package com.renho.scalalang.clazz

class Dog(name: String) extends Animal(name: String) {
  
  override def say(): Unit = {
    println(name + " say: wang wang")
  }
  
  override def math(a: Int, b: Int): Int = {
    a + b
  }
    
  override def +(a: Int): Int = {
    a
  }
  
}