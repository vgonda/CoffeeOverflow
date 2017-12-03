package com.raywenderlich.android.coffeeoverflow

class CoffeeRepository {
  private var coffees = 0

  fun increment() {
    coffees++
  }

  val count: Int
    get() = coffees
}