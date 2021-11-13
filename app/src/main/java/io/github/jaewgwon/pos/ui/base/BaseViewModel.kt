package io.github.jaewgwon.pos.ui.base

import androidx.lifecycle.ViewModel
import io.github.jaewgwon.pos.data.model.api.NetworkStatus
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import java.lang.ref.WeakReference

abstract class BaseViewModel<N> constructor(
    private val disposables: CompositeDisposable,
    val _networkStatus: BehaviorSubject<NetworkStatus>
):  ViewModel() {

    private lateinit var _navigator: WeakReference<N>
    val navigator get() = _navigator.get()

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

    fun setNavigator(navigator: N) {
        this._navigator = WeakReference(navigator)
    }
}