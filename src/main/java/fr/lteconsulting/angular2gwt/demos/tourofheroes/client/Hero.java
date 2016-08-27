package fr.lteconsulting.angular2gwt.demos.tourofheroes.client;

import jsinterop.annotations.JsType;

@JsType
public class Hero
{
	public int id;
	public String name;

	public Hero( int id, String name )
	{
		this.id = id;
		this.name = name;
	}
}