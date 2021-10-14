package com.funkoa.Kaldstart

import com.funkoa.Kaldstart.models.Thing
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controllers {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getThing(): ResponseEntity<Thing> {
        return ResponseEntity.ok(Thing(name = "André"))
    }

    @DeleteMapping(produces = [MediaType.TEXT_PLAIN_VALUE])
    fun deleteThing(): ResponseEntity<String> {
        return ResponseEntity.ok("ok")
    }
}
