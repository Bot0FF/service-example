package org.ibs.service.bussines;

import org.ibs.service.domian.EmployeeRepository;
import org.ibs.service.domian.entity.Department;
import org.ibs.service.domian.DepartmentRepository;

import org.ibs.service.domian.entity.Employee;
import org.ibs.service.dto.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SalaryService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper mapper;

    public Optional<org.ibs.service.dto.Employee> maxSalaryEmployeeInDepartment(Long departmentId) {
        Optional<Department> departmentOpt = departmentRepository.findById(departmentId);
        if(departmentOpt.isEmpty() || departmentOpt.get().getEmployees().isEmpty()) {
            return Optional.empty();
        }

        Employee employee = departmentOpt.get().getEmployees().stream()
                .max((e1, e2) -> e1.getMonthSalary().compareTo(e2.getMonthSalary())).get();

        return Optional.of(mapper.toDto(employee));
    }


    public List<org.ibs.service.dto.Employee> salaryMoreThenBoss(Long departmentId) {
        Iterable<Employee> employees = employeeRepository.findAll();
        List<org.ibs.service.dto.Employee> salaryMoreThenBoss = new ArrayList<>();
        for(Employee employee : employees) {
            if(employee.getMonthSalary() > employee.getBoss().getMonthSalary()) {
                salaryMoreThenBoss.add(mapper.toDto(employee));
            }
        }

        return salaryMoreThenBoss;
    }
}
