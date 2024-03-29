package com.demo.journalist.data.dto.entity

import com.demo.journalist.data.entities.api.Todo
import java.util.*

data class TodoDTO(var title: String, var message: String, var schedule: Long, var location: String = "") {

    var id: String = ""
    var created: Date = Date()
    var modified: Date = Date()

    constructor(todo: Todo) : this(todo.title, todo.message, todo.schedule, todo.location) {
        id = todo.id
        created = todo.created
        modified = todo.modified
    }
}