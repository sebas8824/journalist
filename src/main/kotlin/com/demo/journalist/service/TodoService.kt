package com.demo.journalist.service

import com.demo.journalist.data.dto.entity.TodoDTO
import com.demo.journalist.data.entities.api.Todo
import com.demo.journalist.repository.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service("Todo service")
class TodoService {

    @Autowired
    lateinit var repository: TodoRepository

    fun getTodos(): Iterable<TodoDTO> = repository.findAll().map { TodoDTO(it) }

    fun insertTodo(todo: TodoDTO): TodoDTO = TodoDTO(repository.save(Todo(title = todo.title, message = todo.message, location = todo.location, schedule = todo.schedule)))

    fun deleteTodo(id: String) = repository.deleteById(id)

    fun updateTodo(todoDto: TodoDTO): TodoDTO {
        var todo = repository.findById(todoDto.id).get()
        todo.title = todoDto.title
        todo.message = todoDto.message
        todo.location = todoDto.location
        todo.schedule = todoDto.schedule
        todo.modified = Date()
        todo = repository.save(todo)
        return TodoDTO(todo)
    }

    fun getScheduledLaterThan(date: Date): Iterable<TodoDTO> {
        return repository.findSchedulerLaterThan(date.time).map { TodoDTO(it) }
    }
}