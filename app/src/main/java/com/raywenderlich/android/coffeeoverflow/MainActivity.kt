package com.raywenderlich.android.coffeeoverflow

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  private val coffeeRepo = CoffeeRepository()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    addCoffee.setOnClickListener {
      coffeeRepo.increment()
    }
  }
}

