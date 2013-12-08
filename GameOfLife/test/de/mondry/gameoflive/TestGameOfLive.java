package de.mondry.gameoflive;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import de.mondry.gameoflive.bean.Cell;
import de.mondry.gameoflive.bean.GameOfLifeGrid;
import de.mondry.gameoflive.compute.NeighBourComputer;
import de.mondry.gameoflive.fileconvert.FileConverter;

public class TestGameOfLive {
    
    GameOfLive gameOfLive = new GameOfLive(new NeighBourComputer());
    
    @Test
    public void test() {
        
        FileConverter converter = new FileConverter();
        try {
            GameOfLifeGrid gameOfLifeGrid = converter.fileConvert("grid");
            
            Map<String, Cell> expectedmap = new HashMap<String, Cell>();
            int rows = 4;
            int length = 8;
            for (int row = 0; row < rows; row++) {
                for (int i = 0; i < length; i++) {
                    Cell cell = new Cell(row, i);
                    if ((row == 1 || row == 2) && (i == 3 || i == 4)) {
                        cell.setAlive(true);
                    }
                    expectedmap.put(cell.getKey(), cell);
                }
            }
            
            GameOfLifeGrid expected = new GameOfLifeGrid(rows, length, expectedmap);
            
            // test...
            GameOfLifeGrid gameOfLifeGrid2 = gameOfLive.createNextGenerationBy(gameOfLifeGrid);
            
            Assert.assertEquals(expected, gameOfLifeGrid2);
            System.out.println(gameOfLifeGrid2);
            
            // Test again. It should be the same!
            // test...
            GameOfLifeGrid gameOfLifeGrid3 = gameOfLive.createNextGenerationBy(gameOfLifeGrid2);
            System.out.println(gameOfLifeGrid3);
            Assert.assertEquals(expected, gameOfLifeGrid3);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Uuuh!");
        }
    }
    
    @Test
    public void testStrange() throws IOException {
        
        FileConverter converter = new FileConverter();
        
        GameOfLifeGrid gameOfLifeGrid = converter.fileConvert("strangeGrid");
        System.out.println(gameOfLifeGrid);
        
        gameOfLifeGrid = gameOfLive.createNextGenerationBy(gameOfLifeGrid);
        System.out.println(gameOfLifeGrid);
    }
    
}
