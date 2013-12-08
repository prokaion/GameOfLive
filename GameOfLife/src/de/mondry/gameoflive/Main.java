package de.mondry.gameoflive;

import de.mondry.gameoflive.bean.GameOfLifeGrid;
import de.mondry.gameoflive.compute.NeighBourComputer;
import de.mondry.gameoflive.fileconvert.FileConverter;

public class Main {
    
    private static final String RELATIVE_PATH = "strangeGrid";
    private static FileConverter fileConverter = new FileConverter();
    private static GameOfLive gameOfLive = new GameOfLive(new NeighBourComputer());
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // read a text file
        try {
            GameOfLifeGrid gameOfLifeGrid = fileConverter.fileConvert(RELATIVE_PATH);
            
            System.out.println(gameOfLifeGrid);
            
            for (int i = 0; i < 50; i++) {
                Thread.sleep(1000);
                gameOfLifeGrid = gameOfLive.createNextGenerationBy(gameOfLifeGrid);
                System.out.println(gameOfLifeGrid);
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
    
}
