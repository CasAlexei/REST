package com.endava.internship.dataCenter;

import com.endava.internship.dataCenter.controller.EmployeesController;
import com.endava.internship.dataCenter.model.EmployeeDto;
import com.endava.internship.dataCenter.repository.EmployeeRepository;
import com.endava.internship.dataCenter.service.EmployeesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;

import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
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

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(employeesControllerTest).build();
    }

    @Test
    public void getEmployeeTestExceptionIdNull() throws Exception {
        EmployeeDto employeesDto = new EmployeeDto();

        employeesDto.setFirstName("Alexei");
        employeesDto.setLastName("Casian");
        employeesDto.setEmail("email@mail.ru");
        employeesDto.setPhoneNumber("0123456789");
        employeesDto.setHireDate(LocalDate.of(2003, 05, 05));
        employeesDto.setJobId("U_MAN");
        employeesDto.setSalary(10000.0);
        employeesDto.setCommissionPct(0.5);

        ArgumentCaptor<EmployeeDto> captor = ArgumentCaptor.forClass(EmployeeDto.class);
when(employeesService.getAllEmployees()).thenReturn(Arrays.asList());
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

        //employeesControllerTest.addEmployee(employeesDto);

        //verify(employeesService.addEmployee(captor.capture()));

        //assertThat(captor.getValue().getFirstName().equals("Alexei"));


    }
}
