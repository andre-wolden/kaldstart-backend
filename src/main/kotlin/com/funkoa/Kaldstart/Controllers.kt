package com.funkoa.Kaldstart

import com.funkoa.Kaldstart.models.*
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import sh.ory.kratos.ApiClient
import sh.ory.kratos.Configuration
import sh.ory.kratos.api.V0alpha2Api

@RestController
@RequestMapping(path = ["/api"])
@CrossOrigin(origins = ["http://127.0.0.1:3000", "http://localhost:3000"])
class Controllers(
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
    fun getPrivateNotes(): ResponseEntity<List<PrivateNote>> {
        return ResponseEntity.ok(privateNoteRepository.findAll().toList())
    }

    @PostMapping(path = ["/private-notes/new"])
    fun newPrivateNoteEndpoint(@RequestBody restNewNote: RestNewNote): ResponseEntity<PrivateNote> {
        val privateNote = privateNoteRepository.saveAndFlush(PrivateNote(note = restNewNote.note))
        return ResponseEntity.ok(privateNote)
    }

    @GetMapping(path = ["/user"])
    fun getUserPage(){
        val defaultClient: ApiClient = Configuration.getDefaultApiClient()

        defaultClient.

        val apiInstance = V0alpha2Api(defaultClient)
        try {
            apiInstance.getSelfServiceLoginFlow()


        } catch (e: Exception) {
            println(e.message)
        }


    }

}
