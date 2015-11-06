package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.programmable.ProgrammableRover;

public class MoveCommand implements RoverCommand {
    private Rover rover;
   // private ProgrammableRover programmableRover;
    public MoveCommand(ProgrammableRover rover) {
        this.rover = rover;
    }

    public MoveCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        if(rover != null){
            rover.move();
        }
     //   if(programmableRover  != null){
       //     programmableRover.move();
        //}
    }
}
