package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;

/**
 * Created by Владислав on 07.10.2015.
 */
public class GroundCell {

    private Point point;
    private CellState state;
    private boolean visited = false;

    GroundCell(CellState cellState){
        //this.point = point;
        state = cellState;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Point getPoint(){
        return point;
    }
    public void setState(CellState free){
        this.state = free;
    }
    public CellState getState(){
        return state;
    }
    public boolean isYou(Point point){
        Point tmp = this.getPoint();
        if((tmp.getX() == this.point.getX()) && (tmp.getY() == this.point.getY()))
            return true;
        return false;
    }
    public String toString(){
        return "x = " + point.getX() + " y = " + point.getY() + " free = " + state + " visited = " + visited;
    }

}

