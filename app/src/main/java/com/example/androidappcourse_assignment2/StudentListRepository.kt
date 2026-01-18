package com.example.androidappcourse_assignment2

object StudentListRepository {

    private val studentList = mutableListOf(StudentModel("Ofri Hamou", "123456", "0522227863", "Givatayim", false))

    fun addStudent(student: StudentModel) {
        studentList.add(student)
    }

    fun deleteStudent(index: Int) {
        studentList.removeAt(index)
    }

    fun getStudentList(): List<StudentModel> {
        return studentList
    }

    fun editStudent(newStudent: StudentModel, index: Int) {
        studentList[index] = newStudent
    }

    fun getStudentByPosition(positioning: Int):StudentModel{
        return studentList[positioning]
    }
}