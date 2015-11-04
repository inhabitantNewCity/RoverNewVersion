package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;

public class GroundVisor {
    private Ground ground;

    public GroundVisor(Ground ground) {
        this.ground = ground;
    }

    public boolean checkCell(Point point) throws OutOfGroundException {
        GroundCell tmp = ground.getCell(point.getX(),point.getY());
        if (tmp.getPoint().getX() == -1)
            throw new OutOfGroundException();
        if (tmp.getState() == CellState.FREE)
            return true;
        return false;
    }

    public boolean hasObstacles(Point point) {
        return false;
    }
}

