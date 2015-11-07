package netcracker.intensive.rover.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingCommand implements RoverCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingCommand.class);
    private MoveCommand move;
    public LoggingCommand(MoveCommand moveCommand) {
        move = moveCommand;
        //LOGGER.info(moveCommand.toString());
    }
    public String toString(){
        return "Rover moved";
    }
    @Override
    public void execute() {
        LOGGER.debug("move");
        move.execute();
    }
    public void move(){
        move.execute();
    }
    public boolean equals(Object ob){
        if(ob.getClass().getName() == "netcracker.intensive.rover.command.LoggingCommand")
            return true;
        return false;
    }
}
