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
    private MazeReaderObserver observer;

    public TerminalInputListener(MazeReaderObserver observer) {
        this.observer = observer;
    }

    @Override
    public void run() {
        try {
            BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));
            String filePath;
            while ((filePath = terminalReader.readLine()) != null) {
             
                String finalFilePath = filePath.replace("\"", "");
                System.out.println("Terminal: uploaded file " + finalFilePath);
                
                try {
                    observer.updateFilePath(finalFilePath);
                } catch (IOException ex) {System.err.println(ex);}
            }
        } catch (IOException ex) {}
    }
}
