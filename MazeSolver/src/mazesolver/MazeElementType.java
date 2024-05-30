/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package mazesolver;

/**
 *
 * @author karas
 */

import java.awt.Color;
import java.awt.Graphics;

public enum MazeElementType {
    WALL (new Color(234,112,44)),
    PATH (Color.WHITE),
    START (new Color(43, 138, 106)),
    END (new Color (117, 35, 157)),
    FOUND_PATH (new Color (164, 48, 63));

    private final Color color;

    MazeElementType(Color color) {
        this.color = color;
    }

    public void paintCell(Graphics cell, int i, int j, int cellSize) {
        cell.setColor(color);
        cell.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
    }
}
