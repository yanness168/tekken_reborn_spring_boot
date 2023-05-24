package com.cpan228.tekkenrebirn;

import com.cpan228.tekkenrebirn.controllers.AboutController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TekkenrebirnApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TekkenrebirnApplication.class, args);
		AboutController controller = context.getBean(AboutController.class);
	}
}

