package com.employee.mappers;

import com.employee.dto.EmployeeDTO;
import com.employee.entities.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper {

    public List<EmployeeDTO> toListEmployeeDTO(List<Employee> employees) {
        ArrayList<EmployeeDTO> employeeList = new ArrayList<>();

        for (Employee employee : employees) {
            employeeList.add(toEmployeeDTO(employee));
        }

        return employeeList;
    }

    public EmployeeDTO toEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setRole(employee.getRole());
        employeeDTO.setCreatedAt(employee.getCreatedAt());

        return employeeDTO;
    }

}
