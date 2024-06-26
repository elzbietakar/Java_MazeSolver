/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

/**
 *
 * @author pawel
 */

import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryMazeSaver extends MazeSaver {

    private final String filePath;

    public BinaryMazeSaver(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void saveToFile(PathData pathData) {
        try (FileOutputStream fos = new FileOutputStream(filePath, true)) {
            if (pathData.size() != 0) {
                writeSolutionHeader(fos);

                if (pathData.size() > 1) {
                    Direction currentDirection = determineDirection(pathData.get(0), pathData.get(1));
                    int steps = 1;

                    for (int i = 1; i < pathData.size() - 1; i++) {
                        Direction nextDirection = determineDirection(pathData.get(i), pathData.get(i + 1));
                        if (nextDirection == currentDirection) {
                            steps++;
                        } else {
                            writeStep(fos, currentDirection, steps);
                            currentDirection = nextDirection;
                            steps = 1;
                        }
                    }
                    writeStep(fos, currentDirection, steps);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeSolutionHeader(FileOutputStream fos) throws IOException {
        writeInt(fos, 0x52524243); 
        fos.write(0);
    }

    private void writeStep(FileOutputStream fos, Direction direction, int steps) throws IOException {
        fos.write(convertDirectionToByte(direction));
        fos.write(steps - 1); // 0 means one step, so subtract 1
    }

    private byte convertDirectionToByte(Direction direction) {
        switch (direction) {
            case UP:
                return 'N';
            case DOWN:
                return 'S';
            case LEFT:
                return 'W';
            case RIGHT:
                return 'E';
            default:
                throw new IllegalArgumentException("Invalid direction");
        }
    }

    private Direction determineDirection(MazeElement from, MazeElement to) {
        if (from.getRow() - 1 == to.getRow()) {
            return Direction.UP;
        } else if (from.getRow() + 1 == to.getRow()) {
            return Direction.DOWN;
        } else if (from.getCol() - 1 == to.getCol()) {
            return Direction.LEFT;
        } else if (from.getCol() + 1 == to.getCol()) {
            return Direction.RIGHT;
        }
        throw new IllegalArgumentException("Invalid path: non-adjacent elements");
    }

    private void writeInt(FileOutputStream fos, int value) throws IOException {
        fos.write((value) & 0xFF);
        fos.write((value >> 8) & 0xFF);
        fos.write((value >> 16) & 0xFF);
        fos.write((value >> 24) & 0xFF);
    }

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
}

