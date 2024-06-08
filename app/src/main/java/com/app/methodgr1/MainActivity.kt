package com.app.methodgr1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etNumber1 = findViewById<EditText>(R.id.etNumber1).text
        val etNumber2 = findViewById<EditText>(R.id.etNumber2).text
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSub = findViewById<Button>(R.id.btnSub)
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnHigh = findViewById<Button>(R.id.btnHigh)
        val btnLow = findViewById<Button>(R.id.btnLow)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        val numbers = arrayOf<Int>(5, 10, 15, 20, 25, 30, 29, 1, 100, 18)


        btnHigh.setOnClickListener {
            var highElement = findHighestElement(numbers)
            tvResult.text = "${highElement}"
        }

        btnLow.setOnClickListener {
            var lowest = findLowestElement(numbers)
            tvResult.text = "${lowest}"
        }

        btnAdd.setOnClickListener {
            performArithmeticOperations(
                etNumber1.toString().toInt(), etNumber2.toString().toInt(),
                tvResult, "+"
            )
        }

        btnSub.setOnClickListener {
            performArithmeticOperations(
                etNumber1.toString().toInt(), etNumber2.toString().toInt(),
                tvResult, "-"
            )
        }


        btnDivide.setOnClickListener {
            performArithmeticOperations(
                etNumber1.toString().toInt(), etNumber2.toString().toInt(),
                tvResult, "/"
            )
        }

        btnMultiply.setOnClickListener {
            performArithmeticOperations(
                etNumber1.toString().toInt(), etNumber2.toString().toInt(),
                tvResult, "*"
            )
        }

    }


    fun performArithmeticOperations(
        number1: Int,
        number2: Int,
        tvResult: TextView,
        operation: String
    ) {

        when (operation) {
            "+" -> {
                tvResult.text = "${number1 + number2}"
            }

            "-" -> {
                tvResult.text = "${number1 - number2}"
            }

            "/" -> {
                tvResult.text = "${number1 / number2}"
            }

            "*" -> {
                tvResult.text = "${number1 * number2}"
            }
        }
    }


    fun findHighestElement(numbers: Array<Int>): Int {
        var highest = numbers[0]

        for (number in numbers) {
            if (number > highest) {
                highest = number
            }
        }

        return highest
    }

    fun findLowestElement(numbers: Array<Int>): Int {
        var lowest = numbers[0]

        for (number in numbers) {
            if (number < lowest) {
                lowest = number
            }
        }

        return lowest
    }

}