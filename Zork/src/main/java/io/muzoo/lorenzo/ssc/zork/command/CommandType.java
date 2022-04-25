package io.muzoo.lorenzo.ssc.zork.command;

import io.muzoo.lorenzo.ssc.zork.command.impl.*;

public enum CommandType {
    INFO(InfoCommand.class, "info", true, false),
    EXIT(ExitCommand.class, "exit", false, true),
    HELP(HelpCommand.class, "help",true, true),
    TAKE(TakeCommand.class, "take", true, false),
    USE(UseCommand.class, "use", true, false),
    DROP(DropCommand.class, "drop", true, false),
    ATTACK_WITH(AttackWithCommand.class, "attack with", true, false),
    GO(GoCommand.class, "go", true, false),
    MAP(MapCommand.class, "map", true, false),
    ROOM_STATS(RoomStatsCommand.class, "room stats", true, false),
    QUIT(QuitCommand.class, "quit", true, false),
    PLAY(PlayCommand.class, "play", false, true),
    LOAD(LoadCommand.class, "load", false, true),
    SAVE(SaveCommand.class, "save", false, true)
    ;


    private Class<? extends Command> commandClass;
    private String commandWord;
    private boolean inGame;
    private boolean inMenu;

    CommandType(Class<? extends Command> commandClass, String commandWord, Boolean inGame, Boolean inMenu) {
        this.commandClass = commandClass;
        this.commandWord = commandWord;
        this.inGame = inGame;
        this.inMenu = inMenu;

    }

    public Class getCommandClass() {
        return commandClass;
    }

    public String getCommandWord() {
        return commandWord;
    }

    public boolean isInGame() {
        return inGame;
    } 

    public boolean isInMenu() {
        return inMenu;
    }

    public boolean match(String rawInput) {
        return rawInput.startsWith(commandWord);
    }
}
