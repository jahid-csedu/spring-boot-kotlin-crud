package com.example.restpoints.service

import com.example.restpoints.entity.Employee
import com.example.restpoints.repository.EmployeeRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class EmployeeService(val employeeRepository: EmployeeRepository) {
    fun getAll(): List<Employee> = employeeRepository.findAll()

    fun getById(id: Long): Employee = employeeRepository.findByIdOrNull(id) ?:
        throw ResponseStatusException(HttpStatus.NOT_FOUND)

    fun create(employee: Employee): Employee = employeeRepository.save(employee)

    fun remove(id: Long) {
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id)
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }

    fun update(id: Long, employee: Employee): Employee {
        return if (employeeRepository.existsById(id)) {
            employee.id = id
            employeeRepository.save(employee)
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }
}