package com.backbase;

import org.junit.BeforeClass;

import com.backbase.global.BackbaseLandingPage;

public class BackbaseSetup {
	
	public static BackbaseLandingPage blp = new BackbaseLandingPage();
	
	
	@BeforeClass
	public static void navigateToLandingPage(){
		
			blp.landingPageNavigation();
		
	}

}
