package com.firsttetris.logic;

import com.firsttetris.exception.ArgumentIsNullException;

public class FullLineRemover extends Thread {
    private Field field;

    private FullLineRemover(Field field) {
        super();
        setField(field);
    }

    public static FullLineRemover create(Field field) {
        FullLineRemover fullLineRemover = new FullLineRemover(field);
        return fullLineRemover;
    }

    private boolean isLowerLineIsFull() {
        for (int xIndex = 0; xIndex < getField().getWidth(); xIndex++) {
            if (getField().
                    getCellValue(xIndex, getField().getHeight() - 1) == false) {
                return false;
            }
        }
        return true;
    }
    
    private void clearLowerLine() {
        getField().clearLine(getField().getHeight() - 1);
    }

    @Override
    public void run() {
        while (true) {
            if(isLowerLineIsFull()) {
                clearLowerLine();
            }
        }
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
}
