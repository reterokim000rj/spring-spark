package com.springspark.training;

import com.springspark.training.spark.SparkConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApplication.run(SparkConfig.class).getClass(), args);
	}

}
