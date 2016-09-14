package fr.lteconsulting.angular2gwt.demos.tourofheroes.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan( basePackageClasses = ApplicationController.class )
public class ApplicationController
{
	public static void main( String[] args ) throws Exception
	{
		SpringApplication.run( ApplicationController.class, args );
	}

	@Bean
	@Scope( WebApplicationContext.SCOPE_APPLICATION )
	public HeroesRepository get()
	{
		return new HeroesRepository();
	}
}