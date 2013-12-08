package de.mondry.gameoflive.fileconvert;

import static org.junit.Assert.fail;

import java.io.FileNotFoundException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import de.mondry.gameoflive.bean.GameOfLifeGrid;

public class TestFileConverter {
    
    private String path = "grid";
    private FileConverter fileConverter;
    
    @Before
    public void setup() {
        fileConverter = new FileConverter();
    }
    
    @Test
    @Ignore
    public void testIfFileNotThere() {
        try {
            
            // 1) read a file named 'grid' and convert it into bitset array
            GameOfLifeGrid grid = fileConverter.fileConvert(path);
            
        } catch (Exception e) {
            // TODO: handle exception
            Assert.assertTrue(e instanceof FileNotFoundException);
        }
    }
    
    @Test
    public void test() {
        try {
            GameOfLifeGrid gameOfLifeGrid = fileConverter.fileConvert(path);
            
            Assert.assertNotNull(gameOfLifeGrid);
            System.out.println(gameOfLifeGrid);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
    
    // private void print(List<BitSet> grid) {
    // for (BitSet s : grid) {
    // for (int i = 0; i < s.length(); i++) {
    // if (s.get(i)) {
    // System.out.print('*');
    // } else {
    // System.out.print('0');
    // }
    // }
    // System.out.println();
    // }
    //
    // }
    
}
