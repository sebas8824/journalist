package com.demo.journalist.repository

import com.demo.journalist.data.entities.Todo
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface TodoRepository: CrudRepository<Todo, String> {

    @Query("from Todo t where t.schedule > ?1")
    fun findSchedulerLaterThan(date: Long): Iterable<Todo>
}