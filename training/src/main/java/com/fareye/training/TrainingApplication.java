package com.fareye.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fareye.training.utills.CrunchifyGetPropertyValues;

import java.io.IOException;

@SpringBootApplication
public class TrainingApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TrainingApplication.class, args);

		//CrunchifyGetPropertyValues properties = new CrunchifyGetPropertyValues();
		//properties.getPropValues();

	}

}
