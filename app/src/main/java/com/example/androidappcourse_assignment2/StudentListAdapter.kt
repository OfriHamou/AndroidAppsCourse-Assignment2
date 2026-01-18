package com.example.androidappcourse_assignment2

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class StudentListAdapter(private val studentList: List<StudentModel>): RecyclerView.Adapter<StudentListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentListViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_row, parent, false)
        return StudentListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StudentListViewHolder, position: Int) {
        val student = studentList[position]
        holder.nameStudentView.text = student.name
        holder.idStudentView.text = student.id
        holder.checkBoxView.isChecked = student.checked
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, StudentDetailsActivity::class.java)
            intent.putExtra("position", position)
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}