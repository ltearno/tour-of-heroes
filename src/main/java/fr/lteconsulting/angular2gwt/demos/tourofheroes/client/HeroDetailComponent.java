package fr.lteconsulting.angular2gwt.demos.tourofheroes.client;

import fr.lteconsulting.angular2gwt.client.JsTools;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnInit;
import fr.lteconsulting.angular2gwt.client.interop.ng.router.ActivatedRoute;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import fr.lteconsulting.angular2gwt.ng.core.Input;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-hero-detail",
		templateUrl = "hero-detail.component.html" )
@JsType
public class HeroDetailComponent implements OnInit
{
	@Input
	public Hero hero = null;

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
		} );
	}

	public void goBack()
	{
		JsTools.historyGoBack();
	}
}
