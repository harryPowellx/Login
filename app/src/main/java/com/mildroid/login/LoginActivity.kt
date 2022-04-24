package com.mildroid.login

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.google.android.material.snackbar.Snackbar
import com.mildroid.login.databinding.ActivityLoginBinding
import kotlin.random.Random

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginSignup.setOnClickListener {
            startActivity(
                Intent(this, SignupActivity::class.java)
            )
        }

        binding.login.setOnClickListener {
            if (Patterns.EMAIL_ADDRESS.matcher(binding.loginEmail.text.toString()).matches()) {
                binding.loginEmailLayout.isErrorEnabled = false

                Snackbar.make(
                    binding.root,
                    "Login Successful",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                binding.loginEmailLayout.isErrorEnabled = true
                binding.loginEmailLayout.error = "Email is not correct!"
            }
        }

        binding.loginFacebook.setOnClickListener {
            binding.loginFacebook.backgroundTintList = ColorStateList.valueOf(randomColor())
        }

        binding.loginGoogle.setOnClickListener {
            binding.loginGoogle.backgroundTintList = ColorStateList.valueOf(randomColor())
        }
    }

    private fun randomColor(): Int {
        val rnd = java.util.Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}