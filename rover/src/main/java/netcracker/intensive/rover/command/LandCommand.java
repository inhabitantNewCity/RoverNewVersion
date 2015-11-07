package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.constants.Direction;
import netcracker.intensive.rover.programmable.ProgrammableRover;

public class LandCommand implements RoverCommand {

    private Rover rover;
    //private ProgrammableRover programmableRover;
    private Point point;
    private Direction direction;

    public LandCommand(ProgrammableRover rover, Point point, Direction west) {
        this.direction = west;
        this.point = point;
        this.rover = rover;
    }

    public boolean equals(Object ob){
        if(ob.getClass().getName() == "netcracker.intensive.rover.command.LandCommand")
            return true;
        return false;
    }

    public LandCommand(Rover rover, Point position, Direction direction) {
        this.direction = direction;
        this.point = position;
        this.rover = rover;
    }


    @Override
    public void execute() {
        if(rover != null){
            rover.land(point,direction);
            System.out.println("");
        }
       // if(programmableRover  != null){
         //   programmableRover.land(point,direction);
        //}
    }
    public String toString(){
        return "Land at ("+ point.getX()+", "+point.getY() +") heading " + direction.toString();
    }
}
