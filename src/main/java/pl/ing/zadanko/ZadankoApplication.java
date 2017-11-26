package pl.ing.zadanko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ZadankoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZadankoApplication.class, args);
	}

}
