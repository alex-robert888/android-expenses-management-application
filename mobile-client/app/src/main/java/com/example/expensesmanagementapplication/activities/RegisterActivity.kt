package com.example.expensesmanagementapplication.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.expensesmanagementapplication.databinding.ActivityRegisterBinding
import com.example.expensesmanagementapplication.event_handlers.RegisterActivityEventHandlers

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding;
    private lateinit var eventHandlers: RegisterActivityEventHandlers;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(layoutInflater);
        setContentView(binding.root);

        eventHandlers = RegisterActivityEventHandlers(this);
        binding.eventHandlers = eventHandlers;
    }
}