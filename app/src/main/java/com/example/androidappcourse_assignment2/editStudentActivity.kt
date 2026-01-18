package com.example.androidappcourse_assignment2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class editStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setUpUI()
    }

    private fun setUpUI(){

        var nameText = findViewById<EditText>(R.id.editNameText)
        var idText = findViewById<EditText>(R.id.IdEditText)
        var phoneText = findViewById<EditText>(R.id.PhoneEditText)
        var addressText = findViewById<EditText>(R.id.AddEditText)
        var checkedBox = findViewById<CheckBox>(R.id.checkBox2)
        var deleteButton = findViewById<Button>(R.id.deleteButton)
        var cancelButton = findViewById<Button>(R.id.cancelButton)
        var saveButton = findViewById<Button>(R.id.saveButton)

        val studentIndex = intent.getIntExtra("position", 0)
        val student = StudentListRepository.getStudentByPosition(studentIndex)

        nameText.setText(student.name)
        idText.setText(student.id)
        phoneText.setText(student.phone)
        addressText.setText(student.address)
        checkedBox.isChecked = student.checked

        deleteButton.setOnClickListener {
            StudentListRepository.deleteStudent(studentIndex)
            finish()
        }

        cancelButton.setOnClickListener {
            finish()
        }

        saveButton.setOnClickListener {
            val name = nameText.text.toString()
            val id = idText.text.toString()
            val phone = phoneText.text.toString()
            val address = addressText.text.toString()
            val checked = checkedBox.isChecked
            val newStudent = StudentModel(name, id, phone, address, checked)
            StudentListRepository.editStudent(newStudent, studentIndex)
            finish()
        }


    }
}