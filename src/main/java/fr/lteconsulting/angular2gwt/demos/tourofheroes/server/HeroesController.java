package fr.lteconsulting.angular2gwt.demos.tourofheroes.server;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.lteconsulting.angular2gwt.demos.tourofheroes.client.Hero;

@RestController
@RequestMapping( "/app/" )
public class HeroesController
{
	@Autowired
	HeroesRepository heroRepository;

	@GetMapping( "/heroes" )
	public Collection<Hero> getHeroes()
	{
		return heroRepository.getHeroes();
	}

	@GetMapping( value = "/heroes", params = "name" )
	List<Hero> getHeroes( @RequestParam String name )
	{
		return heroRepository.searchHeroesByName( name );
	}

	@PostMapping( "/heroes" )
	Hero addHero( @RequestBody Hero hero )
	{
		return heroRepository.addHero( hero );
	}

	@PutMapping( "/heroes" )
	Hero updateHero( @RequestBody Hero hero )
	{
		return heroRepository.updateHero( hero );
	}

	@DeleteMapping( "/heroes/{id}" )
	Boolean deleteHero( @PathVariable( "id" ) int id )
	{
		return heroRepository.deleteHero( id );
	}
}
