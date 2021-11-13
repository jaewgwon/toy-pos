package io.github.jaewgwon.pos.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.github.jaewgwon.pos.data.model.api.NetworkStatus
import io.github.jaewgwon.pos.data.repository.UserRepository
import io.github.jaewgwon.pos.usecase.login.LoginUseCase
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.BehaviorSubject

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {
    @Provides
    fun provideNetworkStatusSubject(): BehaviorSubject<NetworkStatus> {
        return BehaviorSubject.create()
    }
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
    @Provides
    fun provideLoginUsecase(): LoginUseCase {
        return LoginUseCase(UserRepository)
    }
}