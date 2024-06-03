/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mazesolver;
import java.util.LinkedList;
import javax.swing.SwingUtilities;

/**
 *
 * @author karas
 */
public class MazeSolver {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MazeData mazeData = new MazeData();
        MazeReaderObserver observer = new MazeReaderObserver(mazeData);
        PathData pathData = new PathData();
        //LinkedList<MazeElement> pathList = new LinkedList<>();
        PathFinder pathFinder = new PathFinder();
        new Thread(new TerminalInputListener(observer)).start();
        SwingUtilities.invokeLater(() -> new BackgroundFrame(observer, mazeData, pathData, pathFinder).setVisible(true));
              
    }
    
}
