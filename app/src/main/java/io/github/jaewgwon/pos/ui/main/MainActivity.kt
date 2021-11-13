package io.github.jaewgwon.pos.ui.main

import android.content.Intent
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import io.github.jaewgwon.pos.databinding.ActivityMainBinding
import io.github.jaewgwon.pos.ui.base.BaseActivity
import io.github.jaewgwon.pos.ui.login.LoginActivity
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate), MainNavigator {
    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setNavigator(this)
        TAG = "MainActivity"
    }

    override fun logout() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onBackPressed() {
        logout()
    }

    override fun onResume() {
        super.onResume()
    }
}