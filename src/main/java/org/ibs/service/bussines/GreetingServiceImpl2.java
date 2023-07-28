package org.ibs.service.bussines;

import org.ibs.service.domian.entity.Employee;
import org.slf4j.Logger;

public class GreetingServiceImpl2 implements GreetingService {

    private Logger log;

    public GreetingServiceImpl2(Logger log) {
        this.log = log;
    }

    @Override
    public void sayHello(Employee employee) {
        log.info("Hello from test version " + employee.getFirstName());
    }
}
