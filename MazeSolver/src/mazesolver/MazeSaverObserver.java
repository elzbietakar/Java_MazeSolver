/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

/**
 *
 * @author pawel
 */
public class MazeSaverObserver implements FilePathObserver {
    private PathData pathData;

    public MazeSaverObserver(PathData pathData) {
        this.pathData = pathData;
    }

    @Override
    public void updateFilePath(String filePath) {
        MazeSaver saver = MazeSaverFactory.getMazeSaver(filePath);
            saver.saveToFile(pathData);
        }
    }


