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
		selector = "my-app",
		template = "<h1>{{title}}</h1>"
				+ "<h2>My Heroes</h2>"
				+ "<ul class='heroes'>"
				+ "<li *ngFor='let hero of heroes'"
				+ " (click)='onSelect(hero)'"
				+ " [class.selected]='hero === selectedHero'>"
				+ " <span class='badge'>{{hero.id}}</span> {{hero.name}}"
				+ "</li>"
				+ "<my-hero-detail [hero]='selectedHero'></my-hero-detail>"
				+ "</ul>",
		styleUrls = "application.component.css",
		providers = HeroService.class )
@JsType
public class ApplicationComponent implements OnInit
{
	public String title = "Tour of Heroes";
	public Hero selectedHero = null;
	public JsArray<Hero> heroes;
	
	private HeroService heroService;

	public ApplicationComponent( HeroService heroService )
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
		heroService.getHeroes().then( heroes -> this.heroes = heroes );
	}
}