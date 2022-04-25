package io.muzoo.lorenzo.ssc.zork.command.impl;

import io.muzoo.lorenzo.ssc.zork.Game;
import io.muzoo.lorenzo.ssc.zork.command.Command;

import java.io.*;

public class SaveCommand implements Command {
    @Override
    public void execute(Game game, String argument) {

        if (game.isInGame()) {
            File file = new File("C://ZorkSave//" + argument + ".txt");

            if (argument == null) {
                System.out.println("Please specify the save name.");

            } else {

                try {
                    if (!file.createNewFile()) {
                        FileWriter fw = new FileWriter("C://ZorkSave//" + argument + ".txt", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                        pw.println(game.getCommandTracker().trim());
                        game.createNewCommandTracker();
                        pw.flush();

                        pw.close();
                        bw.close();
                        fw.close();
                        System.out.println("Your save file has been overwritten.");
                    } else {
                        System.out.println("Creating new save file...");
                        FileWriter saveFile = new FileWriter("C://ZorkSave//" + argument + ".txt");
                        saveFile.write(game.getCommandTracker());
                        game.createNewCommandTracker();
                        saveFile.close();
                        System.out.println("Your game has been saved.");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("You may only use this command in game.");
        }
    }
}
