package de.mondry.gameoflive;

import java.util.HashMap;
import java.util.Map;

import de.mondry.gameoflive.bean.Cell;

public abstract class AbstractTest {
    
    protected Map<String, Cell> createTestMap(int rows, int length) {
        Map<String, Cell> testMap = new HashMap<String, Cell>();
        for (int row = 0; row < rows; row++) {
            for (int i = 0; i < length; i++) {
                Cell cell = new Cell(row, i);
                testMap.put(cell.getKey(), cell);
            }
        }
        return testMap;
    }
}
