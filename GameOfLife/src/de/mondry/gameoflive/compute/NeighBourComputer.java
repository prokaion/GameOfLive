package de.mondry.gameoflive.compute;

import java.util.Map;

import de.mondry.gameoflive.GameOfLive;
import de.mondry.gameoflive.bean.Cell;

public class NeighBourComputer {
    
    private int[] indizesToHandle = { -1, 0, 1 };
    
    /**
     * Cell must be alive. this increments numOfNeighbours of all neighbourcells.
     * 
     * @param cell
     * @param cellMap
     */
    public void computeNeighbours(Cell cell, Map<String, Cell> cellMap) {
        if (!cell.isAlive()) {
            throw new IllegalArgumentException("cell must be alive but isnt!");
        }
        int row = cell.getRowIndex();
        int index = cell.getIndexOfCell();
        
        for (int rowIndex : indizesToHandle) {
            for (int lineIndex : indizesToHandle) {
                String key = GameOfLive.getKey(row + rowIndex, index + lineIndex); // String.valueOf(row + rowIndex) + String.valueOf(index + lineIndex);
                // dont compute yourself:
                if (key.equals(cell.getKey())) {
                    continue;
                }
                Cell currentCell = cellMap.get(key);
                if (currentCell != null) { // beyond borders otherwise
                    currentCell.incrementNeighbour();
                }
            }
        }
    }
    
}
