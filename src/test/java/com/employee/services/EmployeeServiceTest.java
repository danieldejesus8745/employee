package com.employee.services;

import com.employee.dto.EmployeeDTO;
import com.employee.mappers.EmployeeMapper;
import com.employee.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private EmployeeMapper employeeMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void mustAddEmployee() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("Albert Einstein");
        employeeDTO.setRole("Physicist");

        employeeService.addEmployee(employeeDTO);

        verify(employeeRepository, times(1)).save(any());
    }

    @Test
    void mustGetAllEmployees() {
        String name = "Albert Einstein";
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName(name);
        employeeDTO.setRole("Physicist");

        when(employeeMapper.toListEmployeeDTO(any())).thenReturn(List.of(employeeDTO));

        List<EmployeeDTO> expected = employeeService.getAllEmployees();

        assertThat(expected.get(0).getName()).isEqualTo(name);
    }

}
