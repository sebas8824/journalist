package com.demo.journalist.service

import com.demo.journalist.data.dto.entity.NoteDTO
import com.demo.journalist.data.entities.api.Note
import com.demo.journalist.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service("Note service")
class NoteService {

    @Autowired
    lateinit var repository: NoteRepository

    fun getNotes(): Iterable<NoteDTO> = repository.findAll().map() { NoteDTO(it) }

    fun insertNote(note: NoteDTO) = NoteDTO(repository.save(Note(title = note.title, message = note.message, location = note.location)))

    fun deleteNote(id: String) = repository.deleteById(id)

    fun updateNote(noteDto: NoteDTO): NoteDTO {
        var note = repository.findById(noteDto.id).get()
        note.title = noteDto.title
        note.message = noteDto.message
        note.location = noteDto.location
        note.modified = Date()
        note = repository.save(note)
        return NoteDTO(note)
    }

    fun findByTitle(title: String): Iterable<NoteDTO> {
        return repository.findByTitle(title).map { NoteDTO(it) }
    }
}