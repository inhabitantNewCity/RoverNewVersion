package niit.summer.rover.command;

import niit.summer.rover.AbstractRoverTest;
import niit.summer.rover.GroundVisor;
import niit.summer.rover.Rover;
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
        rover = new Rover(new GroundVisor(SQUARE_GROUND));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testToString() {
        assertEquals(expectedToString(), testedInstance.toString());
    }

    protected abstract String expectedToString();
}
