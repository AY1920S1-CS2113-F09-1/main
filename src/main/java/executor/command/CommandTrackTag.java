package executor.command;

import duke.exception.DukeException;
import interpreter.Parser;
import storage.StorageManager;
import ui.UiCode;

public class CommandTrackTag extends Command {
    private String inputStr;

    /**
     * Constructor for CommandTrack Class.
     */
    public CommandTrackTag(String userInput) {
        super();
        this.commandType = CommandType.TRACK;
        this.userInput = userInput;
        this.inputStr = Parser.parseForPrimaryInput(this.commandType, userInput);
        this.description = "Track how much you spend based on a tag! \n"
                + "FORMAT : TRACK <tag>";
    }

    @Override
    public void execute(StorageManager storageManager) {
        for (String tag : this.inputStr.split(" ")) {
            try {
                storageManager.trackTag(tag);
            } catch (DukeException e) {
                this.infoCapsule.setUiCode(UiCode.ERROR);
                this.infoCapsule.setOutputStr(e.getMessage()
                        + "\nIf you wish to untrack this tag, try UNTRACK <tag>.");
                return;
            }
        }
        this.infoCapsule.setUiCode(UiCode.TOAST);
        this.infoCapsule.setOutputStr("Tracking tags: " + this.inputStr);
    }
}
