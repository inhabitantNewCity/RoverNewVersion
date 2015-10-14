package netcracker.intensive.rover.command;

import netcracker.intensive.rover.constants.Direction;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TurnCommandTest extends AbstractCommandTest {

    private final static Direction direction = Direction.EAST;

    @Before
    public void setUp() {
        super.setUp();
        testedInstance = new TurnCommand(rover, direction);
    }

    @Override
    protected String expectedToString() {
        return "Heading EAST";
    }

    @Test
    public void testExecute() throws Exception {
        testedInstance.execute();

        verify(rover, times(1)).turnTo(eq(direction));
    }
}