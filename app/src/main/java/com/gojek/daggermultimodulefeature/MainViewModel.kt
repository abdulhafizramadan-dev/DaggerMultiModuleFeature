package com.gojek.daggermultimodulefeature

import androidx.lifecycle.ViewModel
import com.gojek.core.domain.repository.UserRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {
    fun setUser(name: String, age: Int) {
        userRepository.setUser(name = name, age = age)
    }
}