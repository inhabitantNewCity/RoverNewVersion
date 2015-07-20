package niit.summer.rover.command;

import niit.summer.rover.Point;
import niit.summer.rover.constants.Direction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LandCommandTest extends AbstractCommandTest {

    private final static Point POSITION = new Point(2, 2);
    private final static Direction DIRECTION = Direction.EAST;

    @Before
    public void setUp() {
        super.setUp();
        testedInstance = new LandCommand(rover, POSITION, DIRECTION);
    }

    @Test
    public void testExecute() {
        testedInstance.execute();

        verify(rover, times(1)).land(eq(POSITION), eq(DIRECTION));
    }

    @Test
    public void testToString() {
        String expected = "Land at (2, 2) heading EAST";

        assertEquals(expected, testedInstance.toString());
    }

}