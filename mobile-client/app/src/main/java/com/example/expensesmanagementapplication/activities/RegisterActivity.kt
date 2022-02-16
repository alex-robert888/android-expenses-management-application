package com.example.expensesmanagementapplication.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.expensesmanagementapplication.databinding.ActivityRegisterBinding
import com.example.expensesmanagementapplication.utils.AndroidUtils
import com.example.expensesmanagementapplication.utils.getRegisterUrl
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.extensions.jsonBody


class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding;
    private lateinit var eventHandlers: RegisterActivityEventHandlers;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(layoutInflater);
        setContentView(binding.root);

        eventHandlers = RegisterActivityEventHandlers(this, binding);
        binding.eventHandlers = eventHandlers;
    }
}

class RegisterActivityEventHandlers(_context: Context, _binding: ActivityRegisterBinding) {
    private val context = _context;
    private val binding = _binding;

    fun onBackArrowButtonClick(view: View) {
        // Finish activity and return to the home page
        val intent = Intent(context, MainActivity::class.java);
        context.startActivity(intent);
    }


    fun onRegisterButtonClick(view: View) {
        val jsonBody = """
          { "name" : "${binding.nameEditText.text}",
            "email" : "${binding.emailEditText.text}",
            "password" : "${binding.passwordEditText.text}"
          }
        """
        signUp(jsonBody);
    }

    private fun signUp(jsonBody: String) {
        Fuel.post(getRegisterUrl())
            .jsonBody(jsonBody)
            .response { _, response, _ ->
                if(response.statusCode == 201) {
                    AndroidUtils.redirect(context, LogInActivity::class.java)
                    AndroidUtils.toast(context, "Account created successfully.")
                } else {
                    AndroidUtils.toast(context, String(response.data))
                }
            }
    }
}