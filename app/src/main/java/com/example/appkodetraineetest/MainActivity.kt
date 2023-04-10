package com.example.appkodetraineetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.appkodetraineetest.remote.Api

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: EmployeesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[EmployeesViewModel::class.java]


        viewModel.status.observe(this) {
            if (it == ApiStatus.DONE) {
                 findViewById<TextView>(R.id.text).text = viewModel.sourceList.value.toString()
            }
            Log.d("API", "Status is $it")
        }

    }
}