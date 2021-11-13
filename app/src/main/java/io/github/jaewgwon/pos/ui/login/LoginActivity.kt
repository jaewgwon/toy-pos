package io.github.jaewgwon.pos.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import io.github.jaewgwon.pos.R
import io.github.jaewgwon.pos.data.model.api.NetworkStatus
import io.github.jaewgwon.pos.databinding.ActivityLoginBinding
import io.github.jaewgwon.pos.ui.base.BaseActivity
import io.github.jaewgwon.pos.ui.main.MainActivity
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity:
    BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate),
    LoginNavigator
{
    @Inject
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setNavigator(this)
        TAG = "LoginActivity"
    }

    override fun onResume() {
        super.onResume()
        binding.loginWrapperBase.setOnClickListener { hideKeyboard() }
        binding.loginBtnLogin.setOnClickListener {
            viewModel.login(
                binding.loginEtId.text.toString(),
                binding.loginEtPassword.text.toString()
            )
        }
        disposables.add(
            viewModel._networkStatus
                .subscribe(
                    {
                        when(it) {
                            NetworkStatus.LOADING -> showLoading()
                            NetworkStatus.LOADING_COMPLETE -> hideLoading()
                            NetworkStatus.ERROR -> Throwable("NETWORK_ERROR")
                        }
                    },
                    {
                        Log.e(TAG, "Error: ${it.message} ${it.cause}")
                        it.printStackTrace()
                    }
                )
        )
    }

    override fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun handleError(throwable: Throwable) {
        Toast.makeText(
            this,
            getString(R.string.unexpected_error) + ":${throwable.message}",
            Toast.LENGTH_SHORT
        ).show()
    }
}