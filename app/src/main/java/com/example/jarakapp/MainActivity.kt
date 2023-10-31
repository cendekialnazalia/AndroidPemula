package com.example.jarakapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtSpeed : EditText
    private lateinit var edtTime : EditText
    private lateinit var btnCount : Button
    private lateinit var tvResult : TextView

    companion object{
        private  const val STATE_RESULT = "state_result"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtSpeed = findViewById(R.id.txt_speed_input)
        edtTime = findViewById(R.id.txt_time_input)
        btnCount = findViewById(R.id.btn_distance_count)
        tvResult = findViewById(R.id.result_distance_count)
        btnCount.setOnClickListener(this)

        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn_distance_count){
            val inputSpeed = edtSpeed.text.toString().trim()
            val inputTime = edtTime.text.toString().trim()
            var isEmptyFields = false
            if (inputSpeed.isEmpty()){
                isEmptyFields = true
                edtSpeed.error = "You must have fill this field"
            }
            if (inputTime.isEmpty()){
                isEmptyFields = true
                edtTime.error = "You must have fill this field"
            }
            if (!isEmptyFields){
                val countDistance = inputSpeed.toDouble() * inputTime.toDouble()
                tvResult.text = countDistance.toString()
            }
        }
    }


}