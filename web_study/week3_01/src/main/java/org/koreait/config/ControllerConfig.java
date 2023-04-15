package org.koreait.config;

import org.koreait.controllers.HelloController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"org.koreait.controllers", "org.koreait.models"})
public class ControllerConfig {
	

}
