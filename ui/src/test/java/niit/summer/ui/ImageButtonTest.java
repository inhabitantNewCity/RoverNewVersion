package niit.summer.ui;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class ImageButtonTest {

    private ImageButton testedInstance;
    @Mock
    private Image image;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testImageButtonIsSubclassOfJButton(){
        testedInstance = new ImageButton();

        assertTrue("ImageButton must be a subclass of JButton", testedInstance instanceof JButton);
    }

    @Test
    public void testParameterlessConstructorSetsLastButton() {
        testedInstance = new ImageButton();

        assertTrue(testedInstance.isLastButton());
    }

    @Test
    public void testConstructorSetsIconProperty(){
        testedInstance = new ImageButton(image);

        assertEquals(image, ((ImageIcon) testedInstance.getIcon()).getImage());
    }

    @Test
    public void testConstructorAddsMouseListener(){
        testedInstance = new ImageButton(image);

        assertEquals(2, testedInstance.getMouseListeners().length);
    }

    @Test
    public void testMouseListenerChangesLineBorderColorToYellowOnMouseEnter() {
        testedInstance = new ImageButton(image);

        MouseListener mouseListener = testedInstance.getMouseListeners()[1];
        mouseListener.mouseEntered(mock(MouseEvent.class));

        LineBorder border = (LineBorder) testedInstance.getBorder();
        assertEquals(Color.yellow, border.getLineColor());
    }

    @Test
    public void testMouseListenerChangesLineBorderColorToGrayOnMouseExit() {
        testedInstance = new ImageButton(image);

        MouseListener mouseListener = testedInstance.getMouseListeners()[1];
        mouseListener.mouseExited(mock(MouseEvent.class));

        LineBorder border = (LineBorder) testedInstance.getBorder();
        assertEquals(Color.gray, border.getLineColor());
    }

}