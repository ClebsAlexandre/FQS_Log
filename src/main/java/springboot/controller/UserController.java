package springboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.dtos.EmployeeRecordDto;
import springboot.model.Customer;
import springboot.model.Employee;
import springboot.model.User;
import springboot.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/employee/register")
    public ResponseEntity<?>  saveEmployee(@RequestBody @Valid EmployeeRecordDto employeeRecordDto) {

        var employeeModel = new Employee();
        BeanUtils.copyProperties(employeeRecordDto, employeeModel);

        return ResponseEntity.ok().body(userRepository.save(employeeModel));

    }

    @PostMapping("/customer/register")
    public void customerRegister() {

    }

    @GetMapping("/customer/list")
    public void listAllCustomer() {

    }

    @GetMapping("/customer/search/{name}")
    public void searchCustomer() {

    }

    @PatchMapping("/employee/update/{name}")
    public void employeeUpdate() {

    }

    @PatchMapping("/customer/update/{name}")
    public void customerUpdate() {

    }

    @DeleteMapping("/employee/delete/{name}")
    public void employeeDelete() {

    }

    @DeleteMapping("/customer/delete/{name}")
    public void customerDelete() {

    }
}
