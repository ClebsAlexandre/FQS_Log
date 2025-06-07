package springboot.controller;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.dtos.CustomerRecordDto;
import springboot.model.Customer;
import springboot.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/register")
    public ResponseEntity<?> customerRegister(@RequestBody @Valid CustomerRecordDto customerRecordDto) {

        var customerModel = new Customer();
        BeanUtils.copyProperties(customerRecordDto, customerModel);

        return ResponseEntity.ok().body(customerRepository.save(customerModel));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> listAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        return ResponseEntity.ok().body(customers);
    }



    @GetMapping("/search/{name}")
    public ResponseEntity<Object> searchCustomer(@PathVariable(value = "name") String name) {
        Optional<Customer> optionalCustomer = customerRepository.findByName(name);

        if (optionalCustomer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(optionalCustomer);

    }





    @PatchMapping("/update/{name}")
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



    @DeleteMapping("/remove/{name}")
    public ResponseEntity<?> customerRemove(@PathVariable String name) {
        Optional<Customer> optionalCustomer = customerRepository.findByName(name);

        if (optionalCustomer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Customer deletedCustomer = optionalCustomer.get();
        customerRepository.delete(deletedCustomer);

        return ResponseEntity.ok().body(deletedCustomer);

    }
}
