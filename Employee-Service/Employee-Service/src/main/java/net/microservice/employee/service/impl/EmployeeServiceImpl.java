package net.microservice.employee.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import net.microservice.employee.dto.OrganizationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.microservice.employee.dto.APIResponseDto;
import net.microservice.employee.dto.DepartmentDto;
import net.microservice.employee.dto.EmployeeDto;
import net.microservice.employee.entity.Employee;
import net.microservice.employee.repository.EmployeeRepository;
import net.microservice.employee.service.APIClient;
import net.microservice.employee.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;

//    @Autowired
//    RestTemplate restTemplate;

    @Autowired
    WebClient webClient;


  // private APIClient apiClient;

    //convert Dto to Employee
    public  EmployeeDto mapToEmployeeDto(Employee employee){
        return modelMapper.map(employee,EmployeeDto.class);
    }

    //convert Employee to dto
    public  Employee mapToEmployee(EmployeeDto employeeDto){

        return modelMapper.map(employeeDto,Employee.class);
    }


    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = mapToEmployee(employeeDto);
        Employee saveEmployee = employeeRepository.save(employee);
        return  mapToEmployeeDto(saveEmployee);
    }

 //   @CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
 @Retry(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeById(Long id) {
     LOGGER.info("inside getEmployeeById() method");
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found By Id :" + id));




        // RestTemplate Config
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();


        //WebClient Config
        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
     OrganizationDto orgDto = webClient.get()
             .uri("http://localhost:8082/api/organizations/" + employee.getOrganizationCode())
             .retrieve()
             .bodyToMono(OrganizationDto.class)
             .block();


     //OpenFeign Client
   // DepartmentDto departmentDto = apiClient.getDepartments(employee.getDepartmentCode());


        EmployeeDto employeeDto = mapToEmployeeDto(employee);
        APIResponseDto apiResponseDto= new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(orgDto);

        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long id,Exception exception) {
        LOGGER.info("inside getDefaultDepartment() method");
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found By Id :" + id));


DepartmentDto departmentDto= new DepartmentDto();
departmentDto.setDepartmentName("R&D");
departmentDto.setDepartmentCode("RD001");
departmentDto.setDepartmentDescription("Research & Development");


        EmployeeDto employeeDto = mapToEmployeeDto(employee);
        APIResponseDto apiResponseDto= new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);


        return apiResponseDto;
    }

}
