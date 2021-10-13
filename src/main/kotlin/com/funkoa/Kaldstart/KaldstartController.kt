package com.funkoa.Kaldstart

import com.funkoa.Kaldstart.models.KaldstartModel
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class KaldstartController {

    @GetMapping(path = ["/"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getKaldstart(): ResponseEntity<KaldstartModel> {
        return ResponseEntity.ok(KaldstartModel(name = "André"))
    }
}
