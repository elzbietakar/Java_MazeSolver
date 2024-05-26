/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.SwingUtilities;

/**
 *
 * @author karas
 */
 public class TerminalInputListener implements Runnable {
    private final BackgroundFrame backgroundFrame;

    public TerminalInputListener(BackgroundFrame backgroundFrame) {
        this.backgroundFrame = backgroundFrame;
    }

    @Override
    public void run() {
        try {
            BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));
            String filePath;
            while ((filePath = terminalReader.readLine()) != null) {
                String finalFilePath = filePath.replace("\"", "");
                System.out.println("Terminal: Wybrano plik " + filePath);
                SwingUtilities.invokeLater(() -> {
                    MazeReader mr = new MazeReader(finalFilePath);
                    MazeData mazeData = new MazeData();
                    try {
                        mr.read(mazeData);
                    } catch (IOException e) {
                        System.out.println("IOException => " + e.getMessage());
                    }

                    MazePanel mazePanel = new MazePanel(mazeData);
                    backgroundFrame.drawMazeVisualizationPanel(mazePanel);
                });
            }
        } catch (IOException ex) {}
    }
}
