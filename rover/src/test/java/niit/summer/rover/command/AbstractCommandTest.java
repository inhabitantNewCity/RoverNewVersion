package niit.summer.rover.command;

import niit.summer.rover.AbstractRoverTest;
import niit.summer.rover.GroundVisor;
import niit.summer.rover.Rover;
import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public abstract class AbstractCommandTest extends AbstractRoverTest {

    @Spy
    protected Rover rover;
    protected RoverCommand testedInstance;

    @Before
    public void setUp(){
        rover = new Rover(new GroundVisor(SQUARE_GROUND));
        MockitoAnnotations.initMocks(this);
    }
}
