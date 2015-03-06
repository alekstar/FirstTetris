package com.firsttetris.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class TetrisCoordinatesTest {

    @Test
    public void shouldCreateCoordinatesWithXEquals12() {
        TetrisCoordinates coordinates = null;
        coordinates = TetrisCoordinates.create(12, 15);
        assertEquals(12, coordinates.getX());
    }
    
    @Test
    public void shouldCreateCoordinatesWithYEquals15() {
        TetrisCoordinates coordinates = null;
        coordinates = TetrisCoordinates.create(12, 15);
        assertEquals(15, coordinates.getY());
    }

    @Test
    public void shouldCreateCoordinatesWithXEquals0() {
        TetrisCoordinates coordinates = null;
        coordinates = TetrisCoordinates.create(0, 15);
        assertEquals(0, coordinates.getX());
    }
    
    @Test
    public void shouldCreateCoordinatesWithYEquals0() {
        TetrisCoordinates coordinates = null;
        coordinates = TetrisCoordinates.create(5, 0);
        assertEquals(0, coordinates.getY());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForXEqualsMinus1() {
        @SuppressWarnings("unused")
        TetrisCoordinates coordinates = null;
        coordinates = TetrisCoordinates.create(-1, 5);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForYEqualsMinus5() {
        @SuppressWarnings("unused")
        TetrisCoordinates coordinates = null;
        coordinates = TetrisCoordinates.create(1, -5);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForXEqualsMinus1AndYEqualsMinus5() {
        @SuppressWarnings("unused")
        TetrisCoordinates coordinates = null;
        coordinates = TetrisCoordinates.create(-1, -5);
    }
}
