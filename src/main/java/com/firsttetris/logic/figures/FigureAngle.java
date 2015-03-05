package com.firsttetris.logic.figures;

import com.firsttetris.exception.ArgumentIsNullException;

public class FigureAngle {
    public enum AngleValue {
        ZERO, NINETY, ONE_HUNDRED_EIGHTY, TWO_HUNDRED_SEVENTY
    };

    AngleValue angle;

    private static FigureAngle ZERO = new FigureAngle(AngleValue.ZERO);
    private static FigureAngle NINETY = new FigureAngle(AngleValue.NINETY);
    private static FigureAngle ONE_HUNDRED_EIGHTY = new FigureAngle(
            AngleValue.ONE_HUNDRED_EIGHTY);
    private static FigureAngle TWO_HUNDRED_SEVENTY = new FigureAngle(
            AngleValue.TWO_HUNDRED_SEVENTY);

    protected FigureAngle() {
        setAngle(AngleValue.ZERO);
    }

    protected FigureAngle(AngleValue angle) {
        setAngle(angle);
    }

    public static FigureAngle create(AngleValue angle) {
        switch (angle) {
        case ZERO:
            return FigureAngle.ZERO;
        case NINETY:
            return FigureAngle.NINETY;
        case ONE_HUNDRED_EIGHTY:
            return FigureAngle.ONE_HUNDRED_EIGHTY;
        case TWO_HUNDRED_SEVENTY:
            return FigureAngle.TWO_HUNDRED_SEVENTY;
        default:
            throw new IllegalArgumentException("angle: " + angle);
        }
    }

    public AngleValue getAngle() {
        return angle;
    }

    protected void setAngle(AngleValue angle) {
        if (angle == null) {
            throw new ArgumentIsNullException("angle");
        }
        this.angle = angle;
    }

    protected FigureAngle rotateClockwise() {
        switch (getAngle()) {
        case ZERO:
            return FigureAngle.TWO_HUNDRED_SEVENTY;
        case NINETY:
            return FigureAngle.ZERO;
        case ONE_HUNDRED_EIGHTY:
            return FigureAngle.NINETY;
        case TWO_HUNDRED_SEVENTY:
            return FigureAngle.ONE_HUNDRED_EIGHTY;
        default:
            throw new IllegalStateException();
        }
    }
    
    protected FigureAngle rotateCounterclockwise() {
        switch (getAngle()) {
        case ZERO:
            return FigureAngle.NINETY;
        case NINETY:
            return FigureAngle.ONE_HUNDRED_EIGHTY;
        case ONE_HUNDRED_EIGHTY:
            return FigureAngle.TWO_HUNDRED_SEVENTY;
        case TWO_HUNDRED_SEVENTY:
            return FigureAngle.ZERO;
        default:
            throw new IllegalStateException();
        }
    }

    FigureAngle rotate(RotateDirection direction) {
        if(direction.getDirection() == RotateDirection.Direction.CLOCKWISE) {
            return rotateClockwise();
        } else {
            return rotateCounterclockwise();
        }
    }
}
