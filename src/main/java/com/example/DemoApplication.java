package com.example;

import com.jcabi.log.Logger;
import io.hawt.config.ConfigFacade;
import io.hawt.springboot.EnableHawtio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;

@SpringBootApplication
@Configuration
@EnableWs
@EnableHawtio
public class DemoApplication {

	public static void main(String[] args) {
		System.setProperty("hawtio.authenticationEnabled", "false");
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public ConfigFacade configFacade() {
		Logger.debug(this, "configFacade()");
		final ConfigFacade facade = new ConfigFacade() {
			@Override
			public boolean isOffline() {
				return true;
			}

		};
		return facade;
	}
}
