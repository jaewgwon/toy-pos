package io.github.jaewgwon.pos.data.repository

import io.github.jaewgwon.pos.data.model.entity.User
import io.reactivex.rxjava3.core.Single

object UserRepository: BaseRepository() {
    fun login(id: String, password: String): Single<Result<User>> {
        return if(id == "test" && password == "test") {
            Single.just(
                Result.success(
                    User(
                        id,
                        "test@test.com",
                        0
                    )
                )
            )
        }
        else {
            Single.error(Throwable("NOT_VALID_ID_PASSWORD"))
        }
    }
}