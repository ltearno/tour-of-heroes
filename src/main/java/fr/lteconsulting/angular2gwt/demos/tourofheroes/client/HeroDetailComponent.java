package fr.lteconsulting.angular2gwt.demos.tourofheroes.client;

import fr.lteconsulting.angular2gwt.client.JsTools;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.EventEmitter;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnInit;
import fr.lteconsulting.angular2gwt.client.interop.ng.router.ActivatedRoute;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.Output;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-hero-detail",
		templateUrl = "hero-detail.component.html",
		styleUrls = "hero-detail.component.css" )
@JsType
public class HeroDetailComponent implements OnInit
{
	public Hero hero = null;
	
	@Output
	public EventEmitter<Hero> updated = new EventEmitter<>();

	private HeroService heroService;
	private ActivatedRoute route;

	public HeroDetailComponent( HeroService heroService, ActivatedRoute route )
	{
		this.heroService = heroService;
		this.route = route;
	}

	@Override
	public void ngOnInit()
	{
		route.params.forEach( params -> {
			String value = params.get( "id" );
			if( value != null )
			{
				int id = Integer.parseInt( value );
				heroService.getHero( id ).then( hero -> this.hero = hero );
			}
			else
			{
				hero = new Hero();
			}
		} );
	}

	public void save()
	{
		heroService.save( hero )
				.then( hero -> {
					goBack();
					return null;
				} );
	}

	public void goBack()
	{
		updated.emit( hero );
		
		if( hero.id > 0 )
			JsTools.historyGoBack();
	}
}
