package netcracker.intensive.rover.command;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.slf4j.LoggerFactory;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LoggingCommandTest extends AbstractCommandTest {

    @Mock
    private Appender appender;
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(LoggingCommand.class);

    @Before
    public void setUp() {
        super.setUp();
        testedInstance = new LoggingCommand(new MoveCommand(rover));
        LOGGER.addAppender(appender);
    }

    @Override
    protected String expectedToString() {
        return "Rover moved";
    }

    @Test
    public void testExecuteCallsDelegateCommand() {
        testedInstance.execute();

        verify(rover, times(1)).move();
    }

    @Test
    public void testExecuteWriteLogs() {
        testedInstance.execute();

        verify(appender, times(1)).doAppend(any(LoggingEvent.class));
    }

    @After
    public void tearDown() {
        LOGGER.detachAppender(appender);
    }
}