package com.meritamerica.assignment7.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.meritamerica.assignment7.model.repository.UserRepository;
import com.meritamerica.assignment7.model.services.AuthService;

@EnableJpaRepositories(basePackages = "com.meritamerica.assignment7.model.repository")
@SpringBootApplication
public class Assignment7Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment7Application.class, args);
		//MeritBank.readFromFile("src/test/testMeritBank_good.txt");

		MeritBank.listOfOfferings.add(new CDOffering(1,0.018));
		MeritBank.listOfOfferings.add(new CDOffering(3,0.019));
		MeritBank.listOfOfferings.add(new CDOffering(5,0.02));
	}
}
