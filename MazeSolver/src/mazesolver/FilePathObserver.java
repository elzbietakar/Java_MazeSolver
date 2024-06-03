/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

import java.io.IOException;

/**
 *
 * @author pawel
 */
public interface FilePathObserver {
    void updateFilePath(String filePath) throws IOException;
}
