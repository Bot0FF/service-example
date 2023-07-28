package org.ibs.service.domian;

import org.ibs.service.domian.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAllByFirstName(String firstName);
    List<Employee> findAllByBoss(Long boss);
}
