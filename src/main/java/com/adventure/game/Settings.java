package com.adventure.game;

import utilities.Utilities;

public class Settings {
	//Settings methods
	
	//Setting to adjust text speed (NOT IMPLEMENTED)
	public static int selectTextSpeed() {
		Utilities.slowPrint("This is the default text speed.");
		Utilities.slowPrint("");
		return 50;
	}
}
