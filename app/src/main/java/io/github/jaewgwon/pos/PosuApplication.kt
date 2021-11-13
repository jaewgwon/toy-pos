package io.github.jaewgwon.pos

import android.app.Application
import android.content.Intent
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import io.github.jaewgwon.pos.ui.login.LoginActivity

@HiltAndroidApp
class PosuApplication: Application() {
    private val TAG = "PosuApplication"
    inner class PosuExceptionHandler: Thread.UncaughtExceptionHandler {
        override fun uncaughtException(t: Thread, e: Throwable) {
            Log.e(TAG, "Global Exception Handler: ${e.cause}")
            startActivity(Intent(applicationContext, LoginActivity::class.java))
        }
    }
}