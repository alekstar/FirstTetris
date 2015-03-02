package com.firsttetris.logic;

import java.util.ArrayList;

import com.firsttetris.exception.ArgumentIsNullException;

public class Field {
    private int width;
    private int height;
    private ArrayList<Boolean> field;
    
    private Field(int width, int height) {
        setWidth(width);
        setHeight(height);
        setField(new ArrayList<Boolean>(calculateFieldArraySize()));
    }
    
    public static Field create(int width, int height) {
        Field field = new Field(width, height);
        return field;
    }

    private int calculateFieldArraySize() {
        return getWidth() * getHeight();
    }

    public int getWidth() {
        return width;
    }

    private void setWidth(int width) {
        if(width <= 0) {
            throw new IllegalArgumentException("width: " + width);
        }
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    private void setHeight(int height) {
        if(height <= 0) {
            throw new IllegalArgumentException("height: " + height);
        }
        this.height = height;
    }

    private ArrayList<Boolean> getField() {
        return field;
    }

    private void setField(ArrayList<Boolean> field) {
        if(field == null) {
            throw new ArgumentIsNullException("field");
        }
        this.field = field;
    }
    
    public boolean getCellValue(int xIndex, int yIndex) {
        checkXIndex(xIndex);
        checkYIndex(yIndex);
        int arrayIndex = calculateArrayIndex(xIndex, yIndex);
        return getField().get(arrayIndex).booleanValue();
    }

    private void checkYIndex(int yIndex) {
        if((yIndex >= getHeight()) || (yIndex < 0)) {
            throw new IllegalArgumentException("yIndex: " + yIndex);
        }
    }

    private void checkXIndex(int xIndex) {
        if((xIndex >= getWidth()) || (xIndex < 0)) {
            throw new IllegalArgumentException("xIndex: " + xIndex);
        }
    }

    private int calculateArrayIndex(int xIndex, int yIndex) {
        return getWidth() * yIndex + xIndex;
    }
    
    private void setCellValue(int xIndex, int yIndex, boolean value) {
        checkXIndex(xIndex);
        checkYIndex(yIndex);
        int arrayIndex = calculateArrayIndex(xIndex, yIndex);
        getField().set(arrayIndex, value);
    }
}
