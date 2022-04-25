package io.muzoo.lorenzo.ssc.zork;

import io.muzoo.lorenzo.ssc.zork.command.*;
import io.muzoo.lorenzo.ssc.zork.map.Map;
import io.muzoo.lorenzo.ssc.zork.map.MapFactory;
import io.muzoo.lorenzo.ssc.zork.map.MapType;
import io.muzoo.lorenzo.ssc.zork.map.Room;

import java.util.Objects;
import java.util.Scanner;

public class Game {

    private boolean exit = false;
    private Player player = new Player();
    private Room currentRoom;
    public Map currentMap;
    private boolean inGame = false;
    private boolean inMenu = true;
    private Scanner scanner = new Scanner(System.in);
    private StringBuilder commandTracker = new StringBuilder();

    public boolean isExit() {
        return exit;
    }

    public void exit() {
        this.exit = true;
        scanner.close();

    }

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void start() {
        try {
            while (!isExit()) {
                if (inMenu) {
                    mainMenu();
                } else {
                    String rawInput = scanner.nextLine();
                    CommandLine commandLine = CommandParser.parse(rawInput);
                    try {
                        Command command = CommandFactory.get(Objects.requireNonNull(commandLine).getCommand());
                        command.execute(this, commandLine.getArgument());

                        if (!commandLine.getCommandString().equals("save") && !commandLine.getCommandString().equals("load") && !commandLine.getCommandString().equals("quit")) {
                            addCommandTracker(rawInput);
                        }

                        if (currentMap.taskComplete()) {
                            System.out.println("You have conquered this floor!");
                            setInGame(false);
                            setInMenu(true);
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Invalid command, try again.");
                    }
                }
            }
        } catch (IllegalStateException e) {
            System.out.println("Quitting game...");
        }

    }

    public void mainMenu() {
        System.out.println("========Welcome to Zork!========");
        System.out.println("AVAILABLE MAPS:");
        for (MapType map : MapFactory.getAvailableMap().keySet()) {
            System.out.println("* " + map.getMapName());
        }

        createNewCommandTracker();

        while (inMenu) {
            String rawInput = scanner.nextLine();
            CommandLine commandLine = CommandParser.parse(rawInput);
            try {
                Command command = CommandFactory.get(Objects.requireNonNull(commandLine).getCommand());
                command.execute(this, commandLine.getArgument());

                if (commandLine.getCommandString().equals("play")) {
                    if (inGame) {
                        addCommandTracker(rawInput);
                    }
                }

            } catch (NullPointerException e) {
                System.out.println("Invalid command, try again.");
            }
        }
    }


    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public void setInMenu(boolean inMenu) {
        this.inMenu = inMenu;
    }

    public Map getCurrentMap() {
        return this.currentMap;
    }

    public void goToRoom(Room room) {
        this.currentRoom = room;
    }

    public void setCurrentMap(String currentMap) {
        for (MapType map : MapFactory.getAvailableMap().keySet()) {
            if (currentMap.equals(map.getMapName())) {
                MapFactory factory = new MapFactory();
                this.currentMap = factory.createMap(map);
                this.currentRoom = this.currentMap.getStartingRoom();
            }
        }
    }

    public void addCommandTracker(String input) {
        commandTracker.append(input);
        commandTracker.append("\n");
    }

    public void createNewCommandTracker() {
        commandTracker = new StringBuilder();
    }

    public String getCommandTracker() {
        return commandTracker.toString();
    }

    public boolean isInMenu() {
        return inMenu;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void initiate(MapType mapName) {
        player = new Player();
        setCurrentMap(mapName.getMapName());
    }
}
