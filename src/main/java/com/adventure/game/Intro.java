package com.adventure.game;
import handlers.InputHandler;
import utilities.Utilities;
import entities.*;

public class Intro {
	//Just simple methods you want in your introduction
	public static void displayIntro(Player player) {
		Utilities.clearConsole();
		Utilities.slowPrint("Welcome to the game " + player.getName());
		
	}
	
	//Method that uses InputHandler to ask for Player name
	public static String getPlayerName(InputHandler inputHandler) {
		Utilities.clearConsole();
		Utilities.slowPrint("What is your name? ");
		return inputHandler.getUserInput();
	}
	
	
}
