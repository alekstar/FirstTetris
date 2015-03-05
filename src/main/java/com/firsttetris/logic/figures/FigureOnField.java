package com.firsttetris.logic.figures;

import java.util.ArrayList;
import java.util.List;

import com.firsttetris.exception.ArgumentIsNullException;
import com.firsttetris.logic.Field;
import com.firsttetris.logic.TetrisCoordinates;

public class FigureOnField {
    private Figure figure;
    private TetrisCoordinates coordinatesOfFirstFiguresCell;
    private Field field;
    private FigureAngle angle;

    protected FigureOnField(Figure figure,
            TetrisCoordinates coordinatesOfFirstFiguresCell, Field field,
            FigureAngle angle) {
        setFigure(figure);
        setCoordinatesOfFirstFiguresCell(coordinatesOfFirstFiguresCell);
        setField(field);
    }

    public static FigureOnField create(Figure figure,
            TetrisCoordinates coordinatesOfFirstFiguresCell, Field field,
            FigureAngle angle) {
        return new FigureOnField(figure, coordinatesOfFirstFiguresCell, field,
                angle);
    }

    public static FigureOnField move(FigureOnField figureOnField,
            TetrisCoordinates coordinatesOfFirstFiguresCell, FigureAngle angle) {
        return new FigureOnField(figureOnField.getFigure(),
                coordinatesOfFirstFiguresCell, figureOnField.getField(), angle);
    }

    protected FigureAngle getAngle() {
        return angle;
    }

    protected void setAngle(FigureAngle angle) {
        if (angle == null) {
            throw new ArgumentIsNullException("angle");
        }
        this.angle = angle;
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

    public boolean doesFigureIntersectWithFilledCells() {
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
            return true;
        }
        if (coordinates.getY() < 0
                || getField().getHeight() <= coordinates.getY()) {
            return true;
        }
        return false;
    }

    public boolean doesFigureFitOutField() {
        List<TetrisCoordinates> currentCellsCoordinates =
                calculateCurrentCellsCoordinates();
        for (TetrisCoordinates currentCoordinates : currentCellsCoordinates) {
            if (doesCellOutOfField(currentCoordinates)) {
                return true;
            }
        }
        return false;
    }

    public boolean canBePlaced() {
        if (doesFigureFitOutField()) {
            return false;
        }
        if (doesFigureIntersectWithFilledCells()) {
            return false;
        }
        return true;
    }

    public void place() {
        if (canBePlaced()) {
            for (TetrisCoordinates currentCoordinates : calculateCurrentCellsCoordinates()) {
                getField().setCellValue(currentCoordinates, true);
            }
        } else {
            throw new FigureCantBePlacedException();
        }
    }

    public void remove() {
        for (TetrisCoordinates currentCoordinates : calculateCurrentCellsCoordinates()) {
            getField().setCellValue(currentCoordinates, false);
        }
    }
}
