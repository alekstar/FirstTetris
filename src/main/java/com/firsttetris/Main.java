package com.firsttetris;

import java.util.ArrayList;
import java.util.List;

import com.firsttetris.debug.FieldPrinter;
import com.firsttetris.logic.Field;
import com.firsttetris.logic.FullLineRemover;
import com.firsttetris.logic.TetrisCoordinates;
import com.firsttetris.logic.figures.Figure;
import com.firsttetris.logic.figures.FigureAngle;
import com.firsttetris.logic.figures.FigureAngle.AngleValue;
import com.firsttetris.logic.figures.FigureI;
import com.firsttetris.logic.figures.FigureOnField;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Field field = Field.create(10, 20);
        FieldPrinter fieldPrinter = FieldPrinter.create(field);
        // FullLineRemover fullLineRemover = FullLineRemover.create(field);
        // fullLineRemover.start();
        // for (int xIndex = 0; xIndex < field.getWidth(); xIndex++) {
        // field.setCellValue(xIndex, field.getHeight() - 1, true);
        // }
        fieldPrinter.print();
        Figure figure = FigureI.create();
        int y = 3;
        FigureOnField figureOnField =
                FigureOnField.create(figure, TetrisCoordinates.create(2, y),
                        field, FigureAngle.create(AngleValue.ZERO));
        while(figureOnField.canBePlaced()) {
            figureOnField.place();
            fieldPrinter.print();
            y++;
            FigureOnField newFigureOnField =
                    FigureOnField.move(figureOnField,
                            TetrisCoordinates.create(2, y),
                            FigureAngle.create(AngleValue.ZERO));
            figureOnField.remove();
            figureOnField = newFigureOnField;
        }
    }
}
