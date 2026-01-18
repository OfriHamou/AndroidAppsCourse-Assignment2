package com.example.androidappcourse_assignment2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddNewStudentActivity : AppCompatActivity() {
    var nameText: EditText? = null
    var idText: EditText? = null
    var phoneText: EditText? = null
    var addressText: EditText? = null
    var checkedBox: CheckBox? = null
    var saveButton: Button? = null
    var cancelButon: Button? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_new_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.nameEditText)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setUpUI()
    }

    private fun setUpUI(){
        nameText = findViewById(R.id.editNameText)
        idText = findViewById(R.id.IdEditText)
        phoneText = findViewById(R.id.PhoneEditText)
        addressText = findViewById(R.id.AddEditText)
        checkedBox = findViewById(R.id.checkBox2)
        saveButton = findViewById(R.id.deleteButton)
        cancelButon = findViewById(R.id.backButton)

        saveButton?.setOnClickListener {
            val name = nameText?.text.toString()
            val id = idText?.text.toString()
            val phone = phoneText?.text.toString()
            val address = addressText?.text.toString()
            val checked = checkedBox?.isChecked
            val student = StudentModel(name, id, phone, address, checked!!)
            StudentListRepository.addStudent(student)
            finish()
        }

        cancelButon?.setOnClickListener {
            finish()
        }

    }
}