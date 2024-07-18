package com.gojek.core.data

import com.gojek.core.domain.model.User
import com.gojek.core.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor() : UserRepository {
    private var user = User()

    override fun setUser(name: String, age: Int) {
        user = user.copy(
            name = name,
            age = age
        )
    }

    override fun getUser(): User {
        return user
    }
}