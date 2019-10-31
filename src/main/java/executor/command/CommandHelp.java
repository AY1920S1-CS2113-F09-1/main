package executor.command;

import executor.task.TaskList;
import ui.Ui;
import ui.Wallet;

public class CommandHelp extends Command {

    /**
     * Constructor to provide the user with the details about the commands available.
     */
    public CommandHelp(String userInput) {
        this.userInput = userInput;
        this.description = "Provides the user with all the available commands and descriptions.";
        this.commandType = CommandType.HELP;
    }

    @Override
    public void execute(TaskList taskList) {
        for (String s : CommandType.getNames()) {
            if (!s.equals("ERROR") && !s.equals("TASK") && !s.equals("BLANK")) {
                CommandType commandType = CommandType.valueOf(s);
                Command c = Executor.createCommand(commandType, "null");
                String commandDesc = c.getDescription();

                System.out.println(s.toUpperCase() + " - " + commandDesc);
            }
        }
        Ui.printSeparator();
    }

    @Override
    public void execute(Wallet wallet) {
    }
}
