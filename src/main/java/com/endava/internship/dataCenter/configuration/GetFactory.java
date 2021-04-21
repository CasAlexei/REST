package com.endava.internship.dataCenter.configuration;

import com.endava.internship.dataCenter.model.Employees;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;


public class GetFactory {

    @Bean
    void factory() {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employees.class)
                .buildSessionFactory();
    }
}

