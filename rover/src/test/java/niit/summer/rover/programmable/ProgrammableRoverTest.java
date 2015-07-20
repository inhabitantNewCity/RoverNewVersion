package niit.summer.rover.programmable;

import niit.summer.rover.AbstractRoverTest;
import niit.summer.rover.GroundVisor;
import niit.summer.rover.Point;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProgrammableRoverTest extends AbstractRoverTest {

    private ProgrammableRover testedInstance = new ProgrammableRover(new GroundVisor(GROUND_3x3));

    @Test
    public void testExecuteProgramFile() {
        String file = "program.txt";

        testedInstance.executeProgramFile(file);

        assertEquals(new Point(0,0), testedInstance.getCurrentPosition());
    }
}