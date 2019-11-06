package interpreter;

import executor.command.CommandType;
import executor.command.Executor;
import utils.InfoCapsule;

public class Interpreter {
    private Executor executorLayer;

    public Interpreter(String taskPath, String walletPath) {
        this.executorLayer = new Executor(taskPath, walletPath);
    }

    /**
     * Interprets the userInput relative to the TaskList provided and executes the Command.
     * @param userInput The userInput taken from the User Interface
     * @return InfoCapsule containing the execution results of the Command
     */
    public InfoCapsule interpret(String userInput) {
        CommandType commandType = Parser.parseForCommandType(userInput);
        return this.executorLayer.runCommand(commandType, userInput);
    }

    public void requestSave() {
        this.executorLayer.saveAllData();
    }
}
