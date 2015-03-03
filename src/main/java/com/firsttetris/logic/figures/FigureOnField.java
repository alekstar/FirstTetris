package com.firsttetris.logic.figures;

import java.util.ArrayList;
import java.util.List;

import com.firsttetris.logic.Field;
import com.firsttetris.logic.TetrisCoordinates;

public class FigureOnField {
    Figure figure;
    TetrisCoordinates coordinatesOfFirstFiguresCell;
    Field field;

    protected FigureOnField(Figure figure,
            TetrisCoordinates coordinatesOfFirstFiguresCell, Field field) {
        setFigure(figure);
        setCoordinatesOfFirstFiguresCell(coordinatesOfFirstFiguresCell);
        setField(field);
    }
    
    public static FigureOnField create(Figure figure,
            TetrisCoordinates coordinatesOfFirstFiguresCell, Field field) {
        return new FigureOnField(figure, coordinatesOfFirstFiguresCell, field);
    }

    protected Figure getFigure() {
        return figure;
    }

    protected void setFigure(Figure figure) {
        this.figure = figure;
    }

    protected TetrisCoordinates getCoordinatesOfFirstFiguresCell() {
        return coordinatesOfFirstFiguresCell;
    }

    protected void setCoordinatesOfFirstFiguresCell(
            TetrisCoordinates coordinatesOfFirstFiguresCell) {
        this.coordinatesOfFirstFiguresCell = coordinatesOfFirstFiguresCell;
    }

    protected Field getField() {
        return field;
    }

    protected void setField(Field field) {
        this.field = field;
    }


    protected List<TetrisCoordinates> calculateCurrentCellsCoordinates() {
        List<TetrisCoordinates> cellsCoordinates = figure.getCellsCoordinates();
        List<TetrisCoordinates> currentCellsCoordinates =
                new ArrayList<TetrisCoordinates>();
        for (TetrisCoordinates currentCoordinates : cellsCoordinates) {
            int newX =
                    currentCoordinates.getX()
                            + coordinatesOfFirstFiguresCell.getX();
            int newY =
                    currentCoordinates.getY()
                            + coordinatesOfFirstFiguresCell.getY();
            currentCoordinates = TetrisCoordinates.create(newX, newY);
            currentCellsCoordinates.add(currentCoordinates);
        }
        return currentCellsCoordinates;
    }

    protected boolean doesFigureIntersectWithFilledCells() {
        List<TetrisCoordinates> currentCellsCoordinates =
                calculateCurrentCellsCoordinates();
        for (TetrisCoordinates currentCoordinates : currentCellsCoordinates) {
            if (getField().getCellValue(currentCoordinates) == true) {
                return true;
            }
        }
        return false;
    }

    protected boolean doesCellOutOfField(TetrisCoordinates coordinates) {
        if (coordinates.getX() < 0
                || getField().getWidth() <= coordinates.getX()) {
            return false;
        }
        if (coordinates.getY() < 0
                || getField().getHeight() <= coordinates.getY()) {
            return false;
        }
        return true;
    }

    protected boolean doesFigureFitOutField() {
        List<TetrisCoordinates> currentCellsCoordinates =
                calculateCurrentCellsCoordinates();
        for (TetrisCoordinates currentCoordinates : currentCellsCoordinates) {
            if (doesCellOutOfField(currentCoordinates)) {
                return true;
            }
        }
        return false;
    }

    protected boolean canBePlaced() {
        if (doesFigureIntersectWithFilledCells() || doesFigureFitOutField()) {
            return false;
        }
        return true;
    }
}
