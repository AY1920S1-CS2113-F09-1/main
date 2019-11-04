package executor.command;

import duke.exception.DukeException;
import executor.task.TaskList;
import interpreter.Parser;
import ui.ReceiptTracker;
import ui.Ui;
import ui.Wallet;



public class CommandDateList extends Command {
    private String date;

    //Constructor
    /**
     * Constructor for CommandListMonYear subCommand Class.
     * @param userInput String is the user input from the CLI
     */
    public CommandDateList(String userInput) {
        this.userInput = userInput;
        this.description = "Lists receipts based on date input. Format: datelist <date>";
        this.commandType = CommandType.DATELIST;
        this.date = Parser.parseForPrimaryInput(this.commandType, userInput);
    }

    @Override
    public void execute(TaskList taskList) {

    }

    @Override
    public void execute(Wallet wallet) {
        try {
            ReceiptTracker dateReceipts = new ReceiptTracker();
            dateReceipts = wallet.getReceipts().findReceiptsByDate(this.date);
            if (this.date.isEmpty()) {
                Ui.dukeSays("No date input detected. FORMAT : datelist yyyy/mm/dd");
                return;
            }
            Ui.dukeSays("You have the following receipts for" + " " + date);
            Ui.printSeparator();
            dateReceipts.printReceipts();
            Ui.printSeparator();
        } catch (Exception e) {
            Ui.dukeSays("Wrong format. FORMAT : datelist yyyy/mm/dd");
        }
    }
}



