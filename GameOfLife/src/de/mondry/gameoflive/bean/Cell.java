package de.mondry.gameoflive.bean;

public class Cell {
    
    private int rowIndex;
    private int indexOfCell;
    private int numberOfNeighbours = 0;
    private boolean isAlive = false;
    
    public Cell(int rowIndex, int indexOfCell) {
        this.rowIndex = rowIndex;
        this.indexOfCell = indexOfCell;
    }
    
    public int getRowIndex() {
        return rowIndex;
    }
    
    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }
    
    public int getIndexOfCell() {
        return indexOfCell;
    }
    
    public void setIndexOfCell(int indexOfCell) {
        this.indexOfCell = indexOfCell;
    }
    
    public int getNumberOfNeighbours() {
        return numberOfNeighbours;
    }
    
    public void setNumberOfNeighbours(int numberOfNeighbours) {
        this.numberOfNeighbours = numberOfNeighbours;
    }
    
    public boolean isAlive() {
        return isAlive;
    }
    
    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    
    public void incrementNeighbour() {
        numberOfNeighbours++;
    }
    
    /**
     * copies all but neighbours count. This must be fresh in each round!
     * 
     * @return
     */
    public Cell copyMe() {
        Cell cell = new Cell(rowIndex, indexOfCell);
        cell.setAlive(isAlive);
        // cell.numberOfNeighbours = numberOfNeighbours;
        return cell;
    }
    
    /**
     * for easier use to insert in map
     * 
     * @return
     */
    public String getKey() {
        return String.valueOf(rowIndex) + '/' + String.valueOf(indexOfCell);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + indexOfCell;
        result = prime * result + (isAlive ? 1231 : 1237);
        result = prime * result + rowIndex;
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
        Cell other = (Cell) obj;
        if (indexOfCell != other.indexOfCell)
            return false;
        if (isAlive != other.isAlive)
            return false;
        if (rowIndex != other.rowIndex)
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "Cell [isAlive=" + isAlive + "]";
    }
    
}
