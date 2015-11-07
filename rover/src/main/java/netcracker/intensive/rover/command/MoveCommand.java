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
        //rover.e
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
    public String toString(){
        return "Rover moved";
    }
    public boolean equals(Object ob){
        if(ob.getClass().getName() == "netcracker.intensive.rover.command.MoveCommand")
            return true;
        return false;
    }
}
