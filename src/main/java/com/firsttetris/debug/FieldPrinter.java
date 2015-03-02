package com.firsttetris.debug;

import java.io.PrintStream;

import com.firsttetris.exception.ArgumentIsNullException;
import com.firsttetris.logic.Field;

public class FieldPrinter {
    private Field field;
    private PrintStream printStream;
    
    private FieldPrinter(Field field, PrintStream printStream) {
        setField(field);
        setPrintStream(printStream);
    }
    
    public static FieldPrinter create(Field field) {
        FieldPrinter fieldPrinter = FieldPrinter.create(field, System.out);
        return  fieldPrinter;
    }
    
    public static FieldPrinter create(Field field, PrintStream printStream) {
        FieldPrinter fieldPrinter = new FieldPrinter(field, printStream);
        return  fieldPrinter;
    }

    private void printHorizontalLine(int length) {
        for (int i = 0; i < length; i++) {
            getPrintStream().print(defineHorisontalBorderSymbol());
        }
    }

    private void printUpperBorder() {
        getPrintStream().print(defineLeftUpperCornerSymbol());
        printHorizontalLine(getField().getWidth());
        getPrintStream().print(defineRightUpperCornerSymbol());
        getPrintStream().println();
    }

    private void printLowerBorder() {
        getPrintStream().print(defineLeftLowerCornerSymbol());
        printHorizontalLine(getField().getWidth());
        getPrintStream().print(defineRightLowerCornerSymbol());
        getPrintStream().println();
    }

    private char defineRightUpperCornerSymbol() {
        return '┐';
    }

    private char defineRightLowerCornerSymbol() {
        return '┘';
    }

    private char defineLeftUpperCornerSymbol() {
        return '┌';
    }

    private char defineLeftLowerCornerSymbol() {
        return '└';
    }

    private char defineHorisontalBorderSymbol() {
        return '─';
    }

    private char defineVerticalBorderSymbol() {
        return '│';
    }

    private char defineFilledCellSymbol() {
        return '#';
    }

    private char defineEmptyCellSymbol() {
        return '.';
    }

    public void print() {
        printUpperBorder();
        for (int yIndex = 0; yIndex < getField().getHeight(); yIndex++) {
            getPrintStream().print(defineVerticalBorderSymbol());
            for (int xIndex = 0; xIndex < getField().getWidth(); xIndex++) {
                if(getField().getCellValue(xIndex, yIndex) == true) {
                    getPrintStream().print(defineFilledCellSymbol());
                } else {
                    getPrintStream().print(defineEmptyCellSymbol());
                }
            }
            getPrintStream().print(defineVerticalBorderSymbol());
            getPrintStream().println();
        }
        printLowerBorder();
    }

    private Field getField() {
        return field;
    }

    private void setField(Field field) {
        if (field == null) {
            throw new ArgumentIsNullException("field");
        }
        this.field = field;
    }

    private PrintStream getPrintStream() {
        return printStream;
    }

    private void setPrintStream(PrintStream printStream) {
        if(printStream == null) {
            throw new ArgumentIsNullException("printStream");
        }
        this.printStream = printStream;
    }
    
    
}
