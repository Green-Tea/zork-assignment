package io.muzoo.lorenzo.ssc.zork.command;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static Map<CommandType, Command> commandMap = new HashMap<>();

    static {
        for (CommandType commandType: CommandType.values()) {
            try {
                Command command = (Command) commandType.getCommandClass().getDeclaredConstructor().newInstance();
                commandMap.put(commandType, command);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    public static Command get(CommandType commandType) {
       return commandMap.get(commandType);
    }
}
