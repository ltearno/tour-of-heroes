package fr.lteconsulting.angular2gwt.demos.tourofheroes.client;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsType;

@JsType
public class Hero
{
	public int id;
	public String name;
	
	@JsConstructor
	public Hero()
	{
		id = 0;
		name = null;
	}

	@JsIgnore
	public Hero( int id, String name )
	{
		this();
		
		this.id = id;
		this.name = name;
	}
}