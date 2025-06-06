package springboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.dtos.CustomerRecordDto;
//import springboot.dtos.EmployeeRecordDto;
import springboot.model.Customer;
//import springboot.model.Employee;
import springboot.model.User;
import springboot.repository.CustomerRepository;
import springboot.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerRepository customerRepository;

//    @PostMapping("/employee/register")
//    public ResponseEntity<?>  saveEmployee(@RequestBody @Valid EmployeeRecordDto employeeRecordDto) {
//
//        var employeeModel = new Employee();
//        BeanUtils.copyProperties(employeeRecordDto, employeeModel);
//
//        return ResponseEntity.ok().body(userRepository.save(employeeModel));
//
//    }

    @PostMapping("/customer/register")
    public ResponseEntity<?> customerRegister(@RequestBody @Valid CustomerRecordDto customerRecordDto) {
        Customer customerModel = new Customer();
        BeanUtils.copyProperties(customerRecordDto, customerModel);

        return ResponseEntity.ok().body(customerRepository.save(customerModel));
    }

    @GetMapping("/customer/list")
    public ResponseEntity<List<Customer>> listAllCustomer() {
        List<Customer> customers = customerRepository.findAll();

        return ResponseEntity.ok().body(customers);
    }

    @GetMapping("/customer/search/{name}")
    public ResponseEntity<Object> searchCustomer(@PathVariable(value = "name") String name) {
        Optional<Customer> optionalCustomer = customerRepository.findByName(name);

        if (optionalCustomer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(optionalCustomer);

    }

    @PatchMapping("/employee/update/{name}")
    public void employeeUpdate() {

    }

    @PatchMapping("/customer/update/{name}")
    public ResponseEntity<Customer> customerUpdate(@PathVariable String name, @RequestBody @Valid CustomerRecordDto customerUpdate) {

        Optional<Customer> optionalCustomer = customerRepository.findByName(name);

        if (optionalCustomer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Customer customer = optionalCustomer.get();

        customer.setName(customerUpdate.name());
        customer.setLogin(customerUpdate.login());
        customer.setPassword(customerUpdate.password());
        customer.setEmail(customerUpdate.email());
        customer.setCpf(customerUpdate.cpf());


        customerRepository.save(customer);

        return ResponseEntity.ok().body(customer);

    }

    @DeleteMapping("/employee/remove/{name}")
    public void employeeDelete() {

    }

    @DeleteMapping("/customer/remove/{name}")
    public ResponseEntity<?> customerRemove(@PathVariable String name) {
        Optional<Customer> optionalCustomer = customerRepository.findByName(name);

        if (optionalCustomer.isEmpty()) {
            return ResponseEntity.status(404).body("Cliente não encontrado");
        }

        Customer deletedCustomer = optionalCustomer.get();
        customerRepository.delete(deletedCustomer);

        return ResponseEntity.ok(deletedCustomer);

    }
}
