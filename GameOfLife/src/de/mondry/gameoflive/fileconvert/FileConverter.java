package de.mondry.gameoflive.fileconvert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import de.mondry.gameoflive.bean.Cell;
import de.mondry.gameoflive.bean.GameOfLifeGrid;

public class FileConverter {
    
    public GameOfLifeGrid fileConvert(String path) throws IOException {
        
        File file = new File(path);
        if (file.exists()) {
            BufferedReader r = new BufferedReader(new FileReader(file));
            String line = null;
            final Map<String, Cell> cells = new HashMap<>();
            int lengthOfLine = 0;
            int row = 0;
            while ((line = r.readLine()) != null) {
                lengthOfLine = line.length();
                for (int i = 0; i < line.length(); i++) {
                    Cell cell = new Cell(row, i);
                    char charAt = line.charAt(i);
                    if (charAt == '*') {
                        cell.setAlive(true);
                    }
                    cells.put(cell.getKey(), cell);
                }
                row++;
            }
            GameOfLifeGrid gameOfLifeGrid = new GameOfLifeGrid(row, lengthOfLine, cells);
            return gameOfLifeGrid;
        } else {
            throw new FileNotFoundException("file named " + path + " not found!");
        }
    }
    
}
