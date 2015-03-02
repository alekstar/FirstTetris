package com.firsttetris;

import com.firsttetris.debug.FieldPrinter;
import com.firsttetris.logic.Field;

public class main {

    public static void main(String[] args) {
        Field field = Field.create(10, 20);
        FieldPrinter fieldPrinter = FieldPrinter.create(field);
        field.setCellValue(3, 4, true);
        field.setCellValue(3, 5, true);
        field.setCellValue(3, 6, true);
        field.setCellValue(4, 6, true);
        fieldPrinter.print();
    }

}
