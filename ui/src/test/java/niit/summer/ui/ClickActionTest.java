package niit.summer.ui;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class ClickActionTest {

    @InjectMocks
    private ClickAction testedInstance;
    @Mock
    private GameController controller;
    @Mock
    private JPanel panel;
    private List<ImageButton> buttons = new ArrayList<ImageButton>(){{
        for (int i=0;i<11;i++){
            add(new ImageButton(mock(Image.class)));
        }
        add(new ImageButton());
    }};
    @Mock
    private ActionEvent actionEvent;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        testedInstance = new ClickAction(panel, buttons, controller);
    }


    @Test
    public void testActionPerformedCallsGameController() {
        when(actionEvent.getSource()).thenReturn(buttons.get(5));

        testedInstance.actionPerformed(actionEvent);

        verify(controller, only()).checkSolution(eq(buttons));
    }

    @Test
    public void testActionPerformedSwapsLeftAdjacentButtons() {
        when(actionEvent.getSource()).thenReturn(buttons.get(10));

        testedInstance.actionPerformed(actionEvent);

        assertTrue(buttons.get(10).isLastButton());
        assertFalse(buttons.get(11).isLastButton());
    }

    @Test
    public void testActionPerformedSwapsRightAdjacentButtons() {
        Collections.swap(buttons, 11, 10);
        when(actionEvent.getSource()).thenReturn(buttons.get(11));

        testedInstance.actionPerformed(actionEvent);

        assertTrue(buttons.get(11).isLastButton());
        assertFalse(buttons.get(10).isLastButton());
    }

    @Test
    public void testActionPerformedSwapsTopAdjacentButtons() {
        when(actionEvent.getSource()).thenReturn(buttons.get(8));

        testedInstance.actionPerformed(actionEvent);

        assertTrue(buttons.get(8).isLastButton());
        assertFalse(buttons.get(11).isLastButton());
    }

    @Test
    public void testActionPerformedSwapsBottomAdjacentButtons() {
        Collections.swap(buttons, 11, 8);

        when(actionEvent.getSource()).thenReturn(buttons.get(11));

        testedInstance.actionPerformed(actionEvent);

        assertTrue(buttons.get(11).isLastButton());
        assertFalse(buttons.get(8).isLastButton());
    }

    @Test
    public void testActionPerformedUpdatesPanelOnButtonsMove(){
        when(actionEvent.getSource()).thenReturn(buttons.get(10));

        testedInstance.actionPerformed(actionEvent);

        InOrder inOrder = inOrder(panel);
        inOrder.verify(panel).removeAll();
        inOrder.verify(panel).validate();
    }
}