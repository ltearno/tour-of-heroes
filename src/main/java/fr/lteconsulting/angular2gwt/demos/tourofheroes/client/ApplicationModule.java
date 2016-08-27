package fr.lteconsulting.angular2gwt.demos.tourofheroes.client;

import fr.lteconsulting.angular2gwt.client.interop.ng.forms.FormsModule;
import fr.lteconsulting.angular2gwt.client.interop.ng.platformBrowser.BrowserModule;
import fr.lteconsulting.angular2gwt.ng.core.NgModule;
import jsinterop.annotations.JsType;

@NgModule(
		imports = {
				BrowserModule.class,
				FormsModule.class,
				Routes.class },
		declarations = {
				ApplicationComponent.class,
				DashboardComponent.class,
				HeroesComponent.class,
				HeroDetailComponent.class
		},
		providers = {
				HeroService.class
		},
		entryComponents = {
				HeroesComponent.class,
				DashboardComponent.class
		},
		bootstrap = {
				ApplicationComponent.class
		} )
@JsType
public class ApplicationModule
{
}
