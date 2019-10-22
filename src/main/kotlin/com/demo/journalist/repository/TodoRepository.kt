package com.demo.journalist.repository

import com.demo.journalist.data.entities.Todo
import org.springframework.data.repository.CrudRepository

interface TodoRepository: CrudRepository<Todo, String>