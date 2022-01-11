package com.example.expensesmanagementapplication.event_handlers

import android.content.Context
import android.content.Intent
import android.view.View
import com.example.expensesmanagementapplication.activities.MainActivity
import com.example.expensesmanagementapplication.activities.RegisterActivity

class RegisterActivityEventHandlers(_context: Context) {
    private val context = _context;

    fun onBackArrowButtonClick(view: View) {
        // Finish activity and return to the home page
        val intent = Intent(context, MainActivity::class.java);
        context.startActivity(intent);
    }

    fun onRegisterButtonClick(view: View) {

    }
}