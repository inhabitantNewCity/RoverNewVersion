package netcracker.intensive.rover.stats;

import netcracker.intensive.rover.Point;

import java.util.Collection;

public class SimpleRoverStatsModule implements RoverStatsModule {

    @Override
    public void registerPosition(Point position) {

    }

    @Override
    public boolean isVisited(Point point) {
        return false;
    }

    @Override
    public Collection<Point> getVisitedPoints() {
        return null;
    }
}
