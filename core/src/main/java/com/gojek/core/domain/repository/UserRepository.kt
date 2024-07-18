package com.gojek.core.domain.repository

import com.gojek.core.domain.model.User

interface UserRepository {
    fun setUser(name: String, age: Int)
    fun getUser(): User
}