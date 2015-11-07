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

    public boolean equals(Object ob){
        if(ob.getClass().getName() == "netcracker.intensive.rover.command.TurnCommand")
            return true;
        return false;
    }
    public String toString(){
        return "Heading " + direction.toString();
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
