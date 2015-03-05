package com.firsttetris.logic.figures;

import java.util.LinkedList;
import java.util.List;

import com.firsttetris.exception.ArgumentIsNullException;
import com.firsttetris.logic.TetrisCoordinates;

public abstract class Figure {
    private List<TetrisCoordinates> cellsCoordinates;

    protected Figure() {
        cellsCoordinates = new LinkedList<TetrisCoordinates>();
    }

    protected List<TetrisCoordinates> getCellsCoordinatesReference() {
        return cellsCoordinates;
    }

    protected void addCell(TetrisCoordinates coordinates) {
        if (coordinates == null) {
            throw new ArgumentIsNullException("coordinates");
        }
        getCellsCoordinatesReference().add(coordinates);
    }

    abstract public List<TetrisCoordinates> getCellsCoordinates(
            FigureAngle angle);
}
