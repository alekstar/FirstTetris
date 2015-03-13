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
        Boolean[] expectedFieldArray = defineFalseBooleanArrayForField(10, 20);
        assertArrayEquals(expectedFieldArray, field.getField().toArray());
    }

    private Boolean[] defineFalseBooleanArrayForField(int width, int height) {
        Boolean[] expectedFieldArray = new Boolean[width * height];
        for (int i = 0; i < expectedFieldArray.length; i++) {
            expectedFieldArray[i] = new Boolean(false);
        }
        return expectedFieldArray;
    }
    
    private void fillCell(TetrisCoordinates coordinates, Boolean[] fieldArray,
            int width) {
        final int fieldArrayIndex = coordinates.getX() + coordinates.getY() * width;
        fieldArray[fieldArrayIndex] = true;
    }

    @Test
    public void shouldSetCellToTrueAtCoordinates3And4() {
        Field field = Field.create(5, 10);
        field.setCellValue(3, 4, true);
        assertEquals(true, field.getCellValue(3, 4));
    }
    
    @Test
    public void shouldBeTrueOnlyCellAtCoordinates3And4OtherAreClear() {
        final int FIELD_WIDTH = 5;
        final int FIELD_HEIGHT = 10;
        final int FILLED_CELL_X_COORDINATE = 3;
        final int FILLED_CELL_Y_COORDINATE = 4;
        Field field = Field.create(FIELD_WIDTH, FIELD_HEIGHT);
        Boolean[] expectedFieldArray = defineFalseBooleanArrayForField(FIELD_WIDTH, FIELD_HEIGHT);
        fillCell(TetrisCoordinates.create(FILLED_CELL_X_COORDINATE, FILLED_CELL_Y_COORDINATE), expectedFieldArray, FIELD_HEIGHT);
        assertArrayEquals(expectedFieldArray, field.getField().toArray());
    }

}
