/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author pawel
 */
public class MazeReader {

    public MazeReader(String filePath) {
        this.filePath = filePath;
    }

    public void read(MazeData mazeData) throws IOException {
        String line;
        int row = 0;
        int col = 0;
        
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                if (row == 0)
                    col = line.length();
           
                row++;
            }
            mazeData.setRows(row);
            mazeData.setCols(col);
        reader.close();
        
        mazeData.elementsArray = new MazeElement[row][col];
         
        row = 0;
        reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                for (col = 0; col < line.length(); col++) {
                    char symbol = line.charAt(col);
                    mazeData.elementsArray[row][col] = new MazeElement(row, col, symbol);
                    if (mazeData.elementsArray[row][col].getType()== Type.START){
                        mazeData.setStartElement(mazeData.elementsArray[row][col]);
                    }
                    if (mazeData.elementsArray[row][col].getType()== Type.STOP){
                        mazeData.setEndElement(mazeData.elementsArray[row][col]);
                    }
                }
                row++;
            }
        reader.close();
    }
    
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
    
    private final String filePath;
    private int rows;
    private int cols;  
}
