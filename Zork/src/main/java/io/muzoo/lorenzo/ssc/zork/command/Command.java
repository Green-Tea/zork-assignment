package io.muzoo.lorenzo.ssc.zork.command;

import io.muzoo.lorenzo.ssc.zork.Game;

import java.util.List;

public interface Command {

    void execute(Game game, String argument);
}
