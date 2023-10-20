package com.adventure.game;
import handlers.*;
import entities.*;
import rooms.*;

public class Main {
	public static void main(String[] args) {
		//Initialize inputScanner
		InputHandler inputHandler = new InputHandler();
		
		//Player sets name
		String playerName = Intro.getPlayerName(inputHandler);
		
		//Initialize Player object
		Player player = new Player(playerName);
		
		//Display introduction
		Intro.displayIntro(player);
		
		//Enter room test
		DungeonRoom dungeonRoom = DungeonRoom.getInstance(); //Get the only instance of dungeonRoom
		dungeonRoom.enterRoom(player, inputHandler);
		
		
		
		
		
//		//Goblin encounter test
//		Goblin g1 = new Goblin();
//		
//		//Start combat
//		CombatHandler combatHandler = new CombatHandler();
//		combatHandler.startCombat(player, g1, inputHandler);
		
		
		
		//Close scanner at the end of the program
		inputHandler.closeScanner();
	}

}
