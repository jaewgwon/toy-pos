package io.github.jaewgwon.pos.ui.login

interface LoginNavigator {
    fun handleError(throwable: Throwable)
    fun navigateToMain()
}