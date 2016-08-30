package fr.lteconsulting.angular2gwt.demos.tourofheroes.server;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.lteconsulting.angular2gwt.demos.tourofheroes.client.Hero;

@RestController
@RequestMapping( "/app/" )
public class HeroesController
{
	private static final Map<Integer, Hero> HEROES = new HashMap<>();
	private static int nextId = 42;

	static
	{
		storeHero( new Hero( 11, "Mr. Nice" ) );
		storeHero( new Hero( 12, "Narco" ) );
		storeHero( new Hero( 13, "Bombasto" ) );
		storeHero( new Hero( 14, "Celeritas" ) );
		storeHero( new Hero( 15, "Magneta" ) );
		storeHero( new Hero( 16, "RubberMan" ) );
		storeHero( new Hero( 17, "Dynama" ) );
		storeHero( new Hero( 18, "Dr IQ" ) );
		storeHero( new Hero( 19, "Magma" ) );
		storeHero( new Hero( 20, "Tornado" ) );
	}

	private static void storeHero( Hero hero )
	{
		HEROES.put( hero.id, hero );
	}

	@RequestMapping( value = "/heroes", method = RequestMethod.GET )
	public Collection<Hero> getHeroes()
	{
		return HEROES.values();
	}

	@RequestMapping( value = "/heroes", method = RequestMethod.POST, produces = "application/json" )
	Hero addHero( @RequestBody Hero hero )
	{
		hero.id = nextId++;

		storeHero( hero );

		return hero;
	}

	@RequestMapping( value = "/heroes/{id}", method = RequestMethod.PUT, produces = "application/json" )
	Hero updateHero( @PathVariable( "id" ) int id, @RequestBody Hero hero )
	{
		assert hero.id == id;

		storeHero( hero );

		return hero;
	}

	@RequestMapping( value = "/heroes/{id}", method = RequestMethod.DELETE )
	Boolean deleteHero( @PathVariable( "id" ) int id )
	{
		return HEROES.remove( id ) != null;
	}
}
