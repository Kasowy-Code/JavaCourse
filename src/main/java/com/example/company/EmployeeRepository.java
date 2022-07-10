package com.example.company;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAllByLastNameAndSalaryGreaterThanEqualOrderBySalaryDesc(String lastName, double salary);

    @Query("SELECT e FROM Employee e WHERE e.salary > 10000")
    List<Employee> findRichEmployees();

    @Query("UPDATE Employee e SET e.salary = e.salary + 100")
    @Modifying
    @Transactional
    void giveRaiseToAll();

    @Query("SELECT e FROM Employee e WHERE e.salary > :min AND e.salary < :max")
    List <Employee> findBySalaryInRange(double min, double max);
}