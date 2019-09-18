package duke.task;

import duke.exception.DukeException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Deadline extends Task {
    private Date datetime;

    // Initialization
    Deadline(String name) {
        super(name);
        this.taskType = TaskType.DEADLINE;
        this.recordTaskDetails(name);
        try {
            this.parseDateTime();
            DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy HHmm");
            String strDate = dateFormat.format(getDatetime());
            this.setDates(strDate);
        } catch  (DukeException invalidInput) {
            invalidInput.printStackTrace();
        }

    }

    private void parseDateTime() throws DukeException {
        SimpleDateFormat formatx = new SimpleDateFormat("dd/mm/yyyy HHmm");
        if (this.detailDesc == null) {
            return;
        }
        if (this.detailDesc.equals("by")) {
            try {
                this.datetime = formatx.parse(this.taskDetails);
                System.out.println("Date Interpreted: " + formatx.format(this.datetime));
            } catch (Exception e) {
                //System.out.println("Invalid Input. Unable to interpret Datetime (use: dd/mm/yyyy HHmm)");
                this.datetime = new Date();
                throw new DukeException("Invalid Input. Unable to interpret Datetime (use: dd/mm/yyyy HHmm)");
            }
        }
    }

    // -- Setters & Getters

    /**
     * Getter for datetime.
     * @return Datetime stored in this Deadline Object
     */
    public Date getDatetime() {
        return datetime;
    }




}
