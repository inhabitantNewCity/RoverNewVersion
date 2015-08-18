package niit.summer.ui;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

public class UIFormTest {

    @InjectMocks
    private UIForm testedInstance;

    @Spy
    private ImageProcessor processor;
    @Spy
    private ButtonsFactory buttonsFactory;

    @Before
    public void setUp() {
        testedInstance = new UIForm();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUIFormIsSubclassOfJFrame() {
        assertTrue(testedInstance instanceof JFrame);
    }

    @Test
    public void testInitUISetsGridLayoutToPanel() {
        testedInstance.initUI();

        assertEquals(new GridLayout(4, 3, 0, 0).toString(), testedInstance.getPanel().getLayout().toString());
    }

    @Test
    public void testInitUICallsImageProcessor() {
        testedInstance.initUI();

        verify(processor).cutImage(eq(UIForm.class.getClassLoader().getResource("niit/summer/ui/duke.png")), eq(UIForm.ROWS), eq(UIForm.COLS));
    }

    @Test
    public void testInitUIAddsButtons() {
        testedInstance.initUI();

        assertEquals(12, testedInstance.getPanel().getComponentCount());
    }

    @Test
    public void testInitUIShufflesButtons() {
        testedInstance.initUI();

        Component[] components = testedInstance.getPanel().getComponents();
        boolean ordered = true;
        int previous = 0;
        for (Component component : components) {
            Integer position = (Integer) ((ImageButton) component).getClientProperty("position");
            ordered = ordered && previous <= position;
            previous = position;
        }
        assertFalse(ordered);
    }

    @Test
    public void testInitUIAddsLastButton() {
        testedInstance.initUI();

        Component[] components = testedInstance.getPanel().getComponents();
        ImageButton lastButton = (ImageButton)components[components.length-1];

        assertTrue(lastButton.isLastButton());
    }

    @Test
    public void testInitUIAddsButtonPanel(){
        testedInstance.initUI();

        assertEquals(testedInstance, testedInstance.getPanel().getParent().getParent().getParent().getParent());
    }

    @Test
    public void testInitUISetsTitleToPuzzle() {
        testedInstance.initUI();

        assertEquals("Puzzle", testedInstance.getTitle());
    }

    @Test
    public void testInitUISetsResizableToFalse() {
        testedInstance.initUI();

        assertFalse(testedInstance.isResizable());
    }

    @Test
    public void testInitUISetsDefaultCloseOperation() {
        testedInstance.initUI();

        assertEquals(WindowConstants.EXIT_ON_CLOSE, testedInstance.getDefaultCloseOperation());
    }

    @Test
    public void testInitUISetsVisibleToTrue() {
        testedInstance.initUI();

        assertTrue(testedInstance.isVisible());
    }
}