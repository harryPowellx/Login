package com.mildroid.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.google.android.material.snackbar.Snackbar
import com.mildroid.login.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signup.setOnClickListener {
            val isEmailValid =
                if (Patterns.EMAIL_ADDRESS.matcher(binding.signupEmail.text.toString()).matches()) {
                    binding.signupEmailLayout.isErrorEnabled = false

                    true
                } else {
                    binding.signupEmailLayout.isErrorEnabled = true
                    binding.signupEmailLayout.error = "Email is not correct!"

                    false
                }

            val isPhoneValid =
                if (Patterns.PHONE.matcher(binding.signupPhone.text.toString()).matches() &&
                    binding.signupPhone.text.toString().length == 14
                ) {
                    binding.signupPhoneLayout.isErrorEnabled = false

                    true
                } else {
                    binding.signupPhoneLayout.isErrorEnabled = true
                    binding.signupPhoneLayout.error = "Phone is not correct!"

                    false
                }

            if (isEmailValid && isPhoneValid) {
                Snackbar.make(
                    binding.root,
                    "User Created",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }

        binding.signupBack.setOnClickListener {
            finish()
        }

        binding.signupLogin.setOnClickListener {
            finish()
        }
    }
}