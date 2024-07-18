package com.gojek.detail_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gojek.core.domain.model.User
import com.gojek.core.domain.repository.UserRepository
import com.gojek.detail_screen.di.DetailScreenScope
import javax.inject.Inject

@DetailScreenScope
class DetailViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    init {
        getUser()
    }

    private fun getUser() {
        _user.value = userRepository.getUser()
    }
}