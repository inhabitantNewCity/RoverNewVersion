package niit.summer.ui;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameControllerTest {

    private GameController testedInstance;

    @Mock
    private JPanel panel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        testedInstance = new GameController(panel);
    }

    @Test
    public void testCheckSolutionClearsPanelOnSolvedPuzzle() {

        List<ImageButton> buttons = new ArrayList<ImageButton>() {{
            for (int i = 0; i < 12; i++) {
                    ImageButton button = new ImageButton(mock(Image.class));
                    button.putClientProperty("position", i);
                    add(button);
                }
        }};

        testedInstance.checkSolution(buttons);

        verify(panel).removeAll();
    }
}