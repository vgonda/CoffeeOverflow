package com.raywenderlich.android.coffeeoverflow

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  private val coffeeRepo = CoffeeRepository()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    showCount()

    coffeeLimitValue.addTextChangedListener(object: TextWatcher {
      override fun afterTextChanged(p0: Editable?) { }

      override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

      override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = showCount()
    })

    addCoffee.setOnClickListener {
      coffeeRepo.increment()
      showCount()

      amountConsumed.announceForAccessibility(getString(R.string.count_updated, consumedString()))
    }
  }

  private fun showCount() {
    amountConsumed.text = consumedString()
  }

  private fun consumedString() =
      getString(R.string.consumed_format, coffeeRepo.count, coffeeLimitValue.text.toString())
}

