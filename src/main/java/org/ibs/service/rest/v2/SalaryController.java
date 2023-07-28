package org.ibs.service.rest.v2;

import io.swagger.v3.oas.annotations.Operation;
import org.ibs.service.bussines.SalaryService;

import org.ibs.service.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("v2/salary/")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @GetMapping("max/department/{departmentId}")
    @Operation(operationId = "maxSalaryEmployeeInDep", summary = "Get max salary employee.")
    Employee maxSalaryEmployeeInDepartment(@PathVariable Long departmentId) {
        return salaryService.maxSalaryEmployeeInDepartment(departmentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Department or employees not found."));

    }

    @GetMapping("salary/more/{departmentId}")
    @Operation(operationId = "salaryMoreThenBoss", summary = "Get salary employee.")
    List<Employee> salaryMoreThenBoss(@PathVariable Long id) {
        return salaryService.salaryMoreThenBoss(id);
    }

}
