package com.endava.internship.dataCenter;

import com.endava.internship.dataCenter.controller.EmployeesController;
import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.model.Employees;
import com.endava.internship.dataCenter.repository.EmployeeRepository;
import com.endava.internship.dataCenter.service.EmployeesService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    EmployeeDto employeeDto1;

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

        employeeDto1 = new EmployeeDto();
        employeeDto1.setFirstName("firstnameDTO");
        employeeDto1.setLastName("lastNameDTO");
        employeeDto1.setEmail("dto@mail.ru");
        employeeDto1.setHireDate(LocalDate.of(2003,05,05));
        employeeDto1.setCommissionPct(0.8);
        employeeDto1.setSalary(1111.0);
        employeeDto1.setJobId("U_MAN");
        employeeDto1.setPhoneNumber("0123456789");
    }

    @Test
    public void testGET_getEmployeeById_isOkIfEmployeesIsPresent() throws Exception {
        when(employeesService.getEmployeeById(1)).thenReturn(employee1);
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/1")).andExpect(status().isOk());
    }
    @Test
    public void testGET_getEmployeeById_notFoundIfNotEmployeesWithId() throws Exception {
        when(employeesService.getEmployeeById(1)).thenReturn(employee1);
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/2")).andExpect(status().isNotFound());
    }
    @Test
    public void testGET_getEmployeeById_isBadRequestIfEmployeesIsNull() throws Exception {
        when(employeesService.getEmployeeById(1)).thenReturn(employee1);
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/null")).andExpect(status().isBadRequest());
    }
    @Test
    public void testGET_getEmployeeById_IsOKIfAllIsOkThenSaveEmployees() throws Exception {
        when(employeesService.getEmployeeById(1)).thenReturn(employee1);
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").value(employee1.getEmployeeId()));
    }
    @Test
    public void testGET_getEmployees_IsOKIfListOfEmployeesIsPresent() throws Exception {
        when(employeesService.getAllEmployees()).thenReturn(Arrays.asList(employee1));
        mockMvc.perform(MockMvcRequestBuilders.get("/employees")).andExpect(status().isOk());
    }
    @Test
    public void testGET_getEmployees_IsNotFountIfListOfEmployeesIsEmpty() throws Exception {
        when(employeesService.getAllEmployees()).thenReturn(Arrays.asList());
        mockMvc.perform(MockMvcRequestBuilders.get("/employees")).andExpect(status().isNotFound());
    }
    @Test
    public void testPOST_addEmployee() throws Exception{
        when(employeesService.addEmployee(employeeDto1)).thenReturn(Employees.from(employeeDto1));
        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
                .content(asJsonString(employeeDto1))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
    }
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//    @Test
//    public void testPUT_updateEmployeeById_IsOKIfEmployeesUpdated() throws Exception{
//        //verify(employeesService).updateEmployees(1, employeeDto1);
//        when(employeesService.updateEmployees(1,employeeDto1)).thenReturn(Employees.from(employeeDto1));
//        mockMvc.perform(MockMvcRequestBuilders.put("/employees/1")
//                .content(asJsonString(employeeDto1))
//                .contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(employeeDto1.getFirstName()));
//    }

    @Test
    public void testDELETE_deleteEmployeeTest_IsOkIfIDIsNotNull() throws Exception
    {
        //when(employeesService.deleteEmployee(1)).thenReturn(null);
        mockMvc.perform( MockMvcRequestBuilders.delete("/employees/{id}", 1) )
                .andExpect(status().isOk());
    }
    @Test
    public void testDELETE_deleteEmployeeTest_IsBadRequestIfIDIsNull() throws Exception
    {
        //when(employeesService.deleteEmployee(1)).thenReturn(null);
        mockMvc.perform( MockMvcRequestBuilders.delete("/employees/{id}", 1))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testDELETE_deleteEmployeeTest_IsOkIfEmployeesDeleted() throws Exception
    {
        //when(employeesService.deleteEmployee(1)).thenReturn();
        mockMvc.perform( MockMvcRequestBuilders.delete("/employees/{id}", 1) )
                .andExpect(status().isAccepted());
    }
}
