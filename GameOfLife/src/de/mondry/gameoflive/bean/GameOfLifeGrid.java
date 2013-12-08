package de.mondry.gameoflive.bean;

import java.util.HashMap;
import java.util.Map;

public class GameOfLifeGrid {
    
    private int numOfRows;
    private int lengthOfLine;
    private Map<String, Cell> cells = new HashMap<>();
    
    public GameOfLifeGrid(int numOfRows, int lengthOfLine, Map<String, Cell> cells) {
        this.numOfRows = numOfRows;
        this.lengthOfLine = lengthOfLine;
        if (cells != null) {
            this.cells = cells;
        }
        
    }
    
    public String print() {
        StringBuilder builder = new StringBuilder("" + lengthOfLine);
        builder.append("\n");
        for (int row = 0; row < numOfRows; row++) {
            
            for (int i = 0; i < lengthOfLine; i++) {
                Cell cell = cells.get(getKey(row, i));
                if (cell.isAlive()) {
                    builder.append('*');
                } else {
                    builder.append('.');
                }
            }
            builder.append("\n");
        }
        
        return builder.toString();
    }
    
    @Override
    public String toString() {
        return print();
    }
    
    public int getLengthOfLine() {
        return lengthOfLine;
    }
    
    public void setLengthOfLine(int length) {
        this.lengthOfLine = length;
    }
    
    public String getKey(int row, int index) {
        return String.valueOf(row) + '/' + String.valueOf(index);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cells == null) ? 0 : cells.hashCode());
        result = prime * result + lengthOfLine;
        result = prime * result + numOfRows;
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GameOfLifeGrid other = (GameOfLifeGrid) obj;
        if (cells == null) {
            if (other.cells != null)
                return false;
        } else if (!cells.equals(other.cells))
            return false;
        if (lengthOfLine != other.lengthOfLine)
            return false;
        if (numOfRows != other.numOfRows)
            return false;
        return true;
    }
    
    public Map<String, Cell> getCells() {
        return cells;
    }
    
    public int getNumOfRows() {
        return numOfRows;
    }
    
}
