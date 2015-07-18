package niit.summer.rover;

import static niit.summer.rover.constants.CellState.*;
import static niit.summer.rover.constants.CellType.*;
import static org.junit.Assert.assertTrue;

public abstract class AbstractRoverTest {

    /**
     * 0 - пустая ровная клетка
     * 1 - занятая клетка
     * \ - пустая клетка с уклоном вниз
     * / - пустая клетка с уклоном вверх
     *
     * Тестовый полигон имеет вид:
     *
     * |0,\|
     * |1,/|
     */
    protected static final Ground SQUARE_GROUND = new Ground(2, 2);

    static {
        SQUARE_GROUND.initialize(new GroundCell(FREE, PLANE), new GroundCell(FREE, DOWNHILL),
                new GroundCell(OCCUPIED, PLANE), new GroundCell(FREE, UPHILL));
    }

    protected void assertSquareGround(Ground ground) {
        assertTrue("Cell (0,0) must be free and plane", FREE.equals(ground.getCell(0, 0).getState()) && PLANE.equals(ground.getCell(0, 0).getType()));
        assertTrue("Cell (1,0) must be free and downhill", FREE.equals(ground.getCell(1, 0).getState()) && DOWNHILL.equals(ground.getCell(1, 0).getType()));
        assertTrue("Cell (0,1) must be occupied and plane", OCCUPIED.equals(ground.getCell(0, 1).getState()) && PLANE.equals(ground.getCell(0, 1).getType()));
        assertTrue("Cell (1,1) must be free and uphill", FREE.equals(ground.getCell(1, 1).getState()) && UPHILL.equals(ground.getCell(1, 1).getType()));
    }
}
