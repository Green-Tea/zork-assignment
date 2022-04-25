package io.muzoo.lorenzo.ssc.zork.command.impl;

import io.muzoo.lorenzo.ssc.zork.Game;
import io.muzoo.lorenzo.ssc.zork.command.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class LoadCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (game.isInMenu()) {
            if (argument == null) {
                System.out.println("You must specify a file name.");
            } else {
                File file = new File("C://ZorkSave//"+argument+".txt");

                try {
                    Scanner scanner = new Scanner(file);

                    while (scanner.hasNextLine()) {
                        String rawInput = scanner.nextLine();
                        CommandLine commandLine = CommandParser.parse(rawInput);
                        Command command = CommandFactory.get(Objects.requireNonNull(commandLine).getCommand());
                        command.execute(game, commandLine.getArgument());

                    }

                } catch (FileNotFoundException e) {
                    System.out.println("Invalid save name.");
                }
            }
        } else {
            System.out.println("You may only use this command in the main menu.");
        }
    }
}
