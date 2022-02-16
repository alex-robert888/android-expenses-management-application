package com.example.expensesmanagementapplication.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.expensesmanagementapplication.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogInBinding;
    private lateinit var eventHandlers: LogInActivityEventHandlers;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogInBinding.inflate(layoutInflater);
        setContentView(binding.root);

        eventHandlers = LogInActivityEventHandlers(this);
        binding.eventHandlers = eventHandlers;
    }
}

class LogInActivityEventHandlers(_context: Context) {
    private val context = _context ;

    fun onBackArrowButtonClick(view: View) {
        // Finish activity and return to the home page
        val intent = Intent(context, MainActivity::class.java);
        context.startActivity(intent);
    }
}