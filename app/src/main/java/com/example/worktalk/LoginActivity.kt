package com.example.worktalk

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.worktalk.Models.User
import com.example.worktalk.databinding.ActivityLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.LoginBtn.setOnClickListener {
            if ((binding.email.editText?.text.toString() == "") or
                (binding.password.editText?.text.toString() == "")
            )
            {
                Toast.makeText(
                    this@LoginActivity,"please make all box fill",Toast.LENGTH_SHORT
                ).show()

            }
            else{
                val user=
                   User(binding.email.editText?.text.toString(),
                       binding.password.editText?.text.toString())
                Firebase.auth.signInWithEmailAndPassword(user.email!!,user.password!!)
                    .addOnCompleteListener{
                        if(it.isSuccessful){
                            startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                            finish()

                        }
                        else{
                            Toast.makeText(this@LoginActivity,it.exception?.localizedMessage,Toast.LENGTH_SHORT)
                                .show()
                        }

                    }
            }


        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}