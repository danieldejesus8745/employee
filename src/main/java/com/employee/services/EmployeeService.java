package com.employee.services;

import com.employee.dto.EmployeeDTO;
import com.employee.entities.Employee;
import com.employee.mappers.EmployeeMapper;
import com.employee.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public void addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setRole(employeeDTO.getRole());
        employee.setCreatedAt(LocalDateTime.now());

        employeeRepository.save(employee);
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeMapper.toListEmployeeDTO(employeeRepository.findAll());
    }

}
