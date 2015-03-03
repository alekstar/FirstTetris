package com.firsttetris.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.firsttetris.exception.ArgumentIsNullException;

public class Field {
    private int width;
    private int height;
    private List<Boolean> field;

    private Field(int width, int height) {
        setWidth(width);
        setHeight(height);
        setField(Collections.synchronizedList(new ArrayList<Boolean>()));
        fillFieldArrayWithFalseValues();
    }

    public static Field create(int width, int height) {
        Field field = new Field(width, height);
        return field;
    }

    private void fillFieldArrayWithFalseValues() {
        for (int index = 0; index < calculateFieldArraySize(); index++) {
            field.add(new Boolean(false));
        }
    }

    private int calculateFieldArraySize() {
        return getWidth() * getHeight();
    }

    public int getWidth() {
        return width;
    }

    private void setWidth(int width) {
        if (width <= 0) {
            throw new IllegalArgumentException("width: " + width);
        }
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    private void setHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("height: " + height);
        }
        this.height = height;
    }

    private List<Boolean> getField() {
        return field;
    }

    private void setField(List<Boolean> field) {
        if (field == null) {
            throw new ArgumentIsNullException("field");
        }
        this.field = field;
    }

    public synchronized boolean getCellValue(int xIndex, int yIndex) {
        checkXIndex(xIndex);
        checkYIndex(yIndex);
        int arrayIndex = calculateArrayIndex(xIndex, yIndex);
        return getField().get(arrayIndex).booleanValue();
    }
    
    public synchronized boolean getCellValue(TetrisCoordinates coordinates) {
        checkCoordinates(coordinates);
        return getCellValue(coordinates.getX(), coordinates.getY());
    }
    
    private void checkCoordinates(TetrisCoordinates coordinates) {
        if(coordinates == null) {
            throw new ArgumentIsNullException("coordinates");
        }
        checkXIndex(coordinates.getX());
        checkYIndex(coordinates.getY());
    }

    private void checkYIndex(int yIndex) {
        if ((yIndex >= getHeight()) || (yIndex < 0)) {
            throw new IllegalArgumentException("yIndex: " + yIndex);
        }
    }

    private void checkXIndex(int xIndex) {
        if ((xIndex >= getWidth()) || (xIndex < 0)) {
            throw new IllegalArgumentException("xIndex: " + xIndex);
        }
    }

    private int calculateArrayIndex(int xIndex, int yIndex) {
        return getWidth() * yIndex + xIndex;
    }

    public synchronized void setCellValue(int xIndex, int yIndex, boolean value) {
        checkXIndex(xIndex);
        checkYIndex(yIndex);
        int arrayIndex = calculateArrayIndex(xIndex, yIndex);
        getField().set(arrayIndex, value);
    }
    
    public synchronized void setCellValue(TetrisCoordinates coordinates, boolean value) {
        checkCoordinates(coordinates);
        setCellValue(coordinates.getX(), coordinates.getY(), value);
    }

    public synchronized void clearLine(int yIndex) {
        for (int xIndex = 0; xIndex < getWidth(); xIndex++) {
            setCellValue(xIndex, yIndex, false);
        }
    }
}
