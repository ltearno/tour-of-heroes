package fr.lteconsulting.angular2gwt.demos.tourofheroes.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lteconsulting.angular2gwt.demos.tourofheroes.client.Hero;

@RestController
@RequestMapping( "/app/" )
public class HeroesController
{
	private static final Collection<Hero> HEROES = new ArrayList<>( Arrays.asList(
			new Hero( 11, "Mr. Nice" ),
			new Hero( 12, "Narco" ),
			new Hero( 13, "Bombasto" ),
			new Hero( 14, "Celeritas" ),
			new Hero( 15, "Magneta" ),
			new Hero( 16, "RubberMan" ),
			new Hero( 17, "Dynama" ),
			new Hero( 18, "Dr IQ" ),
			new Hero( 19, "Magma" ),
			new Hero( 20, "Tornado" ) ) );

	@RequestMapping( "/heroes" )
	public Collection<Hero> heroes()
	{
		return HEROES;
	}
}
