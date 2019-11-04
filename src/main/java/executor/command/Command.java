package executor.command;

import executor.task.TaskList;
import ui.Wallet;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {
    private static List<String> executedCommands;
    protected Boolean exitRequest = false;
    protected String userInput = null;
    protected CommandType commandType;
    protected String description = "NO DESCRIPTION";


    // Constructor
    public Command() {
    }

    /**
     * Returns True if the command requests for the Ui to exit.
     *
     * @return Boolean
     */
    public Boolean getExitRequest() {
        return exitRequest;
    }

    /**
     * Executes a particular Command.
     */
    public abstract void execute(TaskList taskList);

    public abstract void execute(Wallet wallet);

    public String getDescription() {
        return this.description;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public static List<String> getExecutedCommands() {
        return executedCommands;
    }
}
