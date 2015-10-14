package netcracker.intensive.rover;

import static netcracker.intensive.rover.constants.CellState.*;
import static org.junit.Assert.assertTrue;

public abstract class AbstractRoverTest {

    /**
     * 0 - пустая ровная клетка
     * 1 - занятая клетка
     *
     * Тестовый полигон имеет вид:
     *
     * |0,0|
     * |1,1|
     */
    protected static final Ground GROUND_2x2 = new Ground(2, 2){{
        initialize(new GroundCell(FREE), new GroundCell(FREE),
                new GroundCell(OCCUPIED), new GroundCell(OCCUPIED));
    }};

    protected static final Ground GROUND_3x3 = new Ground(3, 3){{
        initialize(new GroundCell(FREE), new GroundCell(FREE), new GroundCell(FREE),
                new GroundCell(FREE), new GroundCell(OCCUPIED), new GroundCell(FREE),
                new GroundCell(FREE), new GroundCell(FREE), new GroundCell(FREE));
    }};

    protected void assertSquareGround(Ground ground) throws OutOfGroundException {
        assertTrue("Cell (0,0) must be free", FREE.equals(ground.getCell(0, 0).getState()));
        assertTrue("Cell (1,0) must be free", FREE.equals(ground.getCell(1, 0).getState()));
        assertTrue("Cell (0,1) must be occupied", OCCUPIED.equals(ground.getCell(0, 1).getState()));
        assertTrue("Cell (1,1) must be occupied", OCCUPIED.equals(ground.getCell(1, 1).getState()));
    }
}
