package fr.lteconsulting.angular2gwt.demos.tourofheroes.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnInit;
import fr.lteconsulting.angular2gwt.client.interop.ng.router.Router;
import fr.lteconsulting.angular2gwt.ng.core.Component;
import jsinterop.annotations.JsType;

/**
 * Main angular component for the application.
 * 
 * <p>
 * It simply binds to the <my-app> tag.
 */
@Component(
		selector = "my-heroes",
		templateUrl = "heroes.component.html",
		styleUrls = "heroes.component.css" )
@JsType
public class HeroesComponent implements OnInit
{
	public Hero selectedHero = null;
	public JsArray<Hero> heroes;

	private HeroService heroService;
	private Router router;

	public HeroesComponent( HeroService heroService, Router router )
	{
		this.heroService = heroService;
		this.router = router;
	}

	@Override
	public void ngOnInit()
	{
		getHeroes();
	}

	public void onSelect( Hero hero )
	{
		selectedHero = hero;
	}

	public void gotoDetail()
	{
		router.navigate( JsArray.of( "/detail", String.valueOf( selectedHero.id ) ) );
	}

	private void getHeroes()
	{
		heroService.getHeroes().then( heroes -> this.heroes = heroes );
	}
}