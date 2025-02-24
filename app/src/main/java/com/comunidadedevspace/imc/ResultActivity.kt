package com.comunidadedevspace.imc

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC ="ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC,0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassification = findViewById<TextView>(R.id.tv_classification)

        tvResult.text = result.toString()

        val (classification, color) = when {
            result <= 18.5f -> "UNDERWEIGHT" to Color.BLUE
            result <= 24.9f -> "HEALTHY" to Color.GREEN
            result <= 29.9f -> "OVERWEIGHT" to Color.YELLOW
            result <= 39.9f -> "OBESITY" to Color.MAGENTA
            else -> "SEVERE OBESITY" to Color.RED
        }

        tvClassification.text = classification
        tvClassification.setTextColor(color)

    }
}