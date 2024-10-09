package com.example.simplecalculator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), OnClickListener {

    private val TAG: String? = "XXX"

    private lateinit var etInpFirst: EditText
    private lateinit var etInpSecond: EditText
    private lateinit var tvResult: TextView
    private lateinit var btnAdd: Button
    private lateinit var btnMinus: Button
    private lateinit var btnMult: Button
    private lateinit var btnDiv: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        etInpFirst = findViewById(R.id.input1)
        etInpSecond = findViewById(R.id.input2)
        tvResult = findViewById(R.id.res)
        btnAdd = findViewById(R.id.btn_add)
        btnMinus = findViewById(R.id.btn_minus)
        btnMult = findViewById(R.id.btn_mult)
        btnDiv = findViewById(R.id.btn_div)

        btnAdd.setOnClickListener(this)
        btnMinus.setOnClickListener(this)
        btnMult.setOnClickListener(this)
        btnDiv.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val first = etInpFirst.text.toString().toInt()
        val second = etInpSecond.text.toString().toInt()

        when (v?.id) {
            R.id.btn_add -> tvResult.text = "Result: ${(first + second).toString()}"
            R.id.btn_minus -> tvResult.text = "Result: ${(first - second).toString()}"
            R.id.btn_mult -> tvResult.text = "Result: ${(first * second).toString()}"
            R.id.btn_div -> {
                if (second == 0)
                    tvResult.text = "Error, cannot divide by 0"
                else
                    tvResult.text = "Result: ${(first / second).toString()}"
            }
        }
    }
}