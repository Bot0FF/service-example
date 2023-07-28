package org.ibs.service.rest.v2;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.ibs.service.domian.EmployeeRepository;
import org.ibs.service.domian.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController("employee controller v2")
@RequestMapping("/v2/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    Iterable<Employee> getAll(@RequestParam(required = false) String firstName) {
        if(firstName == null) {
            return repository.findAll();
        }
        return repository.findAllByFirstName(firstName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(operationId = "addEmp", summary = "Adds new employee.")
    Employee newEmployee(@RequestBody Employee employee) {
        log.info("-----------------------------------------------");
        if(employee.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Found Id, Use PUT instead of POST.");
        }
        return repository.save(employee);
    }

    @GetMapping("/{id}")
    Employee getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/boss/{id}")
    List<Employee> getAllByBossId(@PathVariable Long bossId) {
        if(bossId == null) {
            return null;
        }
        return repository.findAllByBoss(bossId);
    }

    @GetMapping("/findBoss/{id}")
    Employee getBossByEmployeeId(@PathVariable Long id) {
        Employee employee = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return repository.findById(employee.getBoss().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
