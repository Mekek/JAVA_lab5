package org.example.commands;

/**
 * @author Mikhail Kadilov
 * This class defines the behavior of commands
 */
public abstract class Command {
    public abstract void execute(String [] args);
    private boolean flag = true;

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
