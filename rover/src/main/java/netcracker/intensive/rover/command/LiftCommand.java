package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.programmable.ProgrammableRover;

public class LiftCommand implements RoverCommand {
    private Rover rover;
    //private ProgrammableRover programmableRover;

    public LiftCommand(ProgrammableRover rover) {
        this.rover = rover;
    }

    public LiftCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        if(rover != null){
            rover.lift();
        }
        //if(programmableRover  != null){
          //  programmableRover.lift();
        //}
    }
}
