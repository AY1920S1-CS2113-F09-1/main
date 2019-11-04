package executor.command;
import ui.IncomeReceipt;
import ui.gui.MainWindow;

public class CommandAddIncomeReceipt extends CommandAddReceipt {

    /**
     * Constructor for CommandAddIncomeReceipt subCommand Class.
     * @param userInput The user input from the CLI
     */
    public CommandAddIncomeReceipt(String userInput) {
        this.commandType = CommandType.IN;
        this.userInput = userInput;
        this.cash = extractIncome(this.commandType, this.userInput);
        this.date = extractDate(this.userInput);
        this.tags = extractTags(this.userInput);
        this.description = "You can add a new income receipt in format of 'In $5.00 /date 2019-01-01 /tags tag'.";
    }

    @Override
    public void execute(MainWindow gui) {
        IncomeReceipt r = new IncomeReceipt(this.cash, this.date, this.tags);
        gui.getWallet().addReceipt(r);
        gui.displayToast("Added Receipt: $" + r.getCashGained().toString() + "with tags: " + r.getTags().toString());
    }
}
