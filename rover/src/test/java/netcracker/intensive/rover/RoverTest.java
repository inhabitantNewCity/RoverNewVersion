package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.Direction;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoverTest extends AbstractRoverTest {

    private Rover testedInstance = new Rover(new GroundVisor(GROUND_3x3));

    @Test
    public void testMoveToTheRightFreeCell() {
        testedInstance.turnTo(Direction.EAST);
        testedInstance.move();

        assertEquals(new Point(1, 0), testedInstance.getCurrentPosition());
    }

    @Test
    public void testMoveDownwardsToFreeCell() {
        testedInstance.move();

        assertEquals(new Point(0, 1), testedInstance.getCurrentPosition());
    }

    @Test
    public void testMoveToLeftFreeCell() {
        testedInstance.turnTo(Direction.EAST);
        testedInstance.move();
        testedInstance.turnTo(Direction.WEST);
        testedInstance.move();

        assertEquals(new Point(0,0), testedInstance.getCurrentPosition());
    }

    @Test
    public void testMoveUpwardsToFreeCell() {
        testedInstance.move();
        testedInstance.turnTo(Direction.NORTH);
        testedInstance.move();

        assertEquals(new Point(0,0), testedInstance.getCurrentPosition());
    }

    @Test
    public void testMoveToOccupiedCellWontSucceed() {
        testedInstance.turnTo(Direction.EAST);
        testedInstance.move();
        testedInstance.turnTo(Direction.SOUTH);
        testedInstance.move();

        assertEquals(new Point(1,0), testedInstance.getCurrentPosition());
    }

    @Test
    public void testMoveOutOfGroundMakesRoverLiftUp() {
        testedInstance.turnTo(Direction.NORTH);
        testedInstance.move();

        assertTrue(testedInstance.isAirborne());
    }

    @Test
    public void testAirborneRoverWontMove() {
        testedInstance.lift();
        Point oldPosition = testedInstance.getCurrentPosition();
        testedInstance.move();
        assertEquals(oldPosition, testedInstance.getCurrentPosition());
    }

    @Test
    public void testLiftedRoverIsAirborne() {
        testedInstance.lift();

        assertTrue(testedInstance.isAirborne());
    }

    @Test
    public void testAirborneRoverDoesntHavePosition() {
        testedInstance.lift();

        assertNull(testedInstance.getCurrentPosition());
    }

    @Test
    public void testAirborneRoverDoesntHaveDirection() {
        testedInstance.lift();

        assertNull(testedInstance.getDirection());
    }

    @Test
    public void testLand(){
        Point expectedPosition = new Point(2, 2);

        testedInstance.lift();
        testedInstance.land(expectedPosition, Direction.NORTH);

        assertEquals(expectedPosition, testedInstance.getCurrentPosition());
        assertEquals(Direction.NORTH, testedInstance.getDirection());
        assertFalse(testedInstance.isAirborne());
    }

    @Test
    public void testLandWontLandOutside(){
        testedInstance.lift();

        testedInstance.land(new Point(5, 6), Direction.EAST);

        assertTrue(testedInstance.isAirborne());
    }

    @Test
    public void testLandWontLandOnObstacle() {
        testedInstance.lift();

        testedInstance.land(new Point(1, 1), Direction.EAST);

        assertTrue(testedInstance.isAirborne());
    }

    @Test
    public void testTurnTo() {
        for (Direction direction : Direction.values()){
            testedInstance.turnTo(direction);
            assertEquals(direction, testedInstance.getDirection());
        }
    }
}