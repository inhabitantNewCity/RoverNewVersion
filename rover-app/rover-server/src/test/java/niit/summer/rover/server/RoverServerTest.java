package niit.summer.rover.server;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.junit.Assert.*;

public class RoverServerTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void testMainCallsSystemExitOnInsufficientArguments() {
        exit.expectSystemExit();

        RoverServer.main(new String[]{});
    }


}