package io.github.jaewgwon.pos.usecase.login

import io.github.jaewgwon.pos.data.model.entity.User
import io.github.jaewgwon.pos.data.repository.UserRepository
import io.reactivex.rxjava3.core.Single

class LoginUseCase constructor(
    private val userRepository: UserRepository
) {
    fun execute(request: Request): Single<Result<User>> {
        return userRepository.login(request.requestUserId, request.requestUserPassword)
    }

    data class Request(
        val requestUserId: String,
        val requestUserPassword: String
    )
}