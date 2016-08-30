package fr.lteconsulting.angular2gwt.demos.tourofheroes.client;

import com.google.gwt.core.client.GWT;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.ng.http.Http;
import fr.lteconsulting.angular2gwt.client.interop.promise.Promise;
import fr.lteconsulting.angular2gwt.ng.core.Injectable;
import jsinterop.annotations.JsType;

@Injectable
@JsType
public class HeroService
{
	private Http http;
	private String heroesUrl = "app/heroes"; // URL to web api

	public HeroService( Http http )
	{
		this.http = http;
	}

	public Promise<JsArray<Hero>> getHeroes()
	{
		return http.get( heroesUrl )
				.toPromise()
				.<JsArray<Hero>> then( response -> response.json() )
				.onCatch( this::handleError );
	}

	public Promise<Hero> getHero( int id )
	{
		return getHeroes().then( heroes -> heroes.find( hero -> hero.id == id ) );
	}

	private Promise<?> handleError( Object error )
	{
		GWT.log( "An error occurred" + error ); // for demo purposes only
		return Promise.reject( error );
	}
}
