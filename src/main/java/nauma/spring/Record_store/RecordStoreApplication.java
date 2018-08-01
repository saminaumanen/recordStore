package nauma.spring.Record_store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import nauma.spring.Record_store.domain.Record;
import nauma.spring.Record_store.domain.RecordRepository;
import nauma.spring.Record_store.domain.User;
import nauma.spring.Record_store.domain.UserRepository;



@SpringBootApplication
public class RecordStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(RecordStoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(RecordStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner RecordStore(RecordRepository repository, UserRepository urepository) {
		return (args) -> {
			repository.save(new Record("Content", "Joywave", "2017", "20€"));
			repository.save(new Record("El Camino", "The Black Keys", "2011", "15€"));
			repository.save(new Record("Yours dreamily", "The Arcs", "2015", "20€"));
			
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			 
			 
			log.info("find all");
			for (Record record : repository.findAll()) {
				log.info(record.toString());
			}

		};
	}
	 
}
