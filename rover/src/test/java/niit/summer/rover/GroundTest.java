package niit.summer.rover;

import org.junit.Test;

import static niit.summer.rover.constants.CellState.*;
import static niit.summer.rover.constants.CellType.*;
import static org.junit.Assert.*;

public class GroundTest {

    @Test
    public void testInitializeSquareGround(){
        Ground ground = new Ground(2, 2);

        ground.initialize(
                new GroundCell(FREE, PLANE), new GroundCell(FREE, DOWNHILL),
                new GroundCell(OCCUPIED, PLANE), new GroundCell(FREE, UPHILL)
        );

        assertTrue("Cell (0,0) must be free and plane", FREE.equals(ground.getCell(0, 0).getState()) && PLANE.equals(ground.getCell(0, 0).getType()));
        assertTrue("Cell (1,0) must be free and downhill", FREE.equals(ground.getCell(1, 0).getState()) && DOWNHILL.equals(ground.getCell(1, 0).getType()));
        assertTrue("Cell (0,1) must be occupied and plane", OCCUPIED.equals(ground.getCell(0, 1).getState()) && PLANE.equals(ground.getCell(0, 1).getType()));
        assertTrue("Cell (1,1) must be free and uphill", FREE.equals(ground.getCell(1, 1).getState()) && UPHILL.equals(ground.getCell(1, 1).getType()));
    }

    @Test
    public void testInitializeOnExcessiveParametersCount(){
        Ground ground = new Ground(2, 2);

        ground.initialize(
                new GroundCell(FREE, PLANE), new GroundCell(FREE, DOWNHILL),
                new GroundCell(OCCUPIED, PLANE), new GroundCell(FREE, UPHILL),
                new GroundCell(FREE, PLANE)
        );

        assertTrue("Cell (0,0) must be free and plane", FREE.equals(ground.getCell(0, 0).getState()) && PLANE.equals(ground.getCell(0, 0).getType()));
        assertTrue("Cell (1,0) must be free and downhill", FREE.equals(ground.getCell(1, 0).getState()) && DOWNHILL.equals(ground.getCell(1, 0).getType()));
        assertTrue("Cell (0,1) must be occupied and plane", OCCUPIED.equals(ground.getCell(0, 1).getState()) && PLANE.equals(ground.getCell(0, 1).getType()));
        assertTrue("Cell (1,1) must be free and uphill", FREE.equals(ground.getCell(1, 1).getState()) && UPHILL.equals(ground.getCell(1, 1).getType()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitializeFailsOnInsufficientParameters() {
        Ground ground = new Ground(2, 2);

        ground.initialize(
                new GroundCell(FREE, PLANE), new GroundCell(FREE, DOWNHILL),
                new GroundCell(OCCUPIED, PLANE)
        );
    }
}