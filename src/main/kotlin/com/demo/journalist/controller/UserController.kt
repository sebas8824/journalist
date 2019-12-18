package com.demo.journalist.controller

import com.demo.journalist.security.data.dto.UserDTO
import com.demo.journalist.security.data.entity.User
import com.demo.journalist.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    lateinit var service: UserService

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getUsers() = service.getUsers()

    @PostMapping("/admin", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun insertAdmin(@RequestBody user: UserDTO) = service.saveAdmin(user)

    @PostMapping("/member", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun insertMember(@RequestBody user: UserDTO) = service.saveMember(user)

    @DeleteMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteUser(@PathVariable(name = "id") id: String) = service.deleteUser(id)

    @PutMapping(produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun updateUser(@RequestBody user: User): User? = service.updateUser(user)

}