package com.infinitysoftware.mvvm_getdata.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.infinitysoftware.mvvm_getdata.model.UserData
import com.infinitysoftware.mvvm_getdata.model.UserRepository
import kotlinx.coroutines.launch

class UserDataViewModel: ViewModel() {
    val UserRepository: UserRepository = UserRepository()

    private val _userDataRepository = MutableLiveData<UserData>()
    val userRepository: LiveData<UserData> = _userDataRepository

    fun getUserData() {
        viewModelScope.launch {
            val userResult = UserRepository.fetchUserData()
            _userDataRepository.postValue(userResult)
        }
    }
}