package netcracker.intensive.rover;

import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.stats.RoverStatsModule;
import netcracker.intensive.rover.stats.SimpleRoverStatsModule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleRoverStatsModuleTest {
    
    private RoverStatsModule testedInstance = new SimpleRoverStatsModule();

    @Test
    public void testRegisterPositionAddsNewPoint() {
        Point point = new Point(0, 0);
        
        testedInstance.registerPosition(point);
        
        assertEquals(testedInstance.getVisitedPoints().size(), 1);
    }

    @Test
    public void testRegisterPositionSkipsExistingPoint() {
        Point point = new Point(0, 0);

        testedInstance.registerPosition(point);
        testedInstance.registerPosition(point);

        assertEquals(testedInstance.getVisitedPoints().size(), 1);
    }

    @Test
    public void testIsVisitedReturnsTrueOnVisitedPosition() {
        Point point = new Point(0, 0);
        testedInstance.registerPosition(point);

        boolean visited = testedInstance.isVisited(point);

        assertTrue(visited);
    }
    
    @Test
    public void testIsVisitedReturnsFalseOnNonVisitedPosition() {
        Point point = new Point(0, 0);
        testedInstance.registerPosition(point);

        boolean visited = testedInstance.isVisited(new Point(1, 1));

        assertFalse(visited);
    }

    @Test
    public void testGetVisitedPoints() {
        Point point = new Point(0, 0);

        testedInstance.registerPosition(point);

        assertArrayEquals(testedInstance.getVisitedPoints().toArray(), new Point[]{point});
    }
}