package com.firsttetris;

import java.util.ArrayList;
import java.util.List;

import com.firsttetris.debug.FieldPrinter;
import com.firsttetris.logic.Field;
import com.firsttetris.logic.FullLineRemover;
import com.firsttetris.logic.TetrisCoordinates;
import com.firsttetris.logic.figures.Figure;
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
        FigureOnField figureOnField =
                FigureOnField.create(figure, TetrisCoordinates.create(2, 3),
                        field);
        figureOnField.place();
        fieldPrinter.print();
    }

}
