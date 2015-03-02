package com.firsttetris;

import com.firsttetris.debug.FieldPrinter;
import com.firsttetris.logic.Field;
import com.firsttetris.logic.FullLineRemover;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Field field = Field.create(10, 20);
        FieldPrinter fieldPrinter = FieldPrinter.create(field);
        FullLineRemover fullLineRemover = FullLineRemover.create(field);
        fullLineRemover.start();
        for(int xIndex = 0; xIndex < field.getWidth(); xIndex++) {
            field.setCellValue(xIndex, field.getHeight() - 1, true);
        }
        fieldPrinter.print();
        Thread.sleep(100);
        fieldPrinter.print();
    }

}
