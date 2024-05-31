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
                if (col == 0)
                    row = line.length();
                col++;
            }
            mazeData.setRows(row);
            mazeData.setCols(col);
        reader.close();
        
        mazeData.setElementsArray(new MazeElement[row][col]);
         
        col = 0;
        reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                for (row = 0; row < line.length(); row++) {
                    char symbol = line.charAt(row);
                    mazeData.setArrayElement(row, col, new MazeElement(row, col, symbol));
                    if (mazeData.getArrayElement(row, col).getMazeElementType()== MazeElementType.START){
                        mazeData.setStartElement(mazeData.getArrayElement(row, col));
                    }
                    if (mazeData.getArrayElement(row, col).getMazeElementType()== MazeElementType.END){
                        mazeData.setEndElement(mazeData.getArrayElement(row, col));
                    }
                }
                col++;
            }
        reader.close();
    }
  
    protected final String filePath;
}
