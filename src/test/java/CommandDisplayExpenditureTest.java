import executor.command.Command;
import executor.command.CommandDisplayExpenditure;
import org.junit.jupiter.api.Test;
import ui.Receipt;
import ui.Wallet;
import ui.gui.MainWindow;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandDisplayExpenditureTest {

    private ByteArrayOutputStream outContent;
    private ByteArrayOutputStream errContent;
    private PrintStream originalOut;
    private PrintStream originalErr;

    private void resetTextTracker() {
        outContent = new ByteArrayOutputStream();
        errContent = new ByteArrayOutputStream();
        originalOut = System.out;
        originalErr = System.err;
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    private void endTextTracker() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void execute() {
        resetTextTracker();
        assertEquals("", outContent.toString().trim());

        resetTextTracker();
        Command c = new CommandDisplayExpenditure("");
        MainWindow gui = new MainWindow();
        Wallet wallet = gui.getWallet();
        c.execute(gui);
        assertEquals("Total Expenditure: $0.00", outContent.toString().trim());

        resetTextTracker();
        for (double x = 0.00; x < 11.0; ++x) {
            Receipt receipt = new Receipt(x);
            wallet.addReceipt(receipt);
        }
        c.execute(gui);
        assertEquals("Total Expenditure: $55.00", outContent.toString().trim());

        endTextTracker();
    }
}
