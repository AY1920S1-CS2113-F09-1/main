package duke.task;

import duke.exception.DukeException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

public class Recur extends Task
{
    private String recurPeriod;
    private Date timeFrom;
    private Date timeTo;
    /**
     * Constructor for the 'Task' Class.
     *
     * @param name Name of the task as inputted by the user
     */
    public Recur(String name) {
        super(name);
        this.taskType = TaskType.RECUR;
        this.recordTaskDetails(name);
        try
        {
            this.recurDetails();
        } catch (DukeException noRecurDetail)
        {
            noRecurDetail.printStackTrace();
        }
    }

    private void recurDetails() throws DukeException{
        String[] descriptionTokens;
        SimpleDateFormat formatx = new SimpleDateFormat("HHmm");
        if(this.detailDesc == null)
        {
            return;
        }

        descriptionTokens = taskDetails.split("/");
        if(this.detailDesc.equals("for"))
        {
            try {
                switch(descriptionTokens.length)
                {
                    case 1:
                        this.recurPeriod = descriptionTokens[0];
                        break;
                    case 2:
                        this.recurPeriod = descriptionTokens[0];
                        this.timeFrom = formatx.parse(descriptionTokens[1]);
                        break;
                    case 3:
                        this.recurPeriod = descriptionTokens[0];
                        this.timeFrom = formatx.parse(descriptionTokens[1]);
                        this.timeTo = formatx.parse(descriptionTokens[2]);
                        break;
                    default:
                        return;
                }

            } catch (Exception e)
            {
                this.timeFrom = new Date();
                this.timeTo = new Date();
                throw new DukeException("Invalid Input. Unable to interpret Time (use: HHmm)");
            }
        }
    }
    // format1: Recur [ex.meeting] /for [daily/weekly/monthly]
    // format2: Recur [ex.meeting] /for [daily/weekly/monthly] / [timefrom] / [timeto]
    // format3: Recur [ex.meeting] /for [daily/weekly/monthly] / [time]


    public String getRecurPeriod()
    {
        return recurPeriod;
    }
    public Date getTimeFrom() {
        return timeFrom;
    }
    public Date getTimeTo()
    {
        return timeTo;
    }
}
