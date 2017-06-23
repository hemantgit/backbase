package com.backbase;


import org.junit.BeforeClass;

import com.backbase.global.BackbaseLandingPage;
import com.backbase.global.SetUpAndTearDown;

public class BackbaseSetup extends SetUpAndTearDown {
	
	public static BackbaseLandingPage lp = new BackbaseLandingPage();
	
	
	@BeforeClass
	public static void navigateToLandingPage(){
		
			lp.landingPageNavigation();
		
	}
}
