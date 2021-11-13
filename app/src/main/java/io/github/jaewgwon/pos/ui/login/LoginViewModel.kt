package io.github.jaewgwon.pos.ui.login

import android.util.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.jaewgwon.pos.data.model.api.NetworkStatus
import io.github.jaewgwon.pos.data.model.entity.User
import io.github.jaewgwon.pos.ui.base.BaseViewModel
import io.github.jaewgwon.pos.usecase.login.LoginUseCase
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val disposables: CompositeDisposable,
    private val login: LoginUseCase,
    _networkStatus: BehaviorSubject<NetworkStatus>
): BaseViewModel<LoginNavigator>(disposables, _networkStatus) {

    private val TAG = "LoginViewModel"

    fun login(id: String, password: String) {
        disposables.add(
            login
                .execute(LoginUseCase.Request(id, password))
                .doOnSubscribe { _networkStatus.onNext(NetworkStatus.LOADING) }
                .doOnError { _networkStatus.onNext(NetworkStatus.ERROR) }
                .doOnSuccess {
                    _networkStatus.onNext(NetworkStatus.LOADING_COMPLETE)
                    //TODO: Business logic?
                }
                .subscribe(
                    {
                        Log.d(TAG, it.toString())
                        navigator!!.navigateToMain()
                    },
                    {
                        Log.e(TAG, it.message.toString())
                        navigator!!.handleError(it)
                    }
                )
        )
    }
}