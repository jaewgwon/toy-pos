package io.github.jaewgwon.pos.ui.main

import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.jaewgwon.pos.data.model.api.NetworkStatus
import io.github.jaewgwon.pos.ui.base.BaseViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val disposables: CompositeDisposable,
    _networkStatus: BehaviorSubject<NetworkStatus>
): BaseViewModel<MainNavigator>(disposables, _networkStatus) {

}