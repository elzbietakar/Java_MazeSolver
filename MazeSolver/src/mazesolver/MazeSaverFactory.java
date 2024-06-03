/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

/**
 *
 * @author pawel
 */


public class MazeSaverFactory {
    public static MazeSaver getMazeSaver(String filePath) {
        if (filePath.endsWith(".bin")) {
            return new BinaryMazeSaver(filePath);
        } else {
            return new MazeSaver();
        }
    }
}
