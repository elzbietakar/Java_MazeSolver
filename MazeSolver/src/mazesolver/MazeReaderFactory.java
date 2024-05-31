/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

/**
 *
 * @author pawel
 */
public class MazeReaderFactory {
    public static MazeReader getMazeReader(String filePath) {
        if (filePath.endsWith(".bin")) {
            return new BinaryMazeReader(filePath);
        } else {
            return new MazeReader(filePath);
        }
    }
}
