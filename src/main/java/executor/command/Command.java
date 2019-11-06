package executor.command;

import executor.task.TaskList;
import storage.StorageManager;
import utils.InfoCapsule;

public abstract class Command {
    protected InfoCapsule infoCapsule;
    protected String userInput = null;
    protected CommandType commandType;
    protected String description = "NO DESCRIPTION";
    protected TaskList taskList;

    // Constructor

    /**
     * Base Constructor for all sub-classes to call super().
     */
    public Command() {
        this.infoCapsule = new InfoCapsule();
        infoCapsule.setCodeError();
        infoCapsule.setOutputStr("Command was not executed.\n");
    }

    /**
     * Returns an InfoCapsule that details the Execution Info/Status of this Command.
     * @return Boolean
     */
    public InfoCapsule getInfoCapsule() {
        return this.infoCapsule;
    }

    /**
     * Executes a particular Command.
     * @param storageManager StorageManager Object that holds all the Models of Duke
     */
    public abstract void execute(StorageManager storageManager);

    public String getDescription() {
        return this.description;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }
}
