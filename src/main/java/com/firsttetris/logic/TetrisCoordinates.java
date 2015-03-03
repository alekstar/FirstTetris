package com.firsttetris.logic;

public class TetrisCoordinates {
    private int x;
    private int y;
    
    protected TetrisCoordinates(int x, int y) {
        setX(x);
        setY(y);
    }
    
    public static TetrisCoordinates create(int x, int y) {
        TetrisCoordinates tetrisCoordinates = new TetrisCoordinates(x, y);
        return tetrisCoordinates;
    }

    public int getX() {
        return x;
    }

    protected void setX(int x) {
        if(x < 0) {
            throw new IllegalArgumentException("x: " + x);
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    protected void setY(int y) {
        if(y < 0) {
            throw new IllegalArgumentException("y: " + y);
        }
        this.y = y;
    }
}
