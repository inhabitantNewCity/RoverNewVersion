package niit.summer.rover.programmable;

import niit.summer.rover.AbstractRoverTest;
import niit.summer.rover.GroundVisor;
import niit.summer.rover.Point;
import niit.summer.rover.stats.SimpleRoverStatsModule;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class ProgrammableRoverTest extends AbstractRoverTest {

    private ProgrammableRover testedInstance;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        testedInstance = new ProgrammableRover(new GroundVisor(GROUND_3x3), new SimpleRoverStatsModule());
    }

    @Test
    public void testExecuteProgramFile() {
        String file = "program.txt";

        testedInstance.executeProgramFile(file);

        assertEquals(new Point(1, 0), testedInstance.getCurrentPosition());
    }

    @Test
    public void testExecuteProgramFileFillsStatsSettings() {
        String file = "program_with_stats.txt";

        testedInstance.executeProgramFile(file);

        assertEquals(true, testedInstance.getSettings().get(RoverProgram.STATS));
    }

    @Test
    public void testExecuteProgramFileFillsLoggingSettings() {
        String file = "program_with_log.txt";

        testedInstance.executeProgramFile(file);

        assertEquals(true, testedInstance.getSettings().get(RoverProgram.LOG));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetSettingsReturnsImmutableObject() {
        String file = "program_with_log.txt";

        testedInstance.executeProgramFile(file);

        testedInstance.getSettings().put("test", "value");
    }
}