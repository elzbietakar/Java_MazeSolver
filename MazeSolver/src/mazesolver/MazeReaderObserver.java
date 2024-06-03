/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

/**
 *
 * @author pawel
 */
import java.io.IOException;

public class MazeReaderObserver implements FilePathObserver {
    private MazeData mazeData;

    public MazeReaderObserver(MazeData mazeData) {
        this.mazeData = mazeData;
    }

    @Override
    public void updateFilePath(String filePath) throws IOException {
        MazeReader reader = MazeReaderFactory.getMazeReader(filePath);
        
        reader.read(mazeData);
    }
}

