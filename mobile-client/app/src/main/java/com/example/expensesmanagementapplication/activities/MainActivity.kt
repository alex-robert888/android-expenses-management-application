package com.example.expensesmanagementapplication.activities
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.expensesmanagementapplication.databinding.ActivityMainBinding
import com.example.expensesmanagementapplication.utils.AndroidUtils

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
}

class MainActivityEventHandlers(_context: Context) {
    private val context: Context = _context;

    fun onRegisterButtonClick(view: View) {
        AndroidUtils.redirect(context, RegisterActivity::class.java)
    }

    fun onLogInButtonClick(view: View) {
        AndroidUtils.redirect(context, LogInActivity::class.java)
    }
}