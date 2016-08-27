package fr.lteconsulting.angular2gwt.demos.tourofheroes.client;

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
		template = "<h1>{{title}}</h1><h2>{{hero}} details!</h2>" )
@JsType
public class ApplicationComponent
{
	public String title = "Tour of Heroes";
	public String hero = "Windstorm";
}
