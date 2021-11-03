package com.funkoa.Kaldstart

import com.funkoa.Kaldstart.models.NewThing
import com.funkoa.Kaldstart.models.Thing
import com.funkoa.Kaldstart.models.toDbThing
import com.funkoa.Kaldstart.models.toThing
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/api"])
class Controllers (
    val thingRepository: DbThingRepository,
    val privateNoteRepository: PrivateNoteRepository
) {

    // things
    @GetMapping(path = ["{uuid}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getThingByUuid(@PathVariable uuid: String): ResponseEntity<List<Thing>> {
        val things: List<DbThing> = thingRepository.getDbThingByUuid(uuid)
        return ResponseEntity.ok(things.map { it.toThing() })
    }

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun newThing(@RequestBody newThing: NewThing): ResponseEntity<Thing> {
        val dbThing: DbThing = thingRepository.saveAndFlush(newThing.toDbThing())
        return ResponseEntity.ok(dbThing.toThing())
    }

    @DeleteMapping(path = ["{uuid}"], produces = [MediaType.TEXT_PLAIN_VALUE])
    fun deleteThingByUuid(@PathVariable uuid: String): ResponseEntity<Unit> {
        thingRepository.deleteDbThingByUuid(uuid)
        return ResponseEntity.ok().build()
    }

    // private notes
    @GetMapping(path = ["/private-notes/all"])
    fun getPrivateNotes(): ResponseEntity<List<PrivateNote>>{
        return ResponseEntity.ok(privateNoteRepository.findAll().toList())
    }

    @PostMapping(path = ["/private-notes/new"])
    fun newPrivateNoteEndpoint(@RequestBody note: String): ResponseEntity<PrivateNote> {
        val privateNote = privateNoteRepository.saveAndFlush(PrivateNote(note = note))
        return ResponseEntity.ok(privateNote)
    }

}
