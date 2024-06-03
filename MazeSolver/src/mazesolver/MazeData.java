/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

/**
 *
 * @author karas
 */
public class MazeData {
    
    public int getRows() {
        return rows;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }
    public void setCols(int cols) {
        this.cols = cols;
    }

    public MazeElement getStartElement() {
        return startElement;
    }

    public MazeElement getEndElement() {
        return endElement;
    }

    public void setStartElement(MazeElement newStartElement) {
        if (startElement == null)
            startElement = newStartElement;
        else {
            int row = startElement.getRow();
            int col = startElement.getCol();
            
            if (! hasExit(newStartElement)) {
                throw new IllegalArgumentException("Invalid startElement position - impossible to move");
            }
            
            if (newStartElement.equals(this.endElement)) {
                throw new IllegalArgumentException("Invalid startElement position - equals endElement");
            }
            
            if (row == 0 || row == rows -1 || col == 0 || col == cols-1 ||(row %2 == 0 && col %2 == 0))
                elementsArray[row][col].setMazeCellType(MazeElementType.WALL);
            else
                elementsArray[row][col].setMazeCellType(MazeElementType.PATH);
            
            startElement = newStartElement;
            startElement.setMazeCellType(MazeElementType.START);
        }
    }

    public void setEndElement(MazeElement newEndElement) {
        if (this.endElement == null)
            this.endElement = newEndElement;
        else {
            int row = endElement.getRow();
            int col = endElement.getCol();
            
            if (! hasExit(newEndElement)) {
                throw new IllegalArgumentException("Invalid endElement position - impossible to move");
            }
            
            if (newEndElement.equals(this.startElement)) {
                throw new IllegalArgumentException("Invalid endElement position - equals startElement");
            }
            
            if (row == 0 || row == rows -1 || col == 0 || col == cols-1 ||(row %2 == 0 && col %2 == 0))
                elementsArray[row][col].setMazeCellType(MazeElementType.WALL);
            else
                elementsArray[row][col].setMazeCellType(MazeElementType.PATH);
            
            endElement = newEndElement;
            endElement.setMazeCellType(MazeElementType.END); 
        }
    }
    
    public MazeElement getArrayElement(int row, int col) {
        if(row < 0 || row >= rows || col < 0 || col >= cols)
            return null;
        
        return elementsArray[row][col];
    }
    
    public void setArrayElement(int row, int col, MazeElement arrayElement) {
        this.elementsArray[row][col] = arrayElement;
    }
    
    public void setElementsArray(MazeElement[][] elementsArray) {
        this.elementsArray = elementsArray;
    }
     public void forgetFoundPath() {
        for (int i = 0; i < rows; i++) 
            for (int j = 0; j < cols; j++)  {
                elementsArray[i][j].setIsVisited(false);
                if (elementsArray[i][j].getMazeElementType() == MazeElementType.FOUND_PATH)
                    elementsArray[i][j].setMazeCellType(MazeElementType.PATH);
            }
    }

     private boolean hasExit(MazeElement mazeElement) {
        int row = mazeElement.getRow();
        int col = mazeElement.getCol();

        return isPath(row + 1, col) || isPath(row - 1, col) || isPath(row, col + 1) || isPath(row, col - 1);
    }

    private boolean isPath(int row, int col) {
        MazeElement element = getArrayElement(row, col);
        return element != null && element.getMazeElementType() == MazeElementType.PATH;
    }
     
    private int rows;
    private int cols;
    private MazeElement startElement;
    private MazeElement endElement; 
    private MazeElement[][] elementsArray;    

}
