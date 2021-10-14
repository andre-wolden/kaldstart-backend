package com.funkoa.Kaldstart

import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*
import java.io.Serializable

@Entity(name = "thing")
@Table( name = "THING")
data class Thing (
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "thing_sequence_generator")
    @SequenceGenerator(
        name = "thing_sequence_generator",
        sequenceName = "thing_sequence",
        allocationSize = 50
    )
    val id: Long = 0,

    @Column(name = "name", updatable = true, nullable = false)
    val name: String
): Serializable {

}

interface ThingRepository: JpaRepository<Thing, Long>
