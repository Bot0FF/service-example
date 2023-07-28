package org.ibs.service;


import org.ibs.service.domian.EmployeeRepository;
import org.ibs.service.domian.entity.Course;
import org.ibs.service.domian.entity.Department;
import org.ibs.service.domian.entity.Employee;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)
//@ActiveProfiles("test")
public class DbTest {
//
//    @PersistenceContext
//    EntityManager em;
//
//    @Autowired
//    EmployeeRepository employeeRepository;
//
//    @Before
//    public void setup() {
//
//        Department department = new Department(null, "IT", null);
//        Course course = new Course(null, "REST service");
//        Employee emp = new Employee(null, "a", "a",
//                LocalDate.now(), department, 500000, List.of(course), null);
//
//        em.persist(department);
//        em.persist(course);
//        em.persist(emp);
//
//        em.flush();
//    }
//
//   @Test
//  public void test() {
//       Assert.assertEquals(1, em.createQuery("FROM Department")
//               .getResultList().size());
//       Employee emp = em.createQuery("FROM Department", Employee.class)
//               .setMaxResults(1)
//               .getResultList()
//               .get(0);
//
//       Assert.assertEquals("REST service", emp.getCourses().get(0).getName());
//  }
//
//    @Test
//    public void test2() {
//        //Employee emp = employeeRepository.findAllByFirstName("a").get();
//        //Assert.assertEquals("REST service", emp.getCourses().get(0).getName());
//    }
}
