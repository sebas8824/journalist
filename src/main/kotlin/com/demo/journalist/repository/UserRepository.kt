package com.demo.journalist.repository

import com.demo.journalist.security.data.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, String> {
    fun findOneByEmail(email: String): User?
}