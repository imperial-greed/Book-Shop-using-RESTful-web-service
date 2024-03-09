package com.example.bookshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
     
//@ComponentScan(basePackages = "com.example.bookshop.controllers")
@SpringBootApplication(
       //scanBasePackages = "com.example.bookshop",
        exclude = {DataSourceAutoConfiguration.class}
)
public class BookshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookshopApplication.class, args);
	}

}
