package io.github.jaewgwon.pos.ui.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint
import io.github.jaewgwon.pos.data.model.api.NetworkStatus
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

typealias ActivityInflate<T> = (LayoutInflater) -> T

abstract class BaseActivity<VB:ViewBinding>(
    private val activityInflate: ActivityInflate<VB>
): AppCompatActivity() {
    private var _binding: VB? = null
    val binding get() = _binding!!

    @Inject
    lateinit var disposables: CompositeDisposable

    lateinit var TAG: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = activityInflate.invoke(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        disposables.dispose()
    }

    fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

    fun showLoading() {
        Log.d(TAG + "", "SHOW LOADING")
    }

    fun hideLoading() {
        Log.d(TAG + "", "HIDE LOADING")
    }



}