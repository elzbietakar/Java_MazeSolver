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
    public void updateFilePath(String filePath) {
        MazeReader reader = MazeReaderFactory.getMazeReader(filePath);
        try {
            reader.read(mazeData);
            // Process the mazeData as needed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

