package com.firsttetris.logic.figures;

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
}
