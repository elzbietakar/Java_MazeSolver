/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import java.io.File;

/**
 *
 * @author karas
 */
public class MazeReader {
    public MazeReader (File inputFile) {
        this.inputFile = inputFile;
        
    }
    
       
    
    
    private final File inputFile;
    private int rows;
    private int cols;
    private char[][] dataArray;
}
