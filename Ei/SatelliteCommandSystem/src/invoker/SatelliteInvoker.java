package invoker;

import java.util.ArrayList;
import java.util.List;

import commands.Command;
import logging.Logger;

public class SatelliteInvoker {
    private List<Command> commandHistory = new ArrayList<>();

    public void executeCommand(Command command) {
        try {
            command.execute();
            commandHistory.add(command);
        } catch (Exception e) {
            Logger.log("Command execution failed: " + e.getMessage());
        }
    }
}
