package netcracker.intensive.rover.command;

import netcracker.intensive.rover.AbstractRoverTest;
import netcracker.intensive.rover.GroundVisor;
import netcracker.intensive.rover.Rover;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;

public abstract class AbstractCommandTest extends AbstractRoverTest {

    @Spy
    protected Rover rover;
    protected RoverCommand testedInstance;

    @Before
    public void setUp(){
        rover = new Rover(new GroundVisor(GROUND_2x2));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testToString() {
        assertEquals(expectedToString(), testedInstance.toString());
    }

    protected abstract String expectedToString();
}
