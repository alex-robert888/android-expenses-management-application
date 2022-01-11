package com.example.expensesmanagementapplication.event_handlers

import android.content.Context
import android.content.Intent
import android.view.View
import com.example.expensesmanagementapplication.activities.LogInActivity
import com.example.expensesmanagementapplication.activities.RegisterActivity


class MainActivityEventHandlers(_context: Context) {
    private val context: Context = _context;

    fun onRegisterButtonClick(view: View) {
        // Redirect to the register activity
        val intent = Intent(context, RegisterActivity::class.java);
        context.startActivity(intent);
    }

    fun onLogInButtonClick(view: View) {
        // Redirect to the log in activity
        val intent = Intent(context, LogInActivity::class.java);
        context.startActivity(intent);
    }
}