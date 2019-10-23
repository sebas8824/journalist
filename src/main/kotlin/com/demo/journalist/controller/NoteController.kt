package com.demo.journalist.controller

import com.demo.journalist.data.dto.request.NoteFindByTitleRequest
import com.demo.journalist.data.dto.entity.NoteDTO
import com.demo.journalist.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notes")
class NoteController {
    @Autowired
    private lateinit var service: NoteService

    @GetMapping(produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getNotes(): Iterable<NoteDTO> = service.getNotes()

    @PostMapping(produces = arrayOf(MediaType.APPLICATION_JSON_VALUE), consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun insertNote(@RequestBody note: NoteDTO) = service.insertNote(note)

    @DeleteMapping("/{id}", produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun deleteNote(@PathVariable(name = "id") id: String) = service.deleteNote(id)

    @PutMapping(produces = arrayOf(MediaType.APPLICATION_JSON_VALUE), consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun updateNote(@RequestBody note: NoteDTO) = service.updateNote(note)

    @PostMapping("/title", produces= arrayOf(MediaType.APPLICATION_JSON_VALUE), consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getByNotesTitle(@RequestBody payload: NoteFindByTitleRequest): Iterable<NoteDTO> =
            service.findByTitle(payload.title)

}