package de.mondry.gameoflive.compute;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.mondry.gameoflive.AbstractTest;
import de.mondry.gameoflive.bean.Cell;

public class NeighBourComputerTest extends AbstractTest {
    
    NeighBourComputer computer;
    
    @Before
    public void setup() {
        computer = new NeighBourComputer();
    }
    
    @Test
    public void test() {
        // create 3*3 grid of dead cells
        Map<String, Cell> testMap = createTestMap(3, 3);
        Cell cell = new Cell(1, 1);
        cell.setAlive(true);
        
        testMap.put(cell.getKey(), cell);
        
        System.out.println(testMap);
        // test
        computer.computeNeighbours(cell, testMap);
        for (Cell c : testMap.values()) {
            if (c.equals(cell)) {
                continue;
            }
            Assert.assertTrue(c.getNumberOfNeighbours() == 1);
        }
    }
    
    @Test
    public void testBeyondBorders() {
        // create 2*2 grid of dead cells
        Map<String, Cell> testMap = createTestMap(2, 2);
        Cell cell = new Cell(0, 0);
        cell.setAlive(true);
        
        testMap.put(cell.getKey(), cell);
        
        System.out.println(testMap);
        // test
        computer.computeNeighbours(cell, testMap);
        for (Cell c : testMap.values()) {
            if (c.equals(cell)) {
                continue;
            }
            Assert.assertTrue(c.getNumberOfNeighbours() == 1);
        }
    }
    
}
