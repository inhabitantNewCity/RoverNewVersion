package niit.summer.rover;

import org.junit.Test;

import static niit.summer.rover.constants.CellState.FREE;
import static niit.summer.rover.constants.CellState.OCCUPIED;
import static niit.summer.rover.constants.CellType.*;

public class GroundTest extends AbstractRoverTest {

    @Test
    public void testInitializeSquareGround(){
        assertSquareGround(SQUARE_GROUND);
    }

    @Test
    public void testInitializeOnExcessiveParametersCount(){
        Ground ground = new Ground(2, 2);

        ground.initialize(
                new GroundCell(FREE, PLANE), new GroundCell(FREE, DOWNHILL),
                new GroundCell(OCCUPIED, PLANE), new GroundCell(FREE, UPHILL),
                new GroundCell(FREE, PLANE)
        );

        assertSquareGround(ground);
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