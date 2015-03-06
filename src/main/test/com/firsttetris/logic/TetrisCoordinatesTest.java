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

}
