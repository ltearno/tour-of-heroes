package fr.lteconsulting.angular2gwt.demos.tourofheroes.client;

import com.google.gwt.core.client.GWT;

import fr.lteconsulting.angular2gwt.client.JSON;
import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.JsObject;
import fr.lteconsulting.angular2gwt.client.interop.ng.http.Headers;
import fr.lteconsulting.angular2gwt.client.interop.ng.http.Http;
import fr.lteconsulting.angular2gwt.client.interop.promise.Promise;
import fr.lteconsulting.angular2gwt.ng.core.Injectable;
import jsinterop.annotations.JsType;

@Injectable
@JsType
public class HeroService
{
	private Http http;

	private static final String heroesUrl = "app/heroes"; // URL to web api
	private static final Headers headers = new Headers();

	static
	{
		headers.append( "Content-Type", "application/json" );
	}

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

	public Promise<?> delete( int id )
	{
		String url = heroesUrl + "/" + id;
		return http.delete( url )
				.toPromise()
				.then( response -> null )
				.onCatch( this::handleError );
	}

	public Promise<Hero> save( Hero hero )
	{
		if( hero.id > 0 )
			return update( hero );

		hero.id = 0;

		return create( hero );
	}

	public Promise<Hero> create( Hero hero )
	{
		return http.post( heroesUrl,
				JSON.stringify( hero ),
				new JsObject().set( "headers", headers ) )
				.toPromise()
				.<Hero> then( response -> response.json() )
				.onCatch( this::handleError );
	}

	public Promise<Hero> update( Hero hero )
	{
		return http.put( heroesUrl,
				JSON.stringify( hero ),
				new JsObject().set( "headers", headers ) )
				.toPromise()
				.<Hero> then( response -> response.json() )
				.onCatch( this::handleError );
	}

	private Promise<?> handleError( Object error )
	{
		GWT.log( "An error occurred" + error ); // for demo purposes only
		return Promise.reject( error );
	}
}
