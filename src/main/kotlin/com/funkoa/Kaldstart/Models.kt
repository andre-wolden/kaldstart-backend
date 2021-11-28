package com.funkoa.Kaldstart.models

import com.funkoa.Kaldstart.DbThing

data class Thing(
    val uuid: String,
    val name: String
)

data class NewThing(
    val name: String
)

fun NewThing.toDbThing(): DbThing = DbThing(
    name = this.name
)

fun DbThing.toThing(): Thing = Thing(
    uuid = this.uuid,
    name = this.name
)

data class RestNewNote(
    val note: String
)
