package fr.lteconsulting.angular2gwt.demos.tourofheroes.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnInit;
import fr.lteconsulting.angular2gwt.client.interop.ng.router.Router;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsType;

@Component(
		selector = "my-dashboard",
		templateUrl = "dashboard.component.html" )
@JsType
public class DashboardComponent implements OnInit
{
	public JsArray<Hero> heroes = JsArray.empty();

	private HeroService heroService;
	private Router router;

	public DashboardComponent( HeroService heroService, Router router )
	{
		this.heroService = heroService;
		this.router = router;
	}

	@Override
	public void ngOnInit()
	{
		heroService.getHeroes().then( heroes -> this.heroes = heroes.slice( 1, 5 ) );
	}

	public void gotoDetail( Hero hero )
	{
		JsArray<?> link = JsArray.of( "/detail", String.valueOf( hero.id ) );
		router.navigate( link );
	}
}
