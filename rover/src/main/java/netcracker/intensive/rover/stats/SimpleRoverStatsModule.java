package netcracker.intensive.rover.stats;

import netcracker.intensive.rover.Point;

import java.util.ArrayList;
import java.util.Collection;

public class SimpleRoverStatsModule implements RoverStatsModule {

    private ArrayList<Point> visitedPoints = new ArrayList<>();
    @Override
    public void registerPosition(Point position) {
        for (int i = 0; i <visitedPoints.size() ; i++) {
            if(position.equals(visitedPoints.get(i)))
                return;
        }
            visitedPoints.add(position);
    }

    @Override
    public boolean isVisited(Point point) {
        //boolean visited = false;
        for (int i = 0; i <visitedPoints.size() ; i++) {
            if(point.equals(visitedPoints.get(i)))
                return true;
        }
        return false;
    }

    @Override
    public Collection<Point> getVisitedPoints() {
        return visitedPoints;
    }
}
