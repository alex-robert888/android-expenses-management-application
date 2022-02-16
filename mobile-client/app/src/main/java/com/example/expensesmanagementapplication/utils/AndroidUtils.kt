package com.example.expensesmanagementapplication.utils

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.expensesmanagementapplication.activities.RegisterActivity

class AndroidUtils {
    companion object {
        fun toast(context: Context, message: String) {
            val t = Toast.makeText(context, message, Toast.LENGTH_SHORT)
            t.show()
        }

        fun redirect(context: Context, klass: Class<*>) {
            val intent = Intent(context, klass);
            context.startActivity(intent);
        }
    }
}