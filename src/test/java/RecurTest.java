import duke.task.Recur;
import duke.task.ToDo;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecurTest
{
    @Test
    void initialize() {
        final SimpleDateFormat time = new SimpleDateFormat("HHmm");
        Recur test = new Recur("recurSomething");
        assertEquals("Something", test.taskName, "taskName interpretation error");

        test = new Recur("recur SUing /for daily / 1700 / 1800");
        assertEquals("SUing", test.taskName, "taskName interpretation error");
        assertEquals("daily 1700 1800", test.taskDetails, "taskDetails interpretation error");
        assertEquals("for", test.detailDesc, "detailDesc interpretation error");
        assertEquals("daily", test.getRecurPeriod(),  "Recur Period interpretation error");
        assertEquals("1700", time.format(test.getTimeFrom()), "timeFrom interpretation error");
        assertEquals("1800",  time.format(test.getTimeTo()), "timeTo interpretation error");
    }

}
