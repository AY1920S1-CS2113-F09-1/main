package executor.command;

import duke.exception.DukeException;
import executor.task.TaskList;
import interpreter.Parser;
import ui.ReceiptTracker;
import ui.Ui;
import ui.Wallet;

public class CommandGetSpendingByMonth extends Command {
    protected String userInput;

    /**
     * Constructor to explain about the command.
     * @param userInput is the input from the user
     */
    public CommandGetSpendingByMonth(String userInput) {
        this.commandType = CommandType.EXPENDEDMONTH;
        this.userInput = userInput;
        this.description = "Provides the user the total expenditure for the month stated. "
                + "FORMAT: expendedmonth <month> /year<year>";
    }
    
    @Override
    public void execute(TaskList taskList) {
    }

    @Override
    public void execute(Wallet wallet) {
        try {
            ReceiptTracker receiptsInMonth = new ReceiptTracker();
            String monthStr = Parser.parseForPrimaryInput(CommandType.EXPENDEDMONTH, userInput);
            int month = monthStrToInt(monthStr);
            String yearStr = Parser.parseForFlag("year", userInput);

            if (month == 0) {
                System.out.println("Wrong month input. Check Spelling");
                return;
            }

            if (yearStr.length() != 4) {
                System.out.println("Wrong year input. Must be 4 digits, i.e. 2019");
                return;
            }

            int year = Integer.parseInt(yearStr);
            receiptsInMonth = wallet.getReceipts().findReceiptByMonthYear(month, year);
            Double totalMoney = receiptsInMonth.getTotalCashSpent();
            Ui.dukeSays("The total amount of money spent in " + monthStr + " " + year + " : $" + totalMoney);

        }
        catch (Exception e) {
            System.out.println("Wrong input. CORRECT FORMAT : expendedmonth <month> /year <year>");
        }
    }


    /**
     * Returns the corresponding month value.
     * @param month is the name of month from the userInput
     * @return the value of month, eg: march --> 3.
     */
    public int monthStrToInt(String month) {
        switch (month) {
        case "january":
            return 1;
        case "february":
            return 2;
        case "march":
            return 3;
        case "april":
            return 4;
        case "may":
            return 5;
        case "june":
            return 6;
        case "july":
            return 7;
        case "august":
            return 8;
        case "september":
            return 9;
        case "october":
            return 10;
        case "november":
            return 11;
        case "december":
            return 12;
        default:
            return 0;
        }
    }
}
