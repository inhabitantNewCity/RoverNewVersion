package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.Direction;

public interface Landable {
    void land(Point position, Direction direction);
}
