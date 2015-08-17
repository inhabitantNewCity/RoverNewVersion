package niit.summer.ui;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ButtonsFactoryTest {

    private ButtonsFactory testedInstance = new ButtonsFactory();

    @Mock
    private Image mockImage;
    @Mock
    private ActionListener actionListener;

    private int position = 0;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateImageButtonSetsImage() {
        ImageButton result = testedInstance.createImageButton(mockImage, position, actionListener);

        assertEquals(mockImage, ((ImageIcon)result.getIcon()).getImage());
    }

    @Test
    public void testCreateImageButtonSetsPosition() {
        ImageButton result = testedInstance.createImageButton(mockImage, position, actionListener);

        assertEquals(position, result.getClientProperty("position"));
    }

    @Test
    public void testCreateImageButtonSetsActionListener() {
        ImageButton result = testedInstance.createImageButton(mockImage, position, actionListener);

        assertEquals(1, result.getActionListeners().length);
    }

    @Test
    public void testCreateImageButtonSetsGivenActionListener() {
        ImageButton result = testedInstance.createImageButton(mockImage, position, actionListener);

        assertEquals(actionListener, result.getActionListeners()[0]);
    }

    @Test
    public void testCreateLastButtonSetsPosition() {
        ImageButton result = testedInstance.createLastButton(position);

        assertEquals(position, result.getClientProperty("position"));
    }

    @Test
    public void testCreateLastButtonSetsInvisibleBorder() {
        ImageButton result = testedInstance.createLastButton(position);

        assertFalse(result.isBorderPainted());
    }

    @Test
    public void testCreateLastButtonSetsUnfilledArea() {
        ImageButton result = testedInstance.createLastButton(position);

        assertFalse(result.isContentAreaFilled());
    }
}