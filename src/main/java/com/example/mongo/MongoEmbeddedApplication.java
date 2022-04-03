package com.example.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@SpringBootApplication
public class MongoEmbeddedApplication implements CommandLineRunner {

	@Autowired
	private UserRepo userRepo;

	private MongoClient mongoClient;

	public static void main(String[] args) {
		SpringApplication.run(MongoEmbeddedApplication.class, args);
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		MongoClient mongo = getMongoClient();
		return new MongoTemplate(mongo, "test");
	}

	private MongoClient getMongoClient() {
		if (Objects.nonNull(mongoClient)) {
			return mongoClient;
		}
		mongoClient = MongoClients.create("mongodb://localhost:27017/test");
		return mongoClient;
	}

	@Override
	public void run(String... args) {
		System.out.println("In Run!!!");
		mongoTemplate().insert(new User(new Random().nextLong(), "Ajay", "S", "Pune"));

		List<User> userList = mongoTemplate().findAll(User.class);
		userList.forEach(customer -> System.out.println(customer.getFirstName()));

		userRepo.findAll().forEach(user -> System.out.println(user.getId() + " "
											+ user.getFirstName() + " "
											+ user.getLastName() + " "
											+ user.getCity()));
	}
}
