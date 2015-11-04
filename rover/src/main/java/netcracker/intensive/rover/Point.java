package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;

public class Point {
    //не забудьте реализовать equals, hashCode, toString!
    int x;
    int y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public  int getY(){
        return y;
    }
    public String toString(){
        return "x = " + x + " y = "+ y;
    }
    public int hashCode(){
        return Integer.parseInt("" + x + y);
    }
    public boolean equals(Object p){
        if(this.hashCode() == p.hashCode())
            return true;
        return false;
    }
}
