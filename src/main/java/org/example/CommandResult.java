package org.example;

import org.example.commands.Command;

/**
 * @author Mikhail Kadilov
 * The 'CommandResult' class allows you to work with commands
 */
public class CommandResult {
    private Command command;
    private String[] args;

    public CommandResult(Command command, String[] args) {
        this.command = command;
        this.args = args;
    }

    public Command getCommand() {
        return command;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }
}
