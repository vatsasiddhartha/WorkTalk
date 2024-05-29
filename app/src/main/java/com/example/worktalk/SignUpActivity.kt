package com.example.worktalk

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.example.worktalk.Models.User
import com.example.worktalk.R.id.password
import com.example.worktalk.Utils.USER_NODE
import com.example.worktalk.databinding.ActivitySignUpBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

class SignUpActivity : AppCompatActivity() {

 val binding by lazy {
     ActivitySignUpBinding.inflate(layoutInflater)
 }
lateinit var user:User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        val text="<font color=#FF000000>Already Registered</font> <font color=#C13584> (Login?)</font>"
        binding.login.text = Html.fromHtml(text)
        binding.login.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
            finish()
        }
        user= User()





            val nameLayout = findViewById<TextInputLayout>(R.id.name)
            val nameEditText = findViewById<TextInputEditText>(R.id.Name2)

            val emailLayout = findViewById<TextInputLayout>(R.id.email)
            val passwordLayout = findViewById<TextInputLayout>(password)


            val emailEditText = findViewById<TextInputEditText>(R.id.email2)
            val passwordEditText = findViewById<TextInputEditText>(R.id.password2)

            nameEditText.addTextChangedListener {
                updateTextColor(it.toString(), nameEditText)
            }

            emailEditText.addTextChangedListener {
                updateTextColor(it.toString(), emailEditText)
            }

            passwordEditText.addTextChangedListener {
                updateTextColor(it.toString(), passwordEditText)
            }
        }
          private fun updateTextColor(text: String, editText: TextInputEditText) {
        if (text.isNotEmpty()) {
            editText.setTextColor(Color.YELLOW)

        } else {
            editText.setTextColor(Color.BLACK)
        }







        binding.SignUpBtn.setOnClickListener {
            if((binding.name.editText?.text.toString() == "") or
                (binding.email.editText?.text.toString() == "") or
                binding.password.editText?.text.toString().equals("")
                ){
                Toast.makeText(this@SignUpActivity,"Please Fill all Data", Toast.LENGTH_SHORT).show()

            }
            else{
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.email.editText?.text.toString(),
                    binding.password.editText?.text.toString())
                    .addOnCompleteListener { result ->
                        if (result.isSuccessful) {
                            user.name= binding.name.editText?.text.toString()
                            user.password = binding.password.editText?.text.toString()
                            user.email = binding.email.editText?.text.toString()

                            Firebase.firestore.collection(USER_NODE)
                                .document(Firebase.auth.currentUser!!.uid).set(user)
                                .addOnSuccessListener {

                                    Toast.makeText(
                                        this@SignUpActivity,
                                        "Login Successfully",
                                        Toast.LENGTH_SHORT
                                    ).show()


                                }



                            Toast.makeText(
                                this@SignUpActivity,
                                "Login Successfully",
                                Toast.LENGTH_SHORT
                            ).show()
                            startActivity(Intent(this@SignUpActivity, HomeActivity::class.java))
                            finish()


                        } else {
                            Toast.makeText(
                                this@SignUpActivity,
                                result.exception?.localizedMessage,
                                Toast.LENGTH_SHORT
                            ).show()

                        }


        }


            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }}}