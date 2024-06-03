/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

/**
 *
 * @author pawel
 */


import java.util.LinkedList;

public class MazeSaverObserver implements FilePathObserver {
    private LinkedList<MazeElement> pathList;

    public MazeSaverObserver(LinkedList<MazeElement> pathList) {
        this.pathList = pathList;
    }

    @Override
    public void updateFilePath(String filePath) {
        MazeSaver saver = MazeSaverFactory.getMazeSaver(filePath);
            saver.saveToFile(pathList);

        }
    }


