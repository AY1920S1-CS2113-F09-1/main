package executor.command;

import duke.exception.DukeException;
import executor.task.Task;
import executor.task.TaskList;
import executor.task.TaskType;
import interpreter.Parser;
import ui.gui.MainWindow;

public class CommandNewTask extends Command {
    protected String userInput;
    protected TaskType taskType;

    /**
     * Constructor for the CommandNewTask subCommand Class.
     * @param userInput The user input from the CLI.
     */
    public CommandNewTask(String userInput) {
        this.userInput = userInput;
        this.commandType = CommandType.TASK;
        this.taskType = extractTaskType();
        this.description = "Adds user entry to the list";
    }

    @Override
    public void execute(MainWindow gui) {
        if (this.taskList == null) {
            this.taskList = gui.getTaskList();
        }
        try {
            checkForwardSlash(this.userInput);
        } catch (DukeException e) {
            gui.displayToast("Error Queuing Task");
            return;
        }
        Task newTask = TaskList.createTask(this.taskType, this.userInput);
        this.taskList.addTask(newTask);
        gui.displayToast("I've added "
                + newTask.genTaskDesc()
                + " to your private list("
                + String.valueOf(this.taskList.getSize())
                + ")."
        );
    }

    /**
     * Throws an exception when there is no '/' in the user input.
     * @param input this is the user's input
     * @throws DukeException this shows the error message and gives the format to follow
     */
    private void checkForwardSlash(String input) throws DukeException {
        if (this.taskType.equals(TaskType.FDURATION)) {
            if (!Parser.containsForwardSlash(input)) {
                throw new DukeException("Check your format!!! Correct format is: fduration <description> / <time>");
            }
        }
    }

    private TaskType extractTaskType() {
        CommandType specificCommandType = Parser.parseForCommandType(this.userInput);
        if (specificCommandType == null) {
            return TaskType.BLANK;
        } else {
            return TaskType.valueOf(specificCommandType.toString());
        }
    }
}
