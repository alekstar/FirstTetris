package com.firsttetris.logic.figures;

import java.util.LinkedList;
import java.util.List;

import com.firsttetris.logic.TetrisCoordinates;

public class FigureI extends Figure {
    protected FigureI() {
        super();
        addCell(TetrisCoordinates.create(0, 0));
        addCell(TetrisCoordinates.create(0, 1));
        addCell(TetrisCoordinates.create(0, 2));
        addCell(TetrisCoordinates.create(0, 3));
    }

    public static FigureI create() {
        return new FigureI();
    }

    private List<TetrisCoordinates> defineCellsCoordinatesForAngleZero() {
        return new LinkedList<TetrisCoordinates>(getCellsCoordinatesReference());
    }

    private List<TetrisCoordinates> defineCellsCoordinatesForAngleNinety() {
        LinkedList<TetrisCoordinates> coordinates = new LinkedList<TetrisCoordinates>();
        coordinates.add(TetrisCoordinates.create(0, 0));
        coordinates.add(TetrisCoordinates.create(1, 0));
        coordinates.add(TetrisCoordinates.create(2, 0));
        coordinates.add(TetrisCoordinates.create(3, 0));
        return coordinates;
    }

    private List<TetrisCoordinates> defineCellsCoordinatesForAngleOneHundredEighty() {
        return defineCellsCoordinatesForAngleZero();
    }

    private List<TetrisCoordinates> defineCellsCoordinatesForAngleTwoHundredSeventy() {
        return defineCellsCoordinatesForAngleNinety();
    }

    @Override
    public List<TetrisCoordinates> getCellsCoordinates(FigureAngle angle) {
        switch (angle.getAngle()) {
        case ZERO:
            return defineCellsCoordinatesForAngleZero();
        case NINETY:
            return defineCellsCoordinatesForAngleNinety();
        case ONE_HUNDRED_EIGHTY:
            return defineCellsCoordinatesForAngleOneHundredEighty();
        case TWO_HUNDRED_SEVENTY:
            return defineCellsCoordinatesForAngleTwoHundredSeventy();
        default:
            throw new IllegalArgumentException("Behavior for angle "
                    + angle.getAngle() + " is not defined.");
        }
    }
}
