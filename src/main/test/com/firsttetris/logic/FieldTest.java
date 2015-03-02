package com.firsttetris.logic;

import static org.junit.Assert.*;

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
        Field field = null;
        field = Field.create(0, 4);
        fail("Exception was not thrown.");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForWidthMinus10() {
        Field field = null;
        field = Field.create(-10, 4);
        fail("Exception was not thrown.");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForHeight0() {
        Field field = null;
        field = Field.create(4, 0);
        fail("Exception was not thrown.");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForHeightMinus10() {
        Field field = null;
        field = Field.create(4, -10);
        fail("Exception was not thrown.");
    }

}
