package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.constants.Direction;
import netcracker.intensive.rover.programmable.ProgrammableRover;

public class TurnCommand implements RoverCommand {
    private Rover rover;
    //private ProgrammableRover programmableRover;
    //private Point point;
    private Direction direction;
    public TurnCommand(ProgrammableRover rover, Direction east) {
        this.rover = rover;
        direction = east;
    }

    public TurnCommand(Rover rover, Direction direction) {
        this.rover = rover;
        this.direction = direction;
    }

    @Override
    public void execute() {
        if(rover != null){
            rover.turnTo(direction);
        }
       // if(programmableRover  != null){
         //   programmableRover.turnTo(direction);
        //}
    }
}
