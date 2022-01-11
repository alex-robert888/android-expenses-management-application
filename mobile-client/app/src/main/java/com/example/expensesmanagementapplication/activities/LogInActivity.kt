package com.example.expensesmanagementapplication.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.expensesmanagementapplication.databinding.ActivityLogInBinding
import com.example.expensesmanagementapplication.event_handlers.LogInActivityEventHandlers
import com.example.expensesmanagementapplication.event_handlers.MainActivityEventHandlers

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