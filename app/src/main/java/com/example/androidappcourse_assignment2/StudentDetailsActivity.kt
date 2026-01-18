package com.example.androidappcourse_assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setUpUI()
    }


    private fun setUpUI(){

        //define variables for the views
        var nameText = findViewById<TextView>(R.id.nameDetail)
        var idText = findViewById<TextView>(R.id.idDetail)
        var phoneText = findViewById<TextView>(R.id.phoneDetail)
        var addressText = findViewById<TextView>(R.id.addDetail)
        var checkedBox = findViewById<CheckBox>(R.id.checkBox2)
        var editButton = findViewById<Button>(R.id.deleteButton)
        var backButton = findViewById<Button>(R.id.backButton)

        //get the student from the intent (from the adapter)
        val studentIndex = intent.getIntExtra("position", 0)
        val student = StudentListRepository.getStudentByPosition(studentIndex)

        //set the values of the views to the student values
        nameText.text = student.name
        idText.text = student.id
        phoneText.text = student.phone
        addressText.text = student.address
        checkedBox.isChecked = student.checked


        editButton.setOnClickListener {
            val intent = Intent(this, editStudentActivity::class.java)
            intent.putExtra("position", studentIndex)
            startActivity(intent)
            finish()
        }



        backButton.setOnClickListener {
            finish()
        }



    }
}