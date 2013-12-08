package de.mondry.gameoflive;

import java.util.HashMap;
import java.util.Map;

import de.mondry.gameoflive.bean.Cell;
import de.mondry.gameoflive.bean.GameOfLifeGrid;
import de.mondry.gameoflive.compute.NeighBourComputer;

public class GameOfLive {
    
    private NeighBourComputer neighbourComputer;
    
    public GameOfLive(NeighBourComputer neighbourComputer) {
        this.neighbourComputer = neighbourComputer;
    }
    
    public GameOfLifeGrid createNextGenerationBy(GameOfLifeGrid gameOfLifeGrid) {
        
        // 1) each live cell computes its neighbours.
        for (Cell cell : gameOfLifeGrid.getCells().values()) {
            if (cell.isAlive()) {
                neighbourComputer.computeNeighbours(cell, gameOfLifeGrid.getCells());
            }
        }
        
        // 2) create new GamOfLiveGrid (deep copy, for whatever)
        int numOfRows = gameOfLifeGrid.getNumOfRows();
        int lengthOfLine = gameOfLifeGrid.getLengthOfLine();
        Map<String, Cell> newMap = new HashMap<String, Cell>();
        
        for (Cell oldCell : gameOfLifeGrid.getCells().values()) {
            Cell newCell = oldCell.copyMe();
            // decide about life and death
            if (oldCell.isAlive() && oldCell.getNumberOfNeighbours() < 2) {
                newCell.setAlive(false);
            }
            if (oldCell.isAlive() && oldCell.getNumberOfNeighbours() > 3) {
                newCell.setAlive(false);
            }
            if (!oldCell.isAlive() && oldCell.getNumberOfNeighbours() == 3) {
                newCell.setAlive(true);
            }
            newMap.put(newCell.getKey(), newCell);
            
        }
        
        return new GameOfLifeGrid(numOfRows, lengthOfLine, newMap);
    }
    
    public static String getKey(int row, int index) {
        return String.valueOf(row) + '/' + String.valueOf(index);
    }
}
