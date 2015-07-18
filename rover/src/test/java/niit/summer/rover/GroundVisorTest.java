package niit.summer.rover;

import org.junit.Test;

import static org.junit.Assert.*;

public class GroundVisorTest extends AbstractRoverTest {

    private GroundVisor testedInstance = new GroundVisor(SQUARE_GROUND);

    @Test
    public void testHasObstaclesReturnsTrueOnOccupiedCell() {
        assertTrue("Cell (0,1) must be occupied", testedInstance.hasObstacles(0, 1));
    }

    @Test
    public void testHasObstaclesReturnsFalseOnFreeCell() {
        assertFalse("Cell (0,0) must be free", testedInstance.hasObstacles(0, 0));
    }

    @Test
    public void testIsUphillReturnsTrueOnUphillCell() {
        assertTrue("Cell (1,1) must be uphill", testedInstance.isUphill(1, 1));
    }

    @Test
    public void testIsUphillReturnsFalseOnNonUphillCell() {
        assertFalse("Cell (0,0) must not be uphill", testedInstance.isUphill(0, 0));
    }

    @Test
    public void testIsDownhillReturnsTrueOnDownhillCell() {
        assertTrue("Cell (1,0) must be downhill", testedInstance.isDownhill(1, 0));
    }

    @Test
    public void testIsDownhillReturnsFalseOnNonDownhillCell() {
        assertFalse("Cell (0,0) must not be downhill", testedInstance.isDownhill(0, 0));
    }
}