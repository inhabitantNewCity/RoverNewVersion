package niit.summer.complex;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexNumberTest {

    @Test
    public void testDummy() {
        assertTrue("The truth is out there", false);
    }

    @Test
    public void testEqualsReturnsFalseOnDifferentTypes() {
        ComplexNumber z = new ComplexNumber(1, 0);
        Object o = new Object();

        assertFalse(z.equals(o));
    }

    @Test
    public void testEqualsReturnsTrueOnSameObject() {
        ComplexNumber z = new ComplexNumber(1, 0);

        assertTrue(z.equals(z));
    }

    @Test
    public void testHashCodeReturnsSameValueOnEqualObjects() {
        ComplexNumber z1 = new ComplexNumber(1.0, 2.0);
        ComplexNumber z2 = new ComplexNumber(1.0, 2.0);

        assertEquals(z1.hashCode(), z2.hashCode());
    }

    @Test
    public void testHashCodeReturnsDifferentValueOnInequalObjects() {
        ComplexNumber z1 = new ComplexNumber(1.0, 2.0);
        ComplexNumber z2 = new ComplexNumber(1.0, 1.0);

        assertNotEquals(z1.hashCode(), z2.hashCode());
    }

    @Test
    public void testEqualsReturnsTrueOnSameValues() {
        ComplexNumber z1 = new ComplexNumber(1.0, 2.0);
        ComplexNumber z2 = new ComplexNumber(1.0, 2.0);

        assertTrue(z1.equals(z2));
    }

    @Test
    public void testAddReturnsSum() {
        ComplexNumber z1 = new ComplexNumber(1.0, 2.0);
        ComplexNumber z2 = new ComplexNumber(2.0, 3.5);

        ComplexNumber result = z1.add(z2);

        assertEquals("Result must be 3 + 5.5i", new ComplexNumber(3.0, 5.5), result);
    }

    @Test
    public void testMultiplyReturnsProduct() {
        ComplexNumber z1 = new ComplexNumber(1.0, 2.0);
        ComplexNumber z2 = new ComplexNumber(2.0, 3.5);

        ComplexNumber result = z1.multiply(z2);

        assertEquals("Result must be -5 + 7.5i", new ComplexNumber(-5, 7.5), result);
    }

    @Test
    public void testAbsReturnsAbsoluteValue() {
        ComplexNumber z = new ComplexNumber(3.0, 4.0);

        double abs = z.abs();

        assertEquals("Absolute value of 3 + 4i must be 5", 5.0, abs, 0.001);
    }

    @Test
    public void testArgReturnsNaNForZero() {
        ComplexNumber z = ComplexNumber.ZERO;

        assertEquals("Argument of zero is not defined", Double.NaN, z.arg(), 0.0);
    }

    @Test
    public void testArgReturnsHalfPiOnPositiveImaginaryNumber() {
        ComplexNumber z = new ComplexNumber(0, 1);

        assertEquals("Argument of positive pure imaginary number must be pi/2", Math.PI / 2, z.arg(), 0.001);
    }

    @Test
    public void testArgReturnsMinusHalfPiOnNegativeImaginaryNumber() {
        ComplexNumber z = new ComplexNumber(0, -1);

        assertEquals("Argument of negative pure imaginary number must be -pi/2", -Math.PI / 2, z.arg(), 0.001);
    }

    @Test
    public void testArgReturnsArgumentForFirstQuadrant() {
        ComplexNumber z = new ComplexNumber(1, 1);

        double result = z.arg();

        assertEquals("Argument of 1 + 1i must be pi/4", Math.PI / 4, result, 0.001);
    }

    @Test
    public void testArgReturnsArgumentForSecondQuadrant() {
        ComplexNumber z = new ComplexNumber(-1, 1);

        double result = z.arg();

        assertEquals("Argument of 1 + 1i must be 3pi/4", 3 * Math.PI / 4, result, 0.001);
    }

    @Test
    public void testArgReturnsArgumentForThirdQuadrant() {
        ComplexNumber z = new ComplexNumber(-1, -1);

        double result = z.arg();

        assertEquals("Argument of 1 + 1i must be -3pi/4", -3 * Math.PI / 4, result, 0.001);
    }

    @Test
    public void testArgReturnsArgumentForFourthQuadrant() {
        ComplexNumber z = new ComplexNumber(1, -1);

        double result = z.arg();

        assertEquals("Argument of 1 + 1i must be -pi/4", -Math.PI / 4, result, 0.001);
    }

    @Test
    public void testAlgebraicRepresentationForNumberWithRealAndImaginaryParts() {
        ComplexNumber z = new ComplexNumber(2, 3);

        AlgebraicRepresentation result = z.asAlgebraic();

        assertEquals("Real part must be 2", 2, result.getReal(), 0.001);
        assertEquals("Imaginary part must be 3", 3, result.getImaginary(), 0.001);
        assertEquals("2 + 3i", result.toString());
    }

    @Test
    public void testAlgebraicRepresentationForNumberWithOnlyRealPart() {
        ComplexNumber z = new ComplexNumber(2, 0);

        AlgebraicRepresentation result = z.asAlgebraic();

        assertEquals("Real part must be 2", 2, result.getReal(), 0.001);
        assertEquals("Imaginary part must be 0", 0, result.getImaginary(), 0.001);
        assertEquals("2", result.toString());
    }

    @Test
    public void testAlgebraicRepresentationForNumberWithOnlyImaginaryPart() {
        ComplexNumber z = new ComplexNumber(0, 2);

        AlgebraicRepresentation result = z.asAlgebraic();

        assertEquals("Real part must be 0", 0, result.getReal(), 0.001);
        assertEquals("Imaginary part must be 2", 2, result.getImaginary(), 0.001);
        assertEquals("2i", result.toString());
    }

    @Test
    public void testAlgebraicRepresentationReturns0ForZero() {
        ComplexNumber z = ComplexNumber.ZERO;

        AlgebraicRepresentation result = z.asAlgebraic();

        assertEquals("0", result.toString());
    }

    @Test
    public void testTrigonometricRepresentationForNumberWithRealAndImaginaryParts() {
        ComplexNumber z = new ComplexNumber(1, 1);

        TrigonometricRepresentation result = z.asTrigonometric();

        assertEquals("Absolute value must be sqrt(2)", Math.sqrt(2), result.getAbsoluteValue(), 0.001);
        assertEquals("Argument must be pi/4", Math.PI / 4, result.getArgument(), 0.001);
        assertEquals("1,414(cos45°+i*sin45°)", result.toString());
    }

    @Test
    public void testTrigonometricRepresentationForNumberWithOnlyRealPart() {
        ComplexNumber z = new ComplexNumber(1, 0);

        TrigonometricRepresentation result = z.asTrigonometric();

        assertEquals("Absolute value must be 1", 1, result.getAbsoluteValue(), 0.001);
        assertEquals("Argument must be 0", 0, result.getArgument(), 0.001);
        assertEquals("1", result.toString());
    }

    @Test
    public void testTrigonometricRepresentationForNumberWithOnlyImaginaryPart() {
        ComplexNumber z = new ComplexNumber(0, 1);

        TrigonometricRepresentation result = z.asTrigonometric();

        assertEquals("Absolute value must be 1", 1, result.getAbsoluteValue(), 0.001);
        assertEquals("Argument must be pi/2", Math.PI / 2, result.getArgument(), 0.001);
        assertEquals("i*sin90°", result.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTrigonometricRepresentationThrowsExceptionForZero() {
        ComplexNumber z = ComplexNumber.ZERO;
        TrigonometricRepresentation result = z.asTrigonometric();
    }
}
