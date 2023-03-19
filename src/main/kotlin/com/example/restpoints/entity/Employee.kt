package com.example.restpoints.entity

import jakarta.persistence.*

@Entity
@Table(name = "employee")
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    val name: String,
    val age: Int,
    val department: String
)
