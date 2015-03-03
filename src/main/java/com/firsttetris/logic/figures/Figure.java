package com.firsttetris.logic.figures;

import java.util.ArrayList;
import java.util.List;

import com.firsttetris.exception.ArgumentIsNullException;
import com.firsttetris.logic.TetrisCoordinates;

public abstract class Figure {
    private List<TetrisCoordinates> cellsCoordinates;
    
    protected Figure() {
        cellsCoordinates = new ArrayList<TetrisCoordinates>();
    }
    
    protected List<TetrisCoordinates> getCellsCoordinatesReference() {
        return cellsCoordinates;
    }
    
    public List<TetrisCoordinates> getCellsCoordinates() {
        List<TetrisCoordinates> cellCoordinatesClone = 
                new ArrayList<TetrisCoordinates>(cellsCoordinates);
        return cellCoordinatesClone;
    }
    
    protected void addCell(TetrisCoordinates coordinates) {
        if(coordinates == null) {
            throw new ArgumentIsNullException("coordinates");
        }
        getCellsCoordinatesReference().add(coordinates);
    }
}
