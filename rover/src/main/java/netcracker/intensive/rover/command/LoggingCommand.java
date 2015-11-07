package netcracker.intensive.rover.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingCommand implements RoverCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingCommand.class);

    public LoggingCommand(MoveCommand moveCommand) {
        //LOGGER.info(moveCommand.toString());
    }

    @Override
    public void execute() {

    }
    public boolean equals(Object ob){
        if(ob.getClass().getName() == "netcracker.intensive.rover.command.LoggingCommand")
            return true;
        return false;
    }
}
