package fr.lteconsulting.angular2gwt.demos.tourofheroes.client;

import fr.lteconsulting.angular2gwt.client.JsArray;
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
				+ "<li *ngFor='let hero of heroes'>"
				+ "<span class='badge'>{{hero.id}}</span> {{hero.name}}"
				+ "</li>"
				+ "</ul>"
				+ "<h2>{{hero.name}} details!</h2>"
				+ "<div><label>id: </label>{{hero.id}}</div>"
				+ "<div><label>name: </label><input [(ngModel)]='hero.name' placeholder='name'></div>",
		styleUrls = "application.component.css" )
@JsType
public class ApplicationComponent
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

	public String title = "Tour of Heroes";
	public Hero hero = new Hero( 1, "Windstorm" );
	public JsArray<Hero> heroes = HEROES;
}