package com.example.androidappcourse_assignment2

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val nameStudentView: TextView = itemView.findViewById<TextView>(R.id.studentName)
    val idStudentView: TextView = itemView.findViewById<TextView>(R.id.studentID)
    val checkBoxView: CheckBox = itemView.findViewById<CheckBox>(R.id.checkBox)
}