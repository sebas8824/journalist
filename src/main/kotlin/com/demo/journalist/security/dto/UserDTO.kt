package com.demo.journalist.security.dto

data class UserDTO(
        var email: String,
        var password: String,
        var firstName: String,
        var lastName: String
)