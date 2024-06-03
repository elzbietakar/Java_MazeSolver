/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mazesolver;

/**
 *
 * @author karas
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MazeSaver {

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public void saveToFile(PathData pathData) {
        File file = new File("savedPath.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("START\n");
            if (pathData.size() > 1) {
                Direction currentDirection = determineDirection(pathData.get(0), pathData.get(1));
                int steps = 1;

                for (int i = 1; i < pathData.size() - 1; i++) {
                    Direction nextDirection = determineDirection(pathData.get(i), pathData.get(i + 1));
       
                    if (nextDirection == currentDirection) {
                        steps++;
                    } else {
                        writer.write("FORWARD " + steps + "\n");
                        writer.write(determineTurn(currentDirection, nextDirection) + "\n");
                        currentDirection = nextDirection;
                        steps = 1;
                    }
                }
                writer.write("FORWARD " + steps + "\n");
            }
            writer.write("STOP\n");
            
            System.out.println("Path saved to: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
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

    private String determineTurn(Direction current, Direction next) {
        switch (current) {
            case UP:
                return next == Direction.LEFT ? "TURNLEFT" : "TURNRIGHT";
            case DOWN:
                return next == Direction.RIGHT ? "TURNLEFT" : "TURNRIGHT";
            case LEFT:
                return next == Direction.DOWN ? "TURNLEFT" : "TURNRIGHT";
            case RIGHT:
                return next == Direction.UP ? "TURNLEFT" : "TURNRIGHT";
            default:
                throw new IllegalArgumentException("Invalid direction");
        }
    }
}
