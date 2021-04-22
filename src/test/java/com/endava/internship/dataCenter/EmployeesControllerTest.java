package com.endava.internship.dataCenter;

import com.endava.internship.dataCenter.controller.EmployeesController;
import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.model.Employees;
import com.endava.internship.dataCenter.repository.EmployeeRepository;
import com.endava.internship.dataCenter.service.EmployeesService;
import lombok.Lombok;
import org.assertj.core.api.AbstractStringAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
//@WebMvcTest
//@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeesControllerTest {

    @InjectMocks
    EmployeesController employeesControllerTest;
    private MockMvc mockMvc;
    @Mock
    private EmployeesService employeesService;
    @Mock
    private EmployeeRepository employeeRepository;


    Employees employee1;
    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(employeesControllerTest).build();

        employee1 = new Employees();
        employee1.setEmployeeId(1);
        employee1.setFirstName("Alexei");
        employee1.setLastName("Casian");
        employee1.setEmail("email@mail.ru");
        employee1.setPhoneNumber("0123456789");
        employee1.setHireDate(LocalDate.of(2003, 05, 05));
        employee1.setJobId("U_MAN");
        employee1.setSalary(10000.0);
        employee1.setCommissionPct(0.5);
    }


    @Test
    public void getEmployeeByIdTest() throws Exception {

        when(employeesService.getEmployeeById(1)).thenReturn(employee1);
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/1")).andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/2")).andExpect(status().isNotFound());
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/null")).andExpect(status().isBadRequest());


//        ArgumentCaptor<Employees> captor = ArgumentCaptor.forClass(Employees.class);
//        verify(employeesService).getEmployeeById(1);
//        assertThat(captor.getValue().getFirstName()).isEqualTo("Alexei");
//        assertThat(captor.getValue().getLastName()).isEqualTo("Casian");
//        assertThat(captor.getValue().getEmail()).isEqualTo("email@mail.ru");
//        assertThat(captor.getValue().getPhoneNumber()).isEqualTo("0123456789");
//        assertThat(captor.getValue().getJobId()).isEqualTo("U_MAN");
//        assertThat(captor.getValue().getSalary()).isEqualTo(10000.0);
//        assertThat(captor.getValue().getCommissionPct()).isEqualTo(0.5);

        mockMvc.perform(MockMvcRequestBuilders.get("/employees/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());

        mockMvc.perform(MockMvcRequestBuilders.post("/employees").content("{\n" +
                "    \"firstName\": \"Peter\",\n" +
                "    \"lastName\": \"Tucker\",\n" +
                "    \"email\": \"320PTUCKER@mail.ru\",\n" +
                "    \"phoneNumber\": \"0123456789\",\n" +
                "    \"hireDate\": \"2005-01-30\",\n" +
                "    \"salary\": 2000.0,\n" +
                "    \"commissionPct\": 0.33,\n" +
                "    \"jobId\": \"PU_MAN\"\n" +
                "}"));
    }

    @Test
    public void getEmployeesTest() throws Exception {
        when(employeesService.getAllEmployees()).thenReturn(Arrays.asList(employee1));
        mockMvc.perform(MockMvcRequestBuilders.get("/employees")).andExpect(status().isOk());

        when(employeesService.getAllEmployees()).thenReturn(Arrays.asList());
        mockMvc.perform(MockMvcRequestBuilders.get("/employees")).andExpect(status().isNotFound());
    }

    @Test
    public void addEmployeeTest() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("Alexei");
        employeeDto.setLastName("Casian");
        employeeDto.setEmail("email@mail.ru");
        employeeDto.setPhoneNumber("0123456789");
        employeeDto.setHireDate(LocalDate.of(2003, 05, 05));
        employeeDto.setJobId("U_MAN");
        employeeDto.setSalary(10000.0);
        employeeDto.setCommissionPct(0.5);


        when(employeesService.addEmployee(employeeDto)).thenReturn(employee1);
        mockMvc.perform(MockMvcRequestBuilders.post("/employees")).andExpect(status().isOk());

    }



}
