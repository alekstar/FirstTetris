package com.firsttetris.logic;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class FieldTest {

    @Test
    public void shouldFieldHaveWidth3() {
        Field field = null;
        field = Field.create(3, 3);
        assertEquals(3, field.getWidth());
    }
    
    @Test
    public void shouldFieldHaveHeight4() {
        Field field = null;
        field = Field.create(3, 4);
        assertEquals(4, field.getHeight());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForWidth0() {
        @SuppressWarnings("unused")
        Field field = null;
        field = Field.create(0, 4);
        fail("Exception was not thrown.");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForWidthMinus10() {
        @SuppressWarnings("unused")
        Field field = null;
        field = Field.create(-10, 4);
        fail("Exception was not thrown.");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForHeight0() {
        @SuppressWarnings("unused")
        Field field = null;
        field = Field.create(4, 0);
        fail("Exception was not thrown.");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForHeightMinus10() {
        @SuppressWarnings("unused")
        Field field = null;
        field = Field.create(4, -10);
        fail("Exception was not thrown.");
    }
    
    @Test
    public void shouldCreateEmptyField() {
        Field field = null;
        field = Field.create(10, 20);
        Boolean[] expectedFieldArray = defineFalseBooleanArrayFor200Elements();
        assertArrayEquals(expectedFieldArray, field.getField().toArray());
    }

    private Boolean[] defineFalseBooleanArrayFor200Elements() {
        final int EXPECTED_FIELD_ARRAY_SIZE = 200;
        Boolean[] expectedFieldArray = new Boolean[EXPECTED_FIELD_ARRAY_SIZE];
        for (int i = 0; i < expectedFieldArray.length; i++) {
            expectedFieldArray[i] = new Boolean(false);
        }
        return expectedFieldArray;
    }
    
    @Test
    public void shouldSetCellToTrueAtCoordinates3And4() {
        Field field = Field.create(5, 10);
        field.setCellValue(3, 4, true);
        assertEquals(true, field.getCellValue(3, 4));
    }
    
    @Test
    public void shouldBeTrueOnlyCellAtCoordinates3And4OtherAreClear() {
        Field field = Field.create(5, 10);
        field.setCellValue(3, 4, true);
        for (int xIndex = 0; xIndex < 5; xIndex++) {
            for (int yIndex = 0; yIndex < 10; yIndex++) {
                if(!(xIndex == 3 && yIndex == 4)) {
                    assertEquals(false, field.getCellValue(xIndex, yIndex));
                }
            }
        }
    }

}
