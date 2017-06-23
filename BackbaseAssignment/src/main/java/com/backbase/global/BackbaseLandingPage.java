package com.backbase.global;

public class BackbaseLandingPage extends BackbaseGlobal{
	
	String url = "http://computer-database.herokuapp.com/computers";
	
	public void landingPageNavigation(){
	
	navigateTo(url);

	}
}