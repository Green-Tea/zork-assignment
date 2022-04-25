package io.muzoo.lorenzo.ssc.zork.command;

public class CommandLine {

    private CommandType commandType;

    private String argument;

    public CommandLine(CommandType commandType, String argument) {
        this.commandType = commandType;
        this.argument = argument;
    }

    public CommandType getCommand() {
        return commandType;
    }

    public String getCommandString() { return commandType.getCommandWord().toLowerCase(); }

    public String getArgument() {
        return argument;
    }

}
