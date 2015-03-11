package com.firsttetris.logic.figures;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.firsttetris.logic.TetrisCoordinates;
import com.firsttetris.logic.TetrisCoordinatesTest;

public class FigureITest {

    @Test
    public void shouldReturnCoordinatesOfFigureIVertically() {
        Figure figure = FigureI.create();
        List<TetrisCoordinates> actualCoordinates =
                figure.getCellsCoordinates(FigureAngle
                        .create(FigureAngle.AngleValue.ZERO));
        List<TetrisCoordinates> expectedCoordinates = new LinkedList<TetrisCoordinates>();
        expectedCoordinates.add(TetrisCoordinates.create(0, 0));
        expectedCoordinates.add(TetrisCoordinates.create(0, 1));
        expectedCoordinates.add(TetrisCoordinates.create(0, 2));
        expectedCoordinates.add(TetrisCoordinates.create(0, 3));
        assertArrayEquals(expectedCoordinates.toArray(), actualCoordinates.toArray());
    }
}
