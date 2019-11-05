package executor.command;

import executor.task.TaskList;
import interpreter.Parser;
import ui.ReceiptTracker;
import ui.Ui;
import ui.Wallet;
import java.text.DecimalFormat;

public class CommandTagList extends CommandList {
    private String tag;

    //Constructor
    /**
     * Constructor for CommandListTag subCommand Class.
     * @param userInput The user input from the CLI
     */
    public CommandTagList(String userInput) {
        super(userInput);
        this.userInput = userInput;
        this.description = "Lists based on tag \n"
                + "FORMAT :  ";
        this.commandType = CommandType.TAGLIST;
        this.tag = Parser.parseForPrimaryInput(this.commandType, userInput);
    }

    @Override
    public void execute(TaskList taskList) {

    }

    @Override
       public void execute(Wallet wallet) {
        ReceiptTracker taggedReceipts = wallet.getReceipts().findReceiptsByTag(this.tag);
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        Ui.dukeSays("You spent a total of $"
                +
                decimalFormat.format(taggedReceipts.getTotalCashSpent())
                + " "
                + "on"
                + " "
                + tag
        );
        Ui.printSeparator();
        taggedReceipts.printReceipts();
        Ui.printSeparator();
    }
}
