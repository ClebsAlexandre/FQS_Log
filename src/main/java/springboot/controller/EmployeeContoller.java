package springboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.dtos.EmployeeRecordDto;
import springboot.model.Employee;
import springboot.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeContoller {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/register")
    public ResponseEntity<?> saveEmployee(@RequestBody @Valid EmployeeRecordDto employeeRecordDto) {

        var employeeModel = new Employee();
        BeanUtils.copyProperties(employeeRecordDto, employeeModel);

        return ResponseEntity.ok().body(employeeRepository.save(employeeModel));

    }

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> listAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Object> searchEmployee(@PathVariable(value = "name") String name) {
        Optional<Employee> optionalEmployee = employeeRepository.findByName(name);

        if (optionalEmployee.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(optionalEmployee);

    }

    @PatchMapping("/update/{name}")
    public ResponseEntity<Employee> employeeUpdate(@PathVariable String name, @RequestBody @Valid EmployeeRecordDto employeeUpdate) {

        Optional<Employee> optionalEmployee = employeeRepository.findByName(name);

        if (optionalEmployee.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Employee employee = optionalEmployee.get();

        employee.setName(employeeUpdate.name());
        employee.setLogin(employeeUpdate.login());
        employee.setPassword(employeeUpdate.password());
        employee.setEmail(employeeUpdate.email());
        employee.setBadgeNumber(employeeUpdate.badgeNumber());
        employee.setSalary(employeeUpdate.salary());


        employeeRepository.save(employee);

        return ResponseEntity.ok().body(employee);

    }

    @DeleteMapping("/remove/{name}")
    public ResponseEntity<?> employeeRemove(@PathVariable String name) {

        Optional<Employee> optionalEmployee = employeeRepository.findByName(name);

        if(optionalEmployee.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Employee deletedEmployee = optionalEmployee.get();
        employeeRepository.delete(deletedEmployee);

        return ResponseEntity.ok().body(deletedEmployee);

    }
}
