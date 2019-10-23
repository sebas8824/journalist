package com.demo.journalist.controller

import com.demo.journalist.data.dto.request.TodoLaterThanRequest
import com.demo.journalist.data.dto.entity.TodoDTO
import com.demo.journalist.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class TodoController {

    @Autowired
    private lateinit var service: TodoService

    @GetMapping(produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getTodos(): Iterable<TodoDTO> = service.getTodos()

    @PostMapping(produces = arrayOf(MediaType.APPLICATION_JSON_VALUE), consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun insertTodo(@RequestBody todo: TodoDTO): TodoDTO = service.insertTodo(todo)

    @DeleteMapping("/{id}", produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun deleteTodo(@PathVariable(name = "id") id: String) = service.deleteTodo(id)

    @PutMapping(produces = arrayOf(MediaType.APPLICATION_JSON_VALUE), consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun updateTodo(@RequestBody todo: TodoDTO) = service.updateTodo(todo)

    @PostMapping("/lt", produces = arrayOf(MediaType.APPLICATION_JSON_VALUE), consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getTodosLaterThan(@RequestBody payload: TodoLaterThanRequest): Iterable<TodoDTO>
            = service.getScheduledLaterThan(payload.date)
}