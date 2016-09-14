package fr.lteconsulting.angular2gwt.demos.tourofheroes.server;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestParam;

import fr.lteconsulting.angular2gwt.demos.tourofheroes.client.Hero;

public class HeroesRepository
{
	private final Map<Integer, Hero> HEROES = new HashMap<>();
	private int nextId = 42;

	public HeroesRepository()
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

	public Collection<Hero> getHeroes()
	{
		return HEROES.values();
	}

	public List<Hero> searchHeroesByName( @RequestParam String name )
	{
		return HEROES.values().stream()
				.filter( hero -> hero.name.toLowerCase().contains( name.toLowerCase() ) )
				.collect( Collectors.toList() );
	}

	public Hero addHero( Hero hero )
	{
		hero.id = nextId++;

		storeHero( hero );

		return hero;
	}

	public Hero updateHero( Hero hero )
	{
		assert hero.id > 0;

		storeHero( hero );

		return hero;
	}

	public boolean deleteHero( int id )
	{
		return HEROES.remove( id ) != null;
	}

	private void storeHero( Hero hero )
	{
		HEROES.put( hero.id, hero );
	}
}
