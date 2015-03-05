package com.firsttetris.logic.figures;

public class RotateDirection {
    public enum Direction {
        CLOCKWISE, COUNTERCLOCKWISE
    };

    Direction direction;

    private final static RotateDirection CLOCKWISE = new RotateDirection(
            Direction.CLOCKWISE);
    private final static RotateDirection COUNTERCLOCKWISE =
            new RotateDirection(Direction.COUNTERCLOCKWISE);

    private RotateDirection(Direction direction) {
        setDirection(direction);
    }
    
    public static RotateDirection create(Direction direction) {
        if(direction == Direction.CLOCKWISE) {
            return CLOCKWISE;
        }
        return COUNTERCLOCKWISE;
    }

    public Direction getDirection() {
        return this.direction;
    }

    protected void setDirection(Direction direction) {
        this.direction = direction;
    }
}
