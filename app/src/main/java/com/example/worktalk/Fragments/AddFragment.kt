package com.example.worktalk.Fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.worktalk.Models.Question
import com.example.worktalk.R
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddFragment : Fragment() {

    private lateinit var editTextQuestion: EditText
    private lateinit var buttonAddQuestion: Button

    private lateinit var databaseReference: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)

      editTextQuestion = view.findViewById<TextInputLayout>(R.id.editTextQuestion).editText!!
        buttonAddQuestion = view.findViewById(R.id.buttonAddQuestion)

        // Initialize Firebase database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("questions")

        buttonAddQuestion.setOnClickListener {
            addQuestionToFirebase()
        }

        return view
    }

    private fun addQuestionToFirebase() {
        val questionText = editTextQuestion.text.toString().trim()

        if (questionText.isNotEmpty()) {
            // Generate a unique ID for the question
            val questionId = databaseReference.push().key

            // Create a Question object
            val question = Question(questionId!!, questionText)

            // Add the question to Firebase database
            databaseReference.child(questionId).setValue(question)

            // Clear the input field
            editTextQuestion.text.clear()

            Toast.makeText(requireContext(), "Question added successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Please enter a question", Toast.LENGTH_SHORT).show()
        }
    }
}
