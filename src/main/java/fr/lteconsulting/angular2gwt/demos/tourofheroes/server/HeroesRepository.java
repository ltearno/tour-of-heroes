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
	private final Map<Integer, Hero> heroes = new HashMap<>();
	private int nextId = 42;

	public HeroesRepository()
	{
		storeHero( new Hero( generateId(), "Mr. Nice" ) );
		storeHero( new Hero( generateId(), "Narco" ) );
		storeHero( new Hero( generateId(), "Bombasto" ) );
		storeHero( new Hero( generateId(), "Celeritas" ) );
		storeHero( new Hero( generateId(), "Magneta" ) );
		storeHero( new Hero( generateId(), "RubberMan" ) );
		storeHero( new Hero( generateId(), "Dynama" ) );
		storeHero( new Hero( generateId(), "Dr IQ" ) );
		storeHero( new Hero( generateId(), "Magma" ) );
		storeHero( new Hero( generateId(), "Tornado" ) );
	}

	public Collection<Hero> getHeroes()
	{
		return heroes.values();
	}

	public List<Hero> searchHeroesByName( @RequestParam String name )
	{
		return heroes.values().stream()
				.filter( hero -> hero.name.toLowerCase().contains( name.toLowerCase() ) )
				.collect( Collectors.toList() );
	}

	public Hero addHero( Hero hero )
	{
		hero.id = generateId();

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
		return heroes.remove( id ) != null;
	}

	private void storeHero( Hero hero )
	{
		heroes.put( hero.id, hero );
	}

	private int generateId()
	{
		return nextId++;
	}
}
