package com.funkoa.Kaldstart

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import javax.persistence.*
import java.io.Serializable
import org.springframework.data.jpa.repository.Query
import java.util.*
import javax.transaction.Transactional

@Entity(name = "DbThing")
@Table( name = "DB_THING")
data class DbThing (
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "db_thing_sequence_generator")
    @SequenceGenerator(
        name = "db_thing_sequence_generator",
        sequenceName = "db_thing_sequence",
        allocationSize = 50
    )
    val id: Long = 0,

    @Column(name = "uuid", updatable = false, nullable = false)
    val uuid: String = UUID.randomUUID().toString(),

    @Column(name = "name", updatable = true, nullable = false)
    val name: String

): Serializable

interface DbThingRepository: JpaRepository<DbThing, Long> {
    @Query("SELECT t FROM DbThing t WHERE t.uuid  = :uuid")
    fun getDbThingByUuid(uuid: String): List<DbThing>

    @Query("DELETE FROM DbThing t WHERE t.uuid = :uuid")
    @Modifying
    @Transactional
    fun deleteDbThingByUuid(uuid: String)
}
