package com.example.springdatajpaqueries;

import com.example.springdatajpaqueries.entity.Employee;
import com.example.springdatajpaqueries.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by mtumilowicz on 2018-10-08.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringDataJpaQueriesTest {

    @Autowired
    EmployeeRepository repository;
    
    @Test
    @Transactional
    public void findAllStream() {
        try (Stream<Employee> all = repository.findAllStream()) {
            assertThat(all.count(), is(4L));
        }
    }
}