package executor.command;

import duke.exception.DukeException;
import executor.task.TaskList;
import interpreter.Parser;
import ui.ReceiptTracker;
import ui.Ui;
import ui.Wallet;

public class CommandGetSpendingByYear extends Command {
    private String userInput;

    /**
     * Constructor to explain about the method.
     * @param userInput userInput from CLI
     */
    public CommandGetSpendingByYear(String userInput) {
        this.commandType = CommandType.EXPENDEDYEAR;
        this.userInput = userInput;
        this.description = "Provides the user the total expenditure for the year stated. "
                + "Format : expendedyear <year>";
    }

    @Override
    public void execute(Wallet wallet) {
        try {
            ReceiptTracker receiptsInYear = new ReceiptTracker();
            String yearStr = Parser.parseForPrimaryInput(CommandType.EXPENDEDYEAR, userInput);
            if (yearStr.length() > 4) {
                throw new Exception();
            }
            if (yearStr.length() != 4) {
                System.out.println("Wrong year input. Must be 4 digits, i.e. 2019");
                return;
            }
            int year = Integer.parseInt(yearStr);
            receiptsInYear = wallet.getReceipts().findReceiptByYear(year);
            Double totalMoney = receiptsInYear.getTotalCashSpent();
            Ui.dukeSays("The total amount of money spent in " + year + " : $" + totalMoney);
        } catch (Exception e) {
            System.out.println("Error with command. Has to be 'expendedyear'");
        }
    }

    @Override
    public void execute(TaskList taskList) {
    }

}

