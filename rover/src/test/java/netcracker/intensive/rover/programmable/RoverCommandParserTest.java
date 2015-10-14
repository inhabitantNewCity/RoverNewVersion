package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.AbstractRoverTest;
import netcracker.intensive.rover.GroundVisor;
import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.command.*;
import netcracker.intensive.rover.constants.Direction;
import netcracker.intensive.rover.stats.SimpleRoverStatsModule;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RoverCommandParserTest extends AbstractRoverTest {

    private ProgrammableRover rover = new ProgrammableRover(new GroundVisor(GROUND_3x3), new SimpleRoverStatsModule());
    private RoverCommandParser testedInstance;

    @Test
    public void testGetProgramReturnsProgramWithEmptySettingsOnEmptyFile() {
        String file = "empty.txt";
        testedInstance = new RoverCommandParser(rover, file);

        RoverProgram program = testedInstance.getProgram();

        assertEquals(0, program.getSettings().size());
    }

    @Test
    public void testGetProgramReturnsProgramWithEmptyCommandsOnEmptyFile() {
        String file = "empty.txt";
        testedInstance = new RoverCommandParser(rover, file);

        RoverProgram program = testedInstance.getProgram();

        assertEquals(0, program.getCommands().size());
    }

    @Test(expected = RoverCommandParserException.class)
    public void testGetProgramThrowsExceptionOnNonexistentFile() {
        String file = "nofile.txt";
        testedInstance = new RoverCommandParser(rover, file);

        testedInstance.getProgram();
    }

    @Test
    public void testGetProgramFillsSettings() {
        String file = "program.txt";
        testedInstance = new RoverCommandParser(rover, file);
        Map<String, Object> expectedSettings = new HashMap<String, Object>(){{
            put(RoverProgram.LOG, false);
            put(RoverProgram.STATS, true);
        }};

        RoverProgram program = testedInstance.getProgram();
        Map<String, Object> settings = program.getSettings();

        assertEquals(expectedSettings, settings);

    }

    @Test
    public void testGetProgramFillsCommands() {
        String file = "program.txt";
        testedInstance = new RoverCommandParser(rover, file);
        RoverCommand[] expectedCommands = new RoverCommand[]{new MoveCommand(rover), new MoveCommand(rover),
                new TurnCommand(rover, Direction.EAST), new MoveCommand(rover), new MoveCommand(rover),
                new LiftCommand(rover), new LandCommand(rover, new Point(2, 0), Direction.WEST),
                new MoveCommand(rover)
        };

        RoverProgram program = testedInstance.getProgram();
        Collection<RoverCommand> commands = program.getCommands();

        assertArrayEquals(expectedCommands, commands.toArray());
    }

    @Test
    public void testGetProgramReturnsLogWrappedCommandsOnLogSetting() {
        String file = "program_with_log.txt";
        testedInstance = new RoverCommandParser(rover, file);

        RoverProgram program = testedInstance.getProgram();
        RoverCommand command = program.getCommands().iterator().next();

        assertTrue(command instanceof LoggingCommand);
    }
}