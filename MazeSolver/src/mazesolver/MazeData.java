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

    public void setStartElement(MazeElement startElement) {
        this.startElement = startElement;
    }

    public void setEndElement(MazeElement endElement) {
        this.endElement = endElement;
    }
    
    private int rows;
    private int cols;
    private MazeElement startElement;
    private MazeElement endElement; 
    public MazeElement[][] elementsArray;
    
}
