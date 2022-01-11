package com.example.expensesmanagementapplication.activities
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.expensesmanagementapplication.databinding.ActivityMainBinding
import com.example.expensesmanagementapplication.event_handlers.MainActivityEventHandlers

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    private lateinit var eventHandlers: MainActivityEventHandlers;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        eventHandlers = MainActivityEventHandlers(this);
        binding.eventHandlers = eventHandlers;
    }

    fun redirectToRegisterPage(view: View) {
        val intent = Intent(this, RegisterActivity::class.java);
        startActivity(intent);
    }

    fun redirectToLogInPage(view: View) {
        val intent = Intent(this, LogInActivity::class.java);
        startActivity(intent);
    }
}