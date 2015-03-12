package com.firsttetris.logic.figures;

import static org.junit.Assert.assertArrayEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.firsttetris.logic.TetrisCoordinates;

public class FigureITest {

    @Test
    public void shouldReturnCoordinatesOfFigureIVerticallyForZeroDegreesAngle() {
        Figure figure = FigureI.create();
        List<TetrisCoordinates> actualCoordinates = figure
                .getCellsCoordinates(FigureAngle
                        .create(FigureAngle.AngleValue.ZERO));
        assertArrayEquals(defineExpectedListOfCoordinatesForVerticalFigureI()
                .toArray(), actualCoordinates.toArray());
    }

    @Test
    public void
            shouldReturnCoordinatesOfFigureIVerticallyForOneHundredAndEightyDegreesAngle() {
        Figure figure = FigureI.create();
        List<TetrisCoordinates> actualCoordinates = figure
                .getCellsCoordinates(FigureAngle
                        .create(FigureAngle.AngleValue.ONE_HUNDRED_EIGHTY));
        assertArrayEquals(defineExpectedListOfCoordinatesForVerticalFigureI()
                .toArray(), actualCoordinates.toArray());
    }

    private List<TetrisCoordinates>
            defineExpectedListOfCoordinatesForVerticalFigureI() {
        List<TetrisCoordinates> expectedCoordinates = new LinkedList<TetrisCoordinates>();
        expectedCoordinates.add(TetrisCoordinates.create(0, 0));
        expectedCoordinates.add(TetrisCoordinates.create(0, 1));
        expectedCoordinates.add(TetrisCoordinates.create(0, 2));
        expectedCoordinates.add(TetrisCoordinates.create(0, 3));
        return expectedCoordinates;
    }

    @Test
    public void
            shouldReturnCoordinatesOfFigureIHorizontallyForNinetyDegreesAngle() {
        Figure figure = FigureI.create();
        List<TetrisCoordinates> actualCoordinates = figure
                .getCellsCoordinates(FigureAngle
                        .create(FigureAngle.AngleValue.NINETY));
        assertArrayEquals(defineExpectedListOfCoordinatesForHorizontalFigureI()
                .toArray(), actualCoordinates.toArray());
    }

    @Test
    public void
            shouldReturnCoordinatesOfFigureIHorizontallyForTwoHundredAndSeventyDegreesAngle() {
        Figure figure = FigureI.create();
        List<TetrisCoordinates> actualCoordinates = figure
                .getCellsCoordinates(FigureAngle
                        .create(FigureAngle.AngleValue.TWO_HUNDRED_SEVENTY));
        assertArrayEquals(defineExpectedListOfCoordinatesForHorizontalFigureI()
                .toArray(), actualCoordinates.toArray());
    }

    private List<TetrisCoordinates>
            defineExpectedListOfCoordinatesForHorizontalFigureI() {
        List<TetrisCoordinates> expectedCoordinates = new LinkedList<TetrisCoordinates>();
        expectedCoordinates.add(TetrisCoordinates.create(0, 0));
        expectedCoordinates.add(TetrisCoordinates.create(1, 0));
        expectedCoordinates.add(TetrisCoordinates.create(2, 0));
        expectedCoordinates.add(TetrisCoordinates.create(3, 0));
        return expectedCoordinates;
    }
}
