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
    
}
