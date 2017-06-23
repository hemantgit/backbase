package com.backbase.pages;

import org.openqa.selenium.By;

import com.backbase.global.BackbaseGlobal;

public class BackbaseElements {
	
	BackbaseGlobal bg = new BackbaseGlobal();
	
	By addNewComp = By.xpath("//*[@id='add']");
	By compName = By.xpath("//*[@id='name']");
    By introDate = By.xpath("//*[@id='introduced']");
    By discDate = By.id("discontinued");
}
