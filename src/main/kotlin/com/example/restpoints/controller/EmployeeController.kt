package com.example.restpoints.controller

import com.example.restpoints.entity.Employee
import com.example.restpoints.service.EmployeeService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/employees")
class EmployeeController(val employeeService: EmployeeService) {
    @GetMapping
    fun getAllEmployees(): List<Employee> = employeeService.getAll()

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: Long): Employee = employeeService.getById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveEmployee(@RequestBody employee: Employee): Employee = employeeService.create(employee)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteEmployeeById(@PathVariable id: Long) = employeeService.remove(id)

    @PutMapping("/{id}")
    fun updateEmployee(@PathVariable id: Long, @RequestBody employee: Employee): Employee = employeeService.update(id, employee)
}