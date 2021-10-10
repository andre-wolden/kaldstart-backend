package com.funkoa.Kaldstart

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


@Controller("/")
class KaldstartController {

    @GetMapping
    fun getKaldstartData(): String {
        return "Best med en skikkelig kaldstart"
    }
}