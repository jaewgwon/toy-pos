package io.github.jaewgwon.pos.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import io.github.jaewgwon.pos.ui.login.LoginActivity
import io.github.jaewgwon.pos.ui.login.LoginViewModel
import io.github.jaewgwon.pos.ui.main.MainActivity
import io.github.jaewgwon.pos.ui.main.MainViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    fun provideLoginViewModel(@ActivityContext context: Context): LoginViewModel {
        return ViewModelProvider(context as LoginActivity).get(LoginViewModel::class.java)
    }

    @Provides
    fun provideMainViewModel(@ActivityContext context: Context): MainViewModel {
        return ViewModelProvider(context as MainActivity).get(MainViewModel::class.java)
    }
}