package fr.lteconsulting.angular2gwt.demos.tourofheroes.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.GlobalScope;
import fr.lteconsulting.angular2gwt.client.interop.promise.Promise;
import fr.lteconsulting.angular2gwt.ng.core.Injectable;
import jsinterop.annotations.JsType;

@Injectable
@JsType
public class HeroService
{
	private static final JsArray<Hero> HEROES = JsArray.of(
			new Hero( 11, "Mr. Nice" ),
			new Hero( 12, "Narco" ),
			new Hero( 13, "Bombasto" ),
			new Hero( 14, "Celeritas" ),
			new Hero( 15, "Magneta" ),
			new Hero( 16, "RubberMan" ),
			new Hero( 17, "Dynama" ),
			new Hero( 18, "Dr IQ" ),
			new Hero( 19, "Magma" ),
			new Hero( 20, "Tornado" ) );

	public Promise<JsArray<Hero>> getHeroes()
	{
		return Promise.resolve( HEROES );
	}

	public Promise<Hero> getHero( int id )
	{
		return getHeroes().then( heroes -> heroes.find( hero -> hero.id == id ) );
	}

	public Promise<JsArray<Hero>> getHeroesSlowly()
	{
		return new Promise<>( ( resolver, rejecter ) -> {
			GlobalScope.setTimeout( () -> resolver.resolve( null ), 2000 );
		} ).then( nop -> getHeroes() );
	}
}
