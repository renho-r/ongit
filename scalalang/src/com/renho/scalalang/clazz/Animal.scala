package com.renho.scalalang.clazz

abstract class Animal(n: String) {
  val name: String = n
  def say
  def math(a: Int, b: Int): Int
  def +(a: Int): Int
}