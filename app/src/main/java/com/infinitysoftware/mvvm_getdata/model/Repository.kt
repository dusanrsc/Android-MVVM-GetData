package com.infinitysoftware.mvvm_getdata.model

import kotlinx.coroutines.delay
import kotlin.random.Random

class UserRepository() {
    suspend fun fetchUserData(): UserData{
        delay(Random.nextInt(0,5000).toLong())
        return UserData("@dusanrsc", "Dusan", "Rosic", "admin")
    }
}