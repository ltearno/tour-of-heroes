package fr.lteconsulting.angular2gwt.demos.tourofheroes.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
import fr.lteconsulting.angular2gwt.client.interop.ng.core.OnInit;
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
		template = "<h2>My Heroes</h2>"
				+ "<ul class='heroes'>"
				+ "<li *ngFor='let hero of heroes'"
				+ " (click)='onSelect(hero)'"
				+ " [class.selected]='hero === selectedHero'>"
				+ " <span class='badge'>{{hero.id}}</span> {{hero.name}}"
				+ "</li>"
				+ "</ul>"
				+ "<my-hero-detail [hero]='selectedHero'></my-hero-detail>",
		styleUrls = "application.component.css" )
@JsType
public class HeroesComponent implements OnInit
{
	public Hero selectedHero = null;
	public JsArray<Hero> heroes;

	private HeroService heroService;

	public HeroesComponent( HeroService heroService )
	{
		this.heroService = heroService;
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

	private void getHeroes()
	{
		heroService.getHeroesSlowly().then( heroes -> this.heroes = heroes );
	}
}