package com.demo.journalist.repository

import com.demo.journalist.data.entities.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository: CrudRepository<Note, String> {
    fun findByTitle(title: String): Iterable<Note>
}