package netcracker.intensive.rover.command;

import netcracker.intensive.rover.AbstractRoverTest;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MoveCommandTest extends AbstractCommandTest {

    @Override
    @Before
    public void setUp(){
        super.setUp();
        testedInstance = new MoveCommand(rover);
    }

    @Override
    protected String expectedToString() {
        return "Rover moved";
    }

    @Test
    public void testExecute() throws Exception {
        testedInstance.execute();
        verify(rover, times(1)).move();
    }
}