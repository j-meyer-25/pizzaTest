package com.zybooks.pizzatest

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.PI
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val smallPizzaDiameter = findViewById<EditText>(R.id.smallPizzaDiameter)
        val smallPizzaPrice = findViewById<EditText>(R.id.smallPizzaPrice)
        val largePizzaDiameter = findViewById<EditText>(R.id.largePizzaDiameter)
        val largePizzaPrice = findViewById<EditText>(R.id.largePizzaPrice)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val smallPizzaArea = PI * (smallPizzaDiameter.text.toString().toDouble() / 2).pow(2)
            val largePizzaArea = PI * (largePizzaDiameter.text.toString().toDouble() / 2).pow(2)

            val smallPizzaCostPerInch = smallPizzaPrice.text.toString().toDouble() / smallPizzaArea
            val largePizzaCostPerInch = largePizzaPrice.text.toString().toDouble() / largePizzaArea

            val result = when {
                smallPizzaCostPerInch < largePizzaCostPerInch -> "Small pizza is a better buy."
                smallPizzaCostPerInch > largePizzaCostPerInch -> "Large pizza is a better buy."
                else -> "Both pizzas are the same price per square inch."
            }

            resultTextView.text = result
        }
    }
}
