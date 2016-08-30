package fr.lteconsulting.angular2gwt.demos.tourofheroes.client;

import com.google.gwt.core.client.GWT;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.angular.rxjs.Observable;
import fr.lteconsulting.angular2gwt.client.interop.angular.rxjs.Subject;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnInit;
import fr.lteconsulting.angular2gwt.client.interop.ng.router.Router;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsType;

@Component(
		selector = "hero-search",
		templateUrl = "hero-search.component.html",
		styleUrls = "hero-search.component.css",
		providers = HeroSearchService.class )
@JsType
public class HeroSearchComponent implements OnInit
{
	public Observable<JsArray<Hero>> heroes;

	private Subject<String> searchTerms = new Subject<>();
	private HeroSearchService heroSearchService;
	private Router router;

	public HeroSearchComponent( HeroSearchService heroSearchService, Router router )
	{
		this.heroSearchService = heroSearchService;
		this.router = router;
	}

	public void search( String term )
	{
		searchTerms.next( term );
	}

	@Override
	public void ngOnInit()
	{
		heroes = searchTerms
				.debounceTime( 300 )
				.distinctUntilChanged()
				.switchMap( ( term, index ) -> {
					if( term != null && !term.isEmpty() )
						return heroSearchService.search( term );
					else
						return Observable.of( JsArray.<Hero> empty() );
				} )
				.onError( reason -> {
					GWT.log( "error: " + reason );
					return Observable.of( JsArray.<Hero> empty() );
				} );
	}

	public void gotoDetail( Hero hero )
	{
		router.navigate( JsArray.of( "/detail", String.valueOf( hero.id ) ) );
	}
}
