package io.muzoo.lorenzo.ssc.zork.command.impl;

import io.muzoo.lorenzo.ssc.zork.Game;
import io.muzoo.lorenzo.ssc.zork.command.Command;

import java.util.HashMap;
import java.util.Map;

public class HelpCommand implements Command {

    private static final Map<String, String> helpDesc = new HashMap<>();

    static {
        helpDesc.put("help", "help: Prints the list of commands.");
        helpDesc.put("quit", "quit: End the current game and return to the main menu.");
        helpDesc.put("info", "info: Prints out information of the player and the room they are currently in. Only available in-game.");
        helpDesc.put("take", "take: Pick up the item in the current room. Only available in-game.");
        helpDesc.put("drop", "Drop a specified item. Only available in-game.");
        helpDesc.put("attack with", "attack with: Attack the monster in the current room. Only available in-game.");
        helpDesc.put("go", "go [direction]: Move to the adjacent room in the specified direction. Only available in-game.");
        helpDesc.put("map", "map: Prints out the map.");
        helpDesc.put("room stats", "room stats: Displays what's in the room.");
        helpDesc.put("play", "play [map-name]: Start a new game. Only available in the start.");
        helpDesc.put("load", "load [saved-point-name]: Loads a game state from a saved point. Only available at the start.");
        helpDesc.put("save", "save [saved-point-name]: Saves the current game state. Only available in-game.");
        helpDesc.put("exit", "Exits the whole game. Only available from the main menu.");
    }


    @Override
    public void execute(Game game, String argument) {
        if (argument != null) {
            System.out.println(helpDesc.getOrDefault(argument, "This command does not exist, try again."));

        } else {
            System.out.println(helpDesc.keySet().toString());
            System.out.println("Enter help [command] for a description of the command.");
        }

    }
}
